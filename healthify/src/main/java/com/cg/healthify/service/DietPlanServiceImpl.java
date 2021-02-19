package com.cg.healthify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthify.beans.Customer;
import com.cg.healthify.beans.DietPlan;
import com.cg.healthify.exceptions.DietPlanException;
import com.cg.healthify.repository.CustomerRepository;
import com.cg.healthify.repository.DietPlanRepository;

@Service
public class DietPlanServiceImpl implements DietPlanService{
	@Autowired
	private DietPlanRepository dietPlanRepository;
	@Autowired
	private CustomerRepository customerRepository;

/**-----------------------------------Update Existing Diet Plan-------------------------**/	
	@Override
	public DietPlan saveDietPlan(DietPlan dietPlan) {
		try {
			System.out.println("-----------------------"+dietPlan.getFoodType());
			if(dietPlan.getFoodType().equalsIgnoreCase("Veg")){
				dietPlan.setCarbs(10.0);
				dietPlan.setFatProtien(7.0);
				dietPlan.setTotalProtien(dietPlan.getCarbs()+dietPlan.getFatProtien());
			}
			if(dietPlan.getFoodType().equalsIgnoreCase("NonVeg")){
				dietPlan.setCarbs(20.0);
				dietPlan.setFatProtien(11.0);
				dietPlan.setTotalProtien(dietPlan.getCarbs()+dietPlan.getFatProtien());
			}
			Customer customer=new Customer();
			if(customer.getCustomerIdentifier()!=null) {
				dietPlan=dietPlanRepository.findByCustomerIdentifier(customer.getCustomerIdentifier());
				dietPlan.setCustomerIdentifier(dietPlan.getCustomerIdentifier().toUpperCase());
				customer.setDietPlan(dietPlan);			
				dietPlan.setCustomer(customer);
			}
			return dietPlanRepository.save(dietPlan);	
		}
		catch(Exception e) {
			throw new DietPlanException("This Diet-Plan: "+dietPlan.getId()+" already exists");
		}
	}

/**--------------------------------------------------------------------------------------------**/

/**---------------------------------Find Diet Plan By Id---------------------------------------**/
	@Override	
	public DietPlan getDietPlanById(String customerIdentifier) {
		DietPlan diet= dietPlanRepository.findByCustomerIdentifier(customerIdentifier);
		if(diet==null) {
			throw new DietPlanException("Id: "+customerIdentifier+" not exists");
		}
		return diet;
	}

/**---------------------------------------------------------------------------------------**/

/**------------------------------Get List of All Diet Plan--------------------------------**/
	@Override
	public Iterable<DietPlan>getAllDietDetails(){
		return dietPlanRepository.findAll();
	}
/**----------------------------------------------------------------------------------------**/
	/*
public void deleteDietPlan(String customerIdentifier) {
	DietPlan diet= dietPlanRepository.findByCustomerIdentifier(customerIdentifier);
	if(diet==null) {
		throw new DietPlanException("Id: "+customerIdentifier+" not exists");
	}
	       dietPlanRepository.delete(diet);
}*/

}
