package com.cg.capbook.services;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.beans.Profile;
import com.cg.capbook.daoservices.ProfileDAO;
import com.cg.capbook.exceptions.EmailAlreadyUsedException;
import com.cg.capbook.exceptions.InvalidEmailIdException;
import com.cg.capbook.exceptions.InvalidPasswordException;
@Component("capBookServices")
public class CapBookServicesImpl implements CapBookServices {
	@Autowired
	private ProfileDAO profileDAO;
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
		return profile1;
	}
	@Override
	public Profile editProfile(Profile profile) throws InvalidEmailIdException {
		Profile profile1=profileDAO.findById(profile.getEmailId()).orElseThrow(()->new InvalidEmailIdException());
		profileDAO.save(profile);
		return profile;
	}
}
