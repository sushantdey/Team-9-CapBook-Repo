package com.cg.capbook.exceptions;
@SuppressWarnings("serial")
public class EmailAlreadyUsedException extends Exception {
	public EmailAlreadyUsedException() {
		super();
	}
	public EmailAlreadyUsedException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	public EmailAlreadyUsedException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	public EmailAlreadyUsedException(String arg0) {
		super(arg0);
	}
	public EmailAlreadyUsedException(Throwable arg0) {
		super(arg0);
	}
}
