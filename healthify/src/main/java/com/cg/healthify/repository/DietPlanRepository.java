package com.cg.healthify.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthify.beans.DietPlan;

@Repository
public interface DietPlanRepository extends CrudRepository<DietPlan,Long>{

   DietPlan  findByCustomerIdentifier(String customerIdentifier);  
}
