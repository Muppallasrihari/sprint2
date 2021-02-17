package com.cg.healthify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthify.beans.Exercise;
import com.cg.healthify.exceptions.ExercisePlanIdException;
import com.cg.healthify.repository.ExerciseRepository;

@Service
public class ExerciseServiceImpl implements ExerciseService{
	
	@Autowired
	private ExerciseRepository exerciseRepository;
	
	
	@Override
	public Exercise saveOrUpdate(Exercise exercise) {
		try {
			exercise.setExPlanIdentifier(exercise.getExPlanIdentifier().toUpperCase());
			return exerciseRepository.save(exercise);
		}
		catch(Exception e) {
			throw new ExercisePlanIdException("Exercise Plan on  "+exercise.getExPlanIdentifier().toUpperCase()+" already exists");
		}
	}
	
	@Override
	public Exercise findExerciseByExPlanIdentifier(String exPlanIdentifier) {
		Exercise exercise = exerciseRepository.findByExPlanIdentifier(exPlanIdentifier.toUpperCase());
		if(exercise == null) {
			throw new ExercisePlanIdException("Exercise plan on: "+exPlanIdentifier.toUpperCase()+" does not exist"); 
		}
		return exercise;
	}
	
	@Override
	public Iterable<Exercise> getAllExercises(){
		return exerciseRepository.findAll();
	}
	
	@Override
	public Exercise deleteExerciseByExPlanIdentifier(String exPlanIdentifier) {
		Exercise exercise = exerciseRepository.findByExPlanIdentifier(exPlanIdentifier.toUpperCase());
		if (exercise == null) {
			throw new ExercisePlanIdException("Cannot delete "+exPlanIdentifier.toUpperCase()+"'s plan as it does not exist");
		}
		exerciseRepository.delete(exercise);
		return exercise;
	}
	
	
	

}
