package com.cg.healthify.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)                                
public class PaymentNameException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PaymentNameException() {
		super();
	}
	public PaymentNameException(String e) {
		super(e);
	}
}
