package com.cg.healthify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.healthify.beans.Exercise;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer>{
	
	Exercise findByExIdentifier(String exIdentifier);
	

	
}
