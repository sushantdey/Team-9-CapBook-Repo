package com.cg.capbook.controllers;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.capbook.beans.Profile;
import com.cg.capbook.exceptions.EmailAlreadyUsedException;
import com.cg.capbook.exceptions.InvalidEmailIdException;
import com.cg.capbook.exceptions.InvalidPasswordException;
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
	ResponseEntity<String> loginUser(@RequestBody Profile profile){
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
}
