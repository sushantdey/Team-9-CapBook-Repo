package com.cg.capbook.services;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.capbook.beans.Comment;
import com.cg.capbook.beans.Friend;
import com.cg.capbook.beans.Message;
import com.cg.capbook.beans.Notification;
import com.cg.capbook.beans.Post;
import com.cg.capbook.beans.Profile;
import com.cg.capbook.daoservices.FriendDAO;
import com.cg.capbook.daoservices.MessageDAO;
import com.cg.capbook.daoservices.NotificationDAO;
import com.cg.capbook.daoservices.PostDAO;
import com.cg.capbook.daoservices.ProfileDAO;
import com.cg.capbook.exceptions.EmailAlreadyUsedException;
import com.cg.capbook.exceptions.FriendshipAlreadyExistsException;
import com.cg.capbook.exceptions.InvalidEmailIdException;
import com.cg.capbook.exceptions.InvalidPasswordException;
import com.cg.capbook.exceptions.NoUserFoundException;
import com.cg.capbook.exceptions.RequestAlreadyReceivedException;
import com.cg.capbook.exceptions.RequestAlreadySentException;
import com.cg.capbook.exceptions.UserAuthenticationFailedException;
@Component("capBookServices")
public class CapBookServicesImpl implements CapBookServices {
	@Autowired
	private ProfileDAO profileDAO;
	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	private FriendDAO friendDAO;
	@Autowired
	private PostDAO postDAO;
	@Autowired
	private CodecServices codecServices;
	@Autowired
	private NotificationDAO notificationDAO;
	static String sessionEmailId;
	@Override
	public Profile registerUser(Profile profile) throws EmailAlreadyUsedException {
		if(profileDAO.findById(profile.getEmailId()).isPresent())
			throw new EmailAlreadyUsedException();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		Date today = new Date();
		profile.setDateOfJoining(formatter.format(today).toString());
		profile.setPassword(codecServices.encrypt(profile.getPassword()));
		System.out.println(profile.getPassword());
		profile= profileDAO.save(profile);
		profile.setProfilePic(null);
		return profile;
	}
	@Override
	public Profile loginUser(Profile profile) throws InvalidEmailIdException, InvalidPasswordException {
		Profile profile1=profileDAO.findById(profile.getEmailId()).orElseThrow(()->new InvalidEmailIdException());
		if(!codecServices.decrypt(profile1.getPassword()).equals(profile.getPassword()))
			throw new InvalidPasswordException();
		sessionEmailId=profile.getEmailId();
		profile.setProfilePic(null);
		return profile1;
	}
	@Override
	public Profile logout() {
		sessionEmailId=null;
		return null;
	}
	@Override
	public String forgotPassword(String emailId,String securityQuestion,String securityAnswer) throws InvalidEmailIdException, UserAuthenticationFailedException{
		Profile profile=profileDAO.findById(emailId).orElseThrow(()->new InvalidEmailIdException());
		if(securityQuestion.equals(profile.getSecurityQuestion()) && securityAnswer.equals(profile.getSecurityAnswer()))
			return codecServices.decrypt(profile.getPassword());
		else
			throw new UserAuthenticationFailedException();	
	}
	@Override
	public Profile changePassword(String password) throws InvalidEmailIdException, InvalidPasswordException{
		Profile profile=profileDAO.findById(sessionEmailId).orElseThrow(()->new InvalidEmailIdException());
		profileDAO.changePassword(codecServices.encrypt(password),sessionEmailId);
		profile.setPassword(password);
		profile.setProfilePic(null);
		return profile;
	}
	@Override
	public Profile editProfile(Profile profile) throws InvalidEmailIdException {
		Profile profile1=profileDAO.findById(sessionEmailId).orElseThrow(()->new InvalidEmailIdException());
		if(!profile.getCurrentCity().isEmpty())
			profile1.setCurrentCity(profile.getCurrentCity());
		if(!profile.getHighestEducation().isEmpty())
			profile1.setHighestEducation(profile.getHighestEducation());
		if(!profile.getRelationshipStatus().isEmpty())
			profile1.setRelationshipStatus(profile.getRelationshipStatus());
		if(!profile.getUserBio().isEmpty())
			profile1.setUserBio(profile.getUserBio());
		if(!profile.getDesignation().isEmpty())
			profile1.setDesignation(profile.getDesignation());
		profile= profileDAO.save(profile1);
		profile.setProfilePic(null);
		Notification notification = new Notification();
		notification.setNotificationMessage(profile.getFirstName()+" updated profile");
		notification.setNotificationType("Profile Update");
		notification.setSeenStatus(false);
		//List<Profile> friends = profile1.getF
		//notification.set
		//notificationDAO.save(notification);
		return profile;
	}
	@Override
	public List<Profile> searchAllUsersByName(String userName) throws  NoUserFoundException{
		List<Profile> listUser=profileDAO.searchAllUserByName(userName.toLowerCase());
		for (Profile profile : listUser) 
			profile.setProfilePic(null);
		if(listUser.isEmpty())
			throw new NoUserFoundException();
		return listUser;
	}
	@Override
	public Friend addFriend(String toUserId) throws FriendshipAlreadyExistsException, RequestAlreadyReceivedException, RequestAlreadySentException {
		String fromUserId=sessionEmailId;
		Friend friend=friendDAO.checkFriendship(fromUserId,toUserId);
		Friend friend1=friendDAO.checkFriendship(toUserId,fromUserId);
		if(friend==null && friend1==null){
			friend=new Friend(toUserId,fromUserId);
			friend.setFriendshipStatus(false);
			friend=friendDAO.save(friend);
			Profile profile=profileDAO.findById(fromUserId).get();
			Map<Integer, Friend> friendMap=new HashMap<>(profile.getFriends());
			friendMap.put(friend.getFriendId(), friend);
			profile.setFriends(friendMap);
			profileDAO.save(profile);
			/*friendMap=null;
			profile=profileDAO.findById(toUserId).get();
			friendMap=profile.getFriends();
			friendMap.put(friend.getFriendId(), friend);
			profile.setFriends(friendMap);
			profileDAO.save(profile);*/
		}
		else if(friend==null && friend1!=null)
			throw new RequestAlreadyReceivedException();
		else if(friend!=null && friend1==null)
			throw new RequestAlreadySentException();
		else
			throw new FriendshipAlreadyExistsException();
		return friend;
	}
	@Override
	public List<Profile> viewFriendRequests() {
		List<Profile> profiles = new ArrayList<>();
		List<Friend> friends = friendDAO.viewFriendRequests(sessionEmailId,false);
		for (Friend friend : friends) {
			Profile profile = profileDAO.findById(friend.getFromUserId()).get();
			profiles.add(profile);
		}
		return profiles;
	}
	@Override
	public Friend acceptFriend(String fromUserId,String toUserId) throws RequestAlreadySentException {
		Friend friend=friendDAO.checkFriendship(fromUserId,toUserId);
		Profile profile=profileDAO.findById(toUserId).get();
		Map<Integer, Friend> friendMap=new HashMap<>(profile.getFriends());
		friendMap.put(friend.getFriendId(), friend);
		profile.setFriends(friendMap);
		profileDAO.save(profile);
		return friend;
	}
	@Override
	public Friend rejectFriend(String fromUserId,String toUserId) throws RequestAlreadySentException {
		Friend friend=friendDAO.checkFriendship(fromUserId,toUserId);
		Profile profile=profileDAO.findById(fromUserId).get();
		Map<Integer, Friend> friendMap=new HashMap<>(profile.getFriends());
		friendMap.remove(friend.getFriendId(),friend);
		profileDAO.save(profile);
		friendDAO.deleteById(friend.getFriendId());
		return null;
	}
	@Override
	public List<Profile> getFriendList(){
		String emailId=sessionEmailId;
		Profile profile=profileDAO.findById(emailId).get();
		Profile friendProfile;
		Map<Integer, Friend> friendMap=new HashMap<>();
		friendMap=profile.getFriends();
		List<Friend> friendList=new ArrayList<>(friendMap.values());
		//List<Friend> friendList2=new ArrayList<>();
		List<Profile> friendProfiles=new ArrayList<>();
		for(Friend friend:friendList) {
			//Friend friend=friendDAO.findById(friends.getFriendId()).get();
			if(friend.getFromUserId().equals(emailId)) 
				friendProfile=profileDAO.findById(friend.getToUserId()).get();
			//friendList2.add(friend);
			else//(friend.getToUserId().equalsIgnoreCase(emailId))
				//friendList2.add(friend);
				friendProfile=profileDAO.findById(friend.getFromUserId()).get();
			friendProfile.setProfilePic(null);
			friendProfiles.add(friendProfile);
		}
		return friendProfiles;
	}
	@Override
	public void sendMessage(Message message) {
		message.setSenderEmailId(sessionEmailId);
		messageDAO.save(message);
	}
	@Override
	public List<Message> viewSentMessages() {
		List<Message> messages =  messageDAO.findMessagesBySender(sessionEmailId);
		Profile profile;
		for (Message message : messages) {
			profile = profileDAO.findById(message.getReceiverEmailId()).get();
			message.setReceiverEmailId(profile.getFirstName()+" "+profile.getLastName());
		}
		return messages;
	}
	@Override
	public List<Message> viewReceivedMessages() {
		List<Message> messages =  messageDAO.findMessagesByReceiver(sessionEmailId);
		Profile profile;
		for (Message message : messages) {
			profile = profileDAO.findById(message.getSenderEmailId()).get();
			message.setSenderEmailId(profile.getFirstName()+" "+profile.getLastName());
		}
		return messages; 
	}
	@Override
	public Profile getProfile(String emailId) throws InvalidEmailIdException {
		Profile profile=profileDAO.findById(emailId).orElseThrow(()->new InvalidEmailIdException());
		profile.setProfilePic(null);
		return profile;
	}
	@Override
	public Profile insertProfilePic(byte[] profilePic) {
		Profile profile=profileDAO.findById(sessionEmailId).get();
		profile.setProfilePic(profilePic);
		profile = profileDAO.save(profile);
		profile.setProfilePic(null);
		return profile;
	}
	@Override
	public byte[] fetchProfilePic() {
		Profile profile=profileDAO.findById(sessionEmailId).get();
		return profile.getProfilePic();
	}
	@Override
	public Post createPost(Post post) {
		post.setEmailId(sessionEmailId);
		postDAO.save(post);
		return post;
	}
	@Override
	public Post updatePostLikes(Post post) {
		Post oldPost=postDAO.findById(post.getPostId()).get();
		post.setNoOfPostLikes(oldPost.getNoOfPostLikes()+1);
		return postDAO.save(post);
	}
	@Override
	public Post updatePostDislikes(Post post) {
		Post oldPost=postDAO.findById(post.getPostId()).get();
		post.setNoOfPostLikes(oldPost.getNoOfPostDislikes()+1);
		return postDAO.save(post);
	}
	@Override
	public Post addPostComment(Comment comment) {
		//Post oldPost=postDAO.findById(comment.getPostId()).get();
		//Map<Integer, Comment> commentMap=new HashMap<>(oldPost.getComments());
		//commentMap.put(post.getComments()., value)
		return null;
	}
	@Override
	public List<Post> getPosts() {
		List<Post> posts=postDAO.findAllByEmail(sessionEmailId);
		return posts;
	}
	@Override
	public List<Notification> getNotifications() {
		List<Notification> notifications = notificationDAO.getNotifications(sessionEmailId,false);
		for (Notification notification : notifications) {
			notification.setSeenStatus(true);
			notificationDAO.save(notification);
		}
		return notifications;
	}
	
}
