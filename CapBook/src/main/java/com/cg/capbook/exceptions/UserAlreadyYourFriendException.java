package com.cg.capbook.exceptions;
@SuppressWarnings("serial")
public class UserAlreadyYourFriendException extends Exception {
	public UserAlreadyYourFriendException() {
		super();
	}
	public UserAlreadyYourFriendException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	public UserAlreadyYourFriendException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	public UserAlreadyYourFriendException(String arg0) {
		super(arg0);
	}
	public UserAlreadyYourFriendException(Throwable arg0) {
		super(arg0);
	}
}
