package com.cg.capbook.exceptions;
@SuppressWarnings("serial")
public class RequestAlreadyReceivedException extends Exception {
	public RequestAlreadyReceivedException() {
		super();
	}
	public RequestAlreadyReceivedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public RequestAlreadyReceivedException(String message, Throwable cause) {
		super(message, cause);
	}
	public RequestAlreadyReceivedException(String message) {
		super(message);
	}
	public RequestAlreadyReceivedException(Throwable cause) {
		super(cause);
	}
}
