package com.cg.capbook.controllers;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.cg.capbook.beans.Friend;
import com.cg.capbook.beans.Message;
import com.cg.capbook.beans.Notification;
import com.cg.capbook.beans.Post;
import com.cg.capbook.beans.Profile;
import com.cg.capbook.exceptions.EmailAlreadyUsedException;
import com.cg.capbook.exceptions.FriendshipAlreadyExistsException;
import com.cg.capbook.exceptions.InvalidEmailIdException;
import com.cg.capbook.exceptions.InvalidPasswordException;
import com.cg.capbook.exceptions.NoUserFoundException;
import com.cg.capbook.exceptions.RequestAlreadyReceivedException;
import com.cg.capbook.exceptions.RequestAlreadySentException;
import com.cg.capbook.exceptions.UserAuthenticationFailedException;
import com.cg.capbook.services.CapBookServices;
import com.cg.capbook.services.StorageService;
@RestController
@CrossOrigin
public class CapBookController {
	@Autowired
	private CapBookServices capBookServices;
	@Autowired
	private StorageService storageService;
	@RequestMapping(value="/registerUser",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Profile> registerUser(@RequestBody Profile profile) throws EmailAlreadyUsedException{
		profile=capBookServices.registerUser(profile);
		return new ResponseEntity<Profile>(profile,HttpStatus.OK);
	}	
	@RequestMapping(value="/loginUser",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Profile> loginUser (@RequestBody Profile profile) throws InvalidEmailIdException, InvalidPasswordException {
		profile=capBookServices.loginUser(profile);	
		return new ResponseEntity<Profile>(profile,HttpStatus.OK);
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Profile> loginUser () throws InvalidEmailIdException, InvalidPasswordException {
		Profile profile=capBookServices.logout();	
		System.out.println("done");
		return new ResponseEntity<Profile>(profile,HttpStatus.OK);
	}
	@RequestMapping(value="/forgotPassword",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Profile> forgotPassword(@RequestBody Profile profile) throws InvalidEmailIdException, UserAuthenticationFailedException {
		String password=capBookServices.forgotPassword(profile.getEmailId(),profile.getSecurityQuestion(),profile.getSecurityAnswer());
		profile.setPassword(password);
		return new ResponseEntity<Profile>(profile,HttpStatus.OK);
	}
	@RequestMapping(value="/changePassword",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Profile> changePassword(@RequestParam("password")String password) throws InvalidEmailIdException, InvalidPasswordException{
		Profile profile= capBookServices.changePassword(password);
		return new ResponseEntity<Profile>(profile,HttpStatus.OK);
	}
	@RequestMapping(value="/editProfile",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Profile> editProfile(@RequestBody Profile profile) throws InvalidEmailIdException{	
		profile=capBookServices.editProfile(profile);
		return new ResponseEntity<Profile>(profile,HttpStatus.OK);
	}
	@RequestMapping(value="/findUsers",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Profile>> findUsers(@RequestParam("name") String userName) throws NoUserFoundException{	
		List<Profile>listUser=null;		
		listUser=capBookServices.searchAllUsersByName(userName);
		return new ResponseEntity<List<Profile>>(listUser,HttpStatus.OK);
	}
	@RequestMapping(value="/addFriend",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Friend> addFriend(@RequestParam("toUserId") String toUserId) throws FriendshipAlreadyExistsException, RequestAlreadyReceivedException, RequestAlreadySentException{			
		Friend friend=capBookServices.addFriend(toUserId);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	@RequestMapping(value="/viewFriendRequests",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Profile>> viewFriendRequests() throws FriendshipAlreadyExistsException, RequestAlreadyReceivedException, RequestAlreadySentException{			
		List<Profile> friendRequests=capBookServices.viewFriendRequests();
		return new ResponseEntity<List<Profile>>(friendRequests,HttpStatus.OK);
	}
	@RequestMapping(value="/acceptFriend",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Friend> acceptFriend(@RequestBody Friend friend) throws FriendshipAlreadyExistsException, RequestAlreadyReceivedException, RequestAlreadySentException{			
		friend=capBookServices.acceptFriend(friend.getFromUserId(),friend.getToUserId());
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	@RequestMapping(value="/rejectFriend",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Friend> rejectFriend(@RequestBody Friend friend) throws FriendshipAlreadyExistsException, RequestAlreadyReceivedException, RequestAlreadySentException{			
		friend=capBookServices.rejectFriend(friend.getFromUserId(),friend.getToUserId());
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	@RequestMapping(value="/getFriendList",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Profile>> getFriendList() throws FriendshipAlreadyExistsException, RequestAlreadyReceivedException, RequestAlreadySentException{			
		List<Profile>friendList=capBookServices.getFriendList();
		return new ResponseEntity<List<Profile>>(friendList,HttpStatus.OK);
	}
	@RequestMapping(value="/sendMessage",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> sendMessage(@RequestParam("message") String message,@RequestParam("receiverEmailId") String receiverEmailId){
		Message sendMessage = new Message();
		sendMessage.setMessage(message);
		sendMessage.setReceiverEmailId(receiverEmailId);
		capBookServices.sendMessage(sendMessage);
		return new ResponseEntity<String>("Message sent successfully.",HttpStatus.OK);
	}
	@RequestMapping(value="/viewSentMessages",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Message>> viewSentMessages(){
		List<Message> messages=capBookServices.viewSentMessages();
		return new ResponseEntity<List<Message>>(messages,HttpStatus.OK);
	}
	@RequestMapping(value="/viewReceivedMessages",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Message>> viewReceivedMessages(){
		List<Message> messages=capBookServices.viewReceivedMessages();
		return new ResponseEntity<List<Message>>(messages,HttpStatus.OK);
	}
	@PostMapping(value="/setProfilePic",consumes= {MediaType.ALL_VALUE},produces=MediaType.ALL_VALUE)
	public ResponseEntity<byte[]> setImage(@RequestParam("Image") MultipartFile image) throws IOException {
		System.out.println("Image");
		storageService.store(image);
		//File file1=(File) storageService.loadFile(image.getOriginalFilename());
		File file=new File("D:\\java\\finalProject\\userImages"+image.getOriginalFilename());
		//System.out.println(file);
		image.transferTo(file);
		//System.out.println(file);
		FileInputStream fin=new FileInputStream(file);
		//System.out.println(file);
		byte[] bytes = StreamUtils.copyToByteArray(fin);
		capBookServices.insertProfilePic(bytes);
		System.out.println(bytes);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
	}
	@RequestMapping(value = "/getProfilePic", method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImage() throws IOException {
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(capBookServices.fetchProfilePic());
	}
	@RequestMapping(value="/getPosts",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Post>> getPosts(){			
		List<Post> posts=capBookServices.getPosts();
		return new ResponseEntity<List<Post>>(posts,HttpStatus.OK);
	}
	@RequestMapping(value="/createPost",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Post> createPost(@RequestBody Post post){		
		capBookServices.createPost(post);
		return new ResponseEntity<Post>(post,HttpStatus.OK);
	}
	@RequestMapping(value="/getNotifications",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Notification>> getNotifications(){			
		List<Notification> notifications=capBookServices.getNotifications();
		return new ResponseEntity<List<Notification>>(notifications,HttpStatus.OK);
	}
}