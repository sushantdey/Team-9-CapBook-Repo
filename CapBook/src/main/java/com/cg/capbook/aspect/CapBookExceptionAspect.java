package com.cg.capbook.aspect;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.capbook.customResponse.CustomResponse;
import com.cg.capbook.exceptions.EmailAlreadyUsedException;
import com.cg.capbook.exceptions.FriendshipAlreadyExistsException;
import com.cg.capbook.exceptions.InvalidEmailIdException;
import com.cg.capbook.exceptions.InvalidPasswordException;
import com.cg.capbook.exceptions.NoUserFoundException;
import com.cg.capbook.exceptions.RequestAlreadyReceivedException;
import com.cg.capbook.exceptions.RequestAlreadySentException;
import com.cg.capbook.exceptions.UserAlreadyYourFriendException;
import com.cg.capbook.exceptions.UserAuthenticationFailedException;
@ControllerAdvice(basePackages= {"com.cg.capbook.controllers"})
public class CapBookExceptionAspect {
	@ExceptionHandler(RequestAlreadySentException.class)
	public ResponseEntity<CustomResponse> handleRequestAlreadySentException(Exception e){
		CustomResponse response=new CustomResponse(HttpStatus.EXPECTATION_FAILED.value(),"You have Already sent Friend Request");
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
	@ExceptionHandler(EmailAlreadyUsedException.class)
	public ResponseEntity<CustomResponse> handleEmailAlreadyUsedException(Exception e){
		CustomResponse response=new CustomResponse(HttpStatus.EXPECTATION_FAILED.value(),"Oops!!!Email Already Used.Try with another Email");
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
	@ExceptionHandler(FriendshipAlreadyExistsException.class)
	public ResponseEntity<CustomResponse> handleFriendshipAlreadyExistException(Exception e){
		CustomResponse response=new CustomResponse(HttpStatus.EXPECTATION_FAILED.value(),"You are already friend with this Person!!!");
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
	@ExceptionHandler(InvalidEmailIdException.class)
	public ResponseEntity<CustomResponse> handleInvalidEmailIdException(Exception e){
		CustomResponse response=new CustomResponse(HttpStatus.EXPECTATION_FAILED.value(),"Invalid EmailId!!!Please Enter valid EmailId");
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<CustomResponse> handleInvalidPasswordException(Exception e){
		CustomResponse response=new CustomResponse(HttpStatus.EXPECTATION_FAILED.value(),"Invalid Password!!!Please Enter right Password");
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<CustomResponse> handleNoUserFoundException(Exception e){
		CustomResponse response=new CustomResponse(HttpStatus.EXPECTATION_FAILED.value(),"Oops!!!No User Found");
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
	@ExceptionHandler(RequestAlreadyReceivedException.class)
	public ResponseEntity<CustomResponse> handleRequestAlreadyReceivedException(Exception e){
		CustomResponse response=new CustomResponse(HttpStatus.EXPECTATION_FAILED.value(),"You have Already received Friend Request!!!Please Accept-:)");
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
	@ExceptionHandler(UserAlreadyYourFriendException.class)
	public ResponseEntity<CustomResponse> handleUserAlreadyYourFriendException(Exception e){
		CustomResponse response=new CustomResponse(HttpStatus.EXPECTATION_FAILED.value(),"Dost ko bhool gya!!!");
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
	@ExceptionHandler(UserAuthenticationFailedException.class)
	public ResponseEntity<CustomResponse> handleUserAuthenticationFailedException(Exception e){
		CustomResponse response=new CustomResponse(HttpStatus.EXPECTATION_FAILED.value(),"User Authentication Failed!!! Please try with valid details");
		return new ResponseEntity<>(response,HttpStatus.EXPECTATION_FAILED);
	}
}
