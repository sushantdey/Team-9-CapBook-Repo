package com.cg.capbook.services;
import java.util.List;
import com.cg.capbook.beans.Message;
import com.cg.capbook.beans.Profile;
import com.cg.capbook.exceptions.EmailAlreadyUsedException;
import com.cg.capbook.exceptions.InvalidEmailIdException;
import com.cg.capbook.exceptions.InvalidPasswordException;
import com.cg.capbook.exceptions.NoUserFoundException;
import com.cg.capbook.exceptions.UserAlreadyYourFriendException;
public interface CapBookServices {
	void registerUser(Profile profile) throws EmailAlreadyUsedException, EmailAlreadyUsedException;
	Profile loginUser(Profile profile) throws InvalidEmailIdException,InvalidPasswordException;
	Profile editProfile(Profile profile) throws InvalidEmailIdException;
	List<Profile> searchAllUsersByName(String userName) throws  NoUserFoundException;
	void friendRequest(String emailId) throws UserAlreadyYourFriendException;
	void sendMessage(Message message);
	List<Message> viewSentMessages(String emailId);
	List<Message> viewReceivedMessages(String emailId);
}
