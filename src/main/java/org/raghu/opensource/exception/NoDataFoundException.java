package org.raghu.opensource.exception;

public class NoDataFoundException extends RuntimeException {

	public NoDataFoundException() {
	}
	
	public NoDataFoundException(String message){
		super(message);
	}
}
