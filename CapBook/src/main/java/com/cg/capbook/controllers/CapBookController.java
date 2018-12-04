package com.cg.capbook.controllers;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.capbook.beans.Message;
import com.cg.capbook.beans.Profile;
import com.cg.capbook.exceptions.EmailAlreadyUsedException;
import com.cg.capbook.exceptions.InvalidEmailIdException;
import com.cg.capbook.exceptions.InvalidPasswordException;
import com.cg.capbook.exceptions.NoUserFoundException;
import com.cg.capbook.exceptions.UserAlreadyYourFriendException;
import com.cg.capbook.services.CapBookServices;
@RestController
@CrossOrigin
public class CapBookController {
	@Autowired
	private CapBookServices capBookServices;
	@RequestMapping(value="/registerUser",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> registerUser(@RequestBody Profile profile){
		try {
			capBookServices.registerUser(profile);
		} catch (EmailAlreadyUsedException e) {
			return new ResponseEntity<>("Email Already Used!!!",HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<>("Registered Successfully!!!Please Login using your credentials",HttpStatus.OK);
	}	
	@RequestMapping(value="/loginUser",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> loginUser (@RequestBody Profile profile) {
		try {
				profile=capBookServices.loginUser(profile);
			} catch (InvalidEmailIdException | InvalidPasswordException e) {
				return new ResponseEntity<String>("Invalid EmailId/Password!!!Please Try Again",HttpStatus.BAD_REQUEST);
			}
		return new ResponseEntity<String>(profile.toString(),HttpStatus.OK);
	}
	@RequestMapping(value="/editProfile",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> editProfile(@RequestBody Profile profile){	
				try {
					profile=capBookServices.editProfile(profile);
				} catch (InvalidEmailIdException e) {
					return new ResponseEntity<String>("Invalid EmailId!!!Please Try Again",HttpStatus.BAD_REQUEST);
				}
		return new ResponseEntity<String>(profile.toString(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/findUsers",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<List<Profile>> findUsers(@RequestParam String userName){	
		List<Profile>listUser=null;		
					try {
						listUser=capBookServices.searchAllUsersByName(userName);
					} catch (NoUserFoundException e) {
						return new ResponseEntity<List<Profile>>(listUser,HttpStatus.BAD_REQUEST);
					}
		return new ResponseEntity<List<Profile>>(listUser,HttpStatus.OK);
	}
	@RequestMapping(value="/addFriend",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> addFriend(@RequestParam String emailId){			
					try {
						capBookServices.friendRequest(emailId);
					} catch (UserAlreadyYourFriendException e) {
						return new ResponseEntity<String>("User is Already Your Friend!!!",HttpStatus.BAD_REQUEST);
					}
					return new ResponseEntity<String>("Friend successfully added.",HttpStatus.OK);
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
}
