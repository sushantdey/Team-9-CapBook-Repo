package com.cg.capbook.exceptions;
@SuppressWarnings("serial")
public class NoUserFoundException extends Exception {
	public NoUserFoundException() {
		super();
	}
	public NoUserFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}
	public NoUserFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
	public NoUserFoundException(String arg0) {
		super(arg0);
	}
	public NoUserFoundException(Throwable arg0) {
		super(arg0);
	}
}
