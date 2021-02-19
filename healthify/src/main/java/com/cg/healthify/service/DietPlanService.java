package com.cg.healthify.service;

import org.springframework.stereotype.Service;

import com.cg.healthify.beans.DietPlan;

@Service
public interface DietPlanService {
	public DietPlan saveDietPlan(DietPlan dietPlan);
	public DietPlan getDietPlanById(String customerIdentifier);
	public Iterable<DietPlan>getAllDietDetails();
	
}