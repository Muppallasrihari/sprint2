package com.cg.healthify.service;



import com.cg.healthify.beans.Exercise;


public interface ExerciseService {
	
	
	
	//save and update
	public Exercise saveOrUpdate(Exercise exercise);
		 
	//Find by exIdentifier
	public Exercise findExerciseByExPlanIdentifier(String exPlanIdentifier); 
	
	//Find ALL
	public Iterable<Exercise> getAllExercises();
	
	//Delete by exIdentifier
	public Exercise deleteExerciseByExPlanIdentifier(String exPlanIdentifier) ;
	
	
	
}
	
	


