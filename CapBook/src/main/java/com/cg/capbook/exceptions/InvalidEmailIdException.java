package com.cg.capbook.exceptions;
@SuppressWarnings("serial")
public class InvalidEmailIdException extends Exception {
	public InvalidEmailIdException() {
		super();
	}
	public InvalidEmailIdException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public InvalidEmailIdException(String message, Throwable cause) {
		super(message, cause);
	}
	public InvalidEmailIdException(String message) {
		super(message);
	}
	public InvalidEmailIdException(Throwable cause) {
		super(cause);
	}
}
