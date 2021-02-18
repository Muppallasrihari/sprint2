package com.cg.healthify.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthify.beans.NutritionPlan;

@Repository
public interface NutritionPlanRepository extends CrudRepository<NutritionPlan,Integer>{

	NutritionPlan findByPlanId(String planId);

	


}
