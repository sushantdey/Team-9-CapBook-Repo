package com.cg.capbook.customresponse;
public class CustomResponse {
	private int statusCode;
	private String responseMessage;
	public CustomResponse() {}
	public CustomResponse(int statusCode, String responseMessage) {
		super();
		this.statusCode = statusCode;
		this.responseMessage = responseMessage;
	}
	public CustomResponse(String responseMessage) {
		super();
		this.responseMessage = responseMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	@Override
	public String toString() {
		return  responseMessage ;
	}
}
