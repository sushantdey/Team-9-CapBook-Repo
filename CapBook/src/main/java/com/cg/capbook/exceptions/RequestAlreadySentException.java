package com.cg.capbook.exceptions;
@SuppressWarnings("serial")
public class RequestAlreadySentException extends Exception {
	public RequestAlreadySentException() {
		super();
	}
	public RequestAlreadySentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public RequestAlreadySentException(String message, Throwable cause) {
		super(message, cause);
	}
	public RequestAlreadySentException(String message) {
		super(message);
	}
	public RequestAlreadySentException(Throwable cause) {
		super(cause);
	}
}
