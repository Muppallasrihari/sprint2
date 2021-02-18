package com.cg.healthify.exceptions;

public class PaymentErrorResponse {

	private String name;
	
	public PaymentErrorResponse(String name) {
		super();
		this.name= name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
}
