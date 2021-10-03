package org.raghu.opensource.exception;

public class CityNotFoundException extends RuntimeException {
	
	public CityNotFoundException() {
	}

	public CityNotFoundException(Long id) {
		super("Id not found exception "+ id);
	}
	
	
	
}
