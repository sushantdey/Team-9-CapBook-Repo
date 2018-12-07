package com.cg.capbook.exceptions;
@SuppressWarnings("serial")
public class UserAuthenticationFailedException extends Exception {
	public UserAuthenticationFailedException() {
		super();
	}
	public UserAuthenticationFailedException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	public UserAuthenticationFailedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	public UserAuthenticationFailedException(String arg0) {
		super(arg0);
	}
	public UserAuthenticationFailedException(Throwable arg0) {
		super(arg0);
	}
}
