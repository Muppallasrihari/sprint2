package com.cg.healthify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthify.beans.NutritionPlan;
import com.cg.healthify.exceptions.NutritionIdException;
import com.cg.healthify.repository.NutritionPlanRepositiry;

@Service
public class NutritionPlanService {
	@Autowired
	private NutritionPlanRepositiry nutritionRepository;

	public NutritionPlan addOrUpdate(NutritionPlan nutritionPlan) {
		try {
			nutritionPlan.setPlanId(nutritionPlan.getPlanId());
			return nutritionRepository.save(nutritionPlan);
		} catch (Exception e) {
			throw new NutritionIdException("NUtrition Plan with :" + nutritionPlan.getPlanId() + " is already exists.");
		}
	}

	public Iterable<NutritionPlan> getAllNutritionPlans() {
		return nutritionRepository.findAll();
	}

	public NutritionPlan getNutritionPlanById(int planId) {
		NutritionPlan nutritionPlan = nutritionRepository.findByPlanId(planId);
		if (nutritionPlan == null) {
			throw new NutritionIdException("Nutrition Plan with :" + planId + " does not exists.");
		}
		return nutritionPlan;

	}
	
	public void deleteNutritionPlanById(int planId) {
		NutritionPlan nutritionPlan = nutritionRepository.findByPlanId(planId);
		if (nutritionPlan == null) {
			throw new NutritionIdException("Nutrition Plan with :" + planId + " does not exists.");
		}
		nutritionRepository.delete(nutritionPlan);
	}
}
