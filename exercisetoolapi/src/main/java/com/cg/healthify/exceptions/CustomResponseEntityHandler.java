package com.cg.healthify.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Object> handleExerciseIdException(ExercisePlanIdException exIdException, WebRequest request){
		ExercisePlanIdExceptionResponse exerciseIdExceptionResponse = new ExercisePlanIdExceptionResponse(exIdException.getMessage());
		return new ResponseEntity<Object>(exerciseIdExceptionResponse,HttpStatus.BAD_REQUEST);
	}

}
