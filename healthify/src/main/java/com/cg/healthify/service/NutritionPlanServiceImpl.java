package com.cg.healthify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthify.beans.NutritionPlan;
import com.cg.healthify.exceptions.NutritionIdException;
import com.cg.healthify.repository.NutritionPlanRepository;

@Service
public class NutritionPlanServiceImpl implements NutritionPlanService{
	@Autowired
	private NutritionPlanRepository nutritionRepository;
	
	@Override
	public NutritionPlan addOrUpdate(NutritionPlan nutritionPlan) {
		try {
			nutritionPlan.setPlanId(nutritionPlan.getPlanId());
			return nutritionRepository.save(nutritionPlan);
		} catch (Exception e) {
			throw new NutritionIdException("NUtrition Plan with :" + nutritionPlan.getPlanId() + " is already exists.");
		}
	}
	@Override
	public Iterable<NutritionPlan> getAllNutritionPlans() {
		return nutritionRepository.findAll();
	}
	@Override
	public NutritionPlan getNutritionPlanById(int planId) {
		NutritionPlan nutritionPlan = nutritionRepository.findByPlanId(planId);
		if (nutritionPlan == null) {
			throw new NutritionIdException("Nutrition Plan with :" + planId + " does not exists.");
		}
		return nutritionPlan;

	}
	@Override
	public void deleteNutritionPlanById(int planId) {
		NutritionPlan nutritionPlan = nutritionRepository.findByPlanId(planId);
		if (nutritionPlan == null) {
			throw new NutritionIdException("Nutrition Plan with :" + planId + " does not exists.");
		}
		nutritionRepository.delete(nutritionPlan);
	}
}
