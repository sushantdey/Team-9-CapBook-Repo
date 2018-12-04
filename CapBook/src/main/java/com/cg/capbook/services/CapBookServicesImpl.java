package com.cg.capbook.services;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.cg.capbook.beans.Message;
import com.cg.capbook.beans.Profile;
import com.cg.capbook.daoservices.MessageDAO;
import com.cg.capbook.daoservices.ProfileDAO;
import com.cg.capbook.exceptions.EmailAlreadyUsedException;
import com.cg.capbook.exceptions.InvalidEmailIdException;
import com.cg.capbook.exceptions.InvalidPasswordException;
import com.cg.capbook.exceptions.NoUserFoundException;
@Component("capBookServices")
public class CapBookServicesImpl implements CapBookServices {
	@Autowired
	private ProfileDAO profileDAO;
	@Autowired
	private MessageDAO messageDAO;
	static String sessionEmailId;
	@Override
	public void registerUser(Profile profile) throws EmailAlreadyUsedException {
		if(profileDAO.findById(profile.getEmailId()).isPresent())
			throw new EmailAlreadyUsedException();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    Date today = new Date();
		profile.setDateOfJoining(formatter.format(today).toString());
		profileDAO.save(profile);
	}
	@Override
	public Profile loginUser(Profile profile) throws InvalidEmailIdException, InvalidPasswordException {
		Profile profile1=profileDAO.findById(profile.getEmailId()).orElseThrow(()->new InvalidEmailIdException());
		if(!profile.getPassword().equals(profile1.getPassword()))
			throw new InvalidPasswordException();
		sessionEmailId=profile.getEmailId();
		return profile1;
	}
	@Override
	public Profile editProfile(Profile profile) throws InvalidEmailIdException {
		Profile profile1=profileDAO.findById(profile.getEmailId()).orElseThrow(()->new InvalidEmailIdException());
		if(profile.getCurrentCity()!=null)
			profile1.setCurrentCity(profile.getCurrentCity());
		if(profile.getHighestEducation()!=null)
			profile1.setHighestEducation(profile.getHighestEducation());
		if(profile.getRelationshipStatus()!=null)
			profile1.setRelationshipStatus(profile.getRelationshipStatus());
		if(profile.getUserBio()!=null)
			profile1.setUserBio(profile.getUserBio());
		if(profile.getWorkPlace()!=null)
			profile1.setWorkPlace(profile.getWorkPlace());
		return profileDAO.save(profile1);
	}
	public List<Profile> searchAllUsersByName(String userName) throws  NoUserFoundException{
		List<Profile> listUser=profileDAO.searchAllUserByName(userName.toLowerCase());
		if(listUser.isEmpty())
			throw new NoUserFoundException();
		return listUser;
	}
	public void friendRequest(String emailId) {
		Profile friendProfile=profileDAO.findById(emailId).get();
		Profile userProfile=profileDAO.findById(sessionEmailId).get();
		Map<String, Profile> friends=new HashMap<>();
		friends.put(friendProfile.getEmailId(), friendProfile);
		userProfile.setFriends(friends);
		return ;
	}
	@Override
	public void sendMessage(Message message) {
		messageDAO.save(message);
	}
	@Override
	public List<Message> viewSentMessages(String emailId) {
		return messageDAO.findMessagesBySender(emailId);
	}
	@Override
	public List<Message> viewReceivedMessages(String emailId) {
		return messageDAO.findMessagesByReceiver(emailId);
	}
}
