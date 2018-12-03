package com.cg.capbook.services;

import com.cg.capbook.beans.Profile;
import com.cg.capbook.exceptions.EmailAlreadyUsedException;
import com.cg.capbook.exceptions.InvalidEmailIdException;
import com.cg.capbook.exceptions.InvalidPasswordException;

public interface CapBookServices {
	void registerUser(Profile profile) throws EmailAlreadyUsedException, EmailAlreadyUsedException;
	Profile loginUser(Profile profile) throws InvalidEmailIdException,InvalidPasswordException;
	Profile editProfile(Profile profile) throws InvalidEmailIdException;
}
