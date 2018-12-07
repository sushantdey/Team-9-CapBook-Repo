package com.cg.capbook.controllers;
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
import com.cg.capbook.beans.Friend;
import com.cg.capbook.beans.Message;
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
@RestController
@CrossOrigin
public class CapBookController {
	@Autowired
	private CapBookServices capBookServices;

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
	@RequestMapping(value="/forgotPassword",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> forgotPassword(@RequestBody Profile profile) throws InvalidEmailIdException, UserAuthenticationFailedException {
		String password=capBookServices.forgotPassword(profile.getEmailId(),profile.getSecurityQuestion(),profile.getSecurityAnswer());
		return new ResponseEntity<String>(password,HttpStatus.OK);
	}

	@RequestMapping(value="/changePassword",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Profile> changePassword(@RequestBody Profile profile) throws InvalidEmailIdException, InvalidPasswordException {
		System.out.println("start");	
		capBookServices.changePassword(profile.getEmailId(),profile.getPassword());
		System.out.println("done");
		return new ResponseEntity<Profile>(profile,HttpStatus.OK);
	}

	@RequestMapping(value="/editProfile",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Profile> editProfile(@RequestBody Profile profile) throws InvalidEmailIdException{	
		profile=capBookServices.editProfile(profile);
		return new ResponseEntity<Profile>(profile,HttpStatus.OK);
	}

	@RequestMapping(value="/findUsers",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Profile>> findUsers(@RequestParam String userName) throws NoUserFoundException{	
		List<Profile>listUser=null;		
		listUser=capBookServices.searchAllUsersByName(userName);
		return new ResponseEntity<List<Profile>>(listUser,HttpStatus.OK);
	}
	@RequestMapping(value="/addFriend",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<Friend> addFriend(@RequestBody Friend friend) throws FriendshipAlreadyExistsException, RequestAlreadyReceivedException, RequestAlreadySentException{			
		friend=capBookServices.addFriend(friend.getFromUserId(),friend.getToUserId());
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
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
	@RequestMapping(value="/getFriendList",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Profile>> getFriendList(@RequestBody Profile profile) throws FriendshipAlreadyExistsException, RequestAlreadyReceivedException, RequestAlreadySentException{			
		List<Profile>friendList=capBookServices.getFriendList(profile.getEmailId());
		return new ResponseEntity<List<Profile>>(friendList,HttpStatus.OK);
	}
	@RequestMapping(value="/sendMessage",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> sendMessage(@RequestBody Message message){
		capBookServices.sendMessage(message);
		return new ResponseEntity<String>("Message sent successfully.",HttpStatus.OK);
	}
	@RequestMapping(value="/viewSentMessages",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Message>> viewSentMessages(@RequestParam String emailId){
		List<Message> messages=capBookServices.viewSentMessages(emailId);
		return new ResponseEntity<List<Message>>(messages,HttpStatus.OK);
	}
	@RequestMapping(value="/viewReceivedMessages",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Message>> viewReceivedMessages(@RequestParam String emailId){
		List<Message> messages=capBookServices.viewReceivedMessages(emailId);
		return new ResponseEntity<List<Message>>(messages,HttpStatus.OK);
	}

	//@RequestMapping(value = "/setProfilePic", method = RequestMethod.POST,consumes = MediaType.ALL_VALUE)
	@PostMapping(value="/setProfilePic",consumes= {MediaType.ALL_VALUE},produces=MediaType.ALL_VALUE)
	public ResponseEntity<byte[]> setImage() throws IOException {
		System.out.println("Image");
		//File file=new File(image.getOriginalFilename());
		//System.out.println(file);
		//image.transferTo(file);@RequestParam("Image") MultipartFile image
		FileInputStream fin=new FileInputStream("D:\\Users\\ADM-IG-HWDLAB1D\\Downloads\\Shirley Setia.jpg");  
		byte[] bytes = StreamUtils.copyToByteArray(fin);
		capBookServices.insertProfilePic(bytes);
		System.out.println(bytes);
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(bytes);
	}
	@RequestMapping(value = "/getProfilePic", method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
	public ResponseEntity<byte[]> getImage() throws IOException {
		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(capBookServices.fetchProfilePic());
	}
}
