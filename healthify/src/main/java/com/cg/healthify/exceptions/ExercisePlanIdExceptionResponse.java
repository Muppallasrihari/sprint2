package com.cg.healthify.exceptions;

public class ExercisePlanIdExceptionResponse {
	
	private String exPlanIdentifier;

	public ExercisePlanIdExceptionResponse(String exPlanIdentifier) {
		super();
		this.exPlanIdentifier = exPlanIdentifier;
	}

	public String getExPlanIdentifier() {
		return exPlanIdentifier;
	}

	public void setExPlanIdentifier(String exPlanIdentifier) {
		this.exPlanIdentifier = exPlanIdentifier;
	}
	
	

}
