package com.cg.capbook.exceptions;
@SuppressWarnings("serial")
public class FriendshipAlreadyExistsException extends Exception {
	public FriendshipAlreadyExistsException() {
		super();
	}
	public FriendshipAlreadyExistsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	public FriendshipAlreadyExistsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	public FriendshipAlreadyExistsException(String arg0) {
		super(arg0);
	}
	public FriendshipAlreadyExistsException(Throwable arg0) {
		super(arg0);
	}
}
