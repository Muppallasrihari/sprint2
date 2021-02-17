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
	
/***-----------------------------------Customer-Exception-Handler-Section-----------------------------*/	
	@ExceptionHandler
	public ResponseEntity<Object>handleCustomerNameException(CustomerException ex,WebRequest request){
		CustomerExceptionResponse customerExceptionResponse=new CustomerExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(customerExceptionResponse,HttpStatus.BAD_REQUEST);
	}
/**---------------------------------------------------------------------------------------------------**/

/**-------------------------------------Diet-Plan-Exception-Handler-Section---------------------------**/
	@ExceptionHandler
	public ResponseEntity<Object> handleDietPlanException(DietPlanException ex, WebRequest request){
		DietPlanExceptionResponse dietPlanExceptionResponse =  new DietPlanExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(dietPlanExceptionResponse,HttpStatus.BAD_REQUEST);
	}	
/**---------------------------------------------------------------------------------------------------**/

	
	@ExceptionHandler
	public ResponseEntity<Object> handleNutritionIdException(NutritionIdException ex,WebRequest request){
		NutritionIdExceptionResponse nutritionIdExceptionResponse=new NutritionIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object> (nutritionIdExceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<Object> handleCaloriesLogIdException(CaloriesLogIdException ex,WebRequest request){
		CaloriesLogIdExceptionResponse caloriesLogIdExceptionResponse=new CaloriesLogIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(caloriesLogIdExceptionResponse,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<Object> handleWeightLogIdException(WeightLogIdException ex,WebRequest request)
	{
		WeightLogIdExceptionResponse weightLogIdExceptionResponse=new WeightLogIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(weightLogIdExceptionResponse,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public ResponseEntity<Object> handleExerciseIdException(ExerciseIdException exIdException, WebRequest request){
		ExerciseIdExceptionResponse exerciseIdExceptionResponse = new ExerciseIdExceptionResponse(exIdException.getMessage());
		return new ResponseEntity<Object>(exerciseIdExceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
}
     