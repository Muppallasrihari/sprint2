package com.cg.healthify.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthify.beans.Exercise;
import com.cg.healthify.service.ExerciseService;
import com.cg.healthify.service.MapValidationErrorService;

@RestController
@RequestMapping("/healthify/exercise")
public class ExerciseController {
	
	@Autowired
	private ExerciseService exerciseService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewExercise(@Valid @RequestBody Exercise exercise,BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) 
			return errorMap;
		Exercise ex1 = exerciseService.saveOrUpdate(exercise);
		return new ResponseEntity<Exercise>(ex1, HttpStatus.OK);
	}
	
	@GetMapping("/{exPlanIdentifier}")
	public ResponseEntity<?> getExerciseById(@PathVariable String exPlanIdentifier){
		Exercise exercise = exerciseService.findExerciseByExPlanIdentifier(exPlanIdentifier);
		return new ResponseEntity<Exercise>(exercise,HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public Iterable<Exercise> getAllExercises(){
		return exerciseService.getAllExercises();
	}
	
	@DeleteMapping("/{exPlanIdentifier}")
	public ResponseEntity<?> deleteExercise(@PathVariable String exPlanIdentifier){
		exerciseService.deleteExerciseByExPlanIdentifier(exPlanIdentifier);
		return new ResponseEntity<String> ("Project with ID "+ exPlanIdentifier.toUpperCase()+" deleted successfully", HttpStatus.OK);
	}
}
