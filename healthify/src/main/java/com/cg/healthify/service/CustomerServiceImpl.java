package com.cg.healthify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthify.beans.Customer;
import com.cg.healthify.beans.DietPlan;
import com.cg.healthify.beans.NutritionPlan;
import com.cg.healthify.exceptions.CustomerException;
import com.cg.healthify.repository.CustomerRepository;
import com.cg.healthify.repository.DietPlanRepository;
import com.cg.healthify.repository.NutritionPlanRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

@Autowired
private CustomerRepository customerRepository;
@Autowired
private DietPlanRepository dietPlanRepository;
@Autowired
private NutritionPlanRepository nutritionPlanRepository;

/**-----------------------------Create Customer Data Along with Connected Entities----------**/
@Override
public Customer save(Customer customer) {
	try {
		customer.setCustomerIdentifier(customer.getCustomerIdentifier().toUpperCase());
		NutritionPlan plan=nutritionPlanRepository.findByPlanId(customer.getPlanId().toUpperCase());
	  if(customer.getId()==null) {
		DietPlan dietPlan=new DietPlan();
		dietPlan.setFoodType("Veg");
		customer.setDietPlan(dietPlan);
		dietPlan.setCustomer(customer);
		dietPlan.setCustomerIdentifier(customer.getCustomerIdentifier().toUpperCase());
}
	 if(customer.getId()!=null) {
		customer.setDietPlan(dietPlanRepository.findByCustomerIdentifier(customer.getCustomerIdentifier().toUpperCase()));
			
	 }
	 if(plan!=null) {
		 customer.setNutritionPlan(plan);
	 }
	}
	catch(Exception e) {
		throw new CustomerException("Contact: "+customer.getContact()+" already exists");
	}
	return customerRepository.save(customer);
	}
/**----------------------------------------------------------------------------------------**/


/**-------------------------------Find Customer By CustomerIdentifier---------------------------------------**/
@Override
public Customer findCustomerById(String customerIdentifier) {
	Customer customer=customerRepository.findByCustomerIdentifier(customerIdentifier);
	if(customer==null) {
		throw new CustomerException("Id: "+customerIdentifier+" doesn't exists");
	}
	return customer;
}

/**--------------------------------------------------------------------------------------------------------**/


/**---------------------------Get List of All Customer Details---------------------------------------------**/
@Override
public Iterable<Customer>getAllCustomerDetails(){
	return customerRepository.findAll();
}

/**--------------------------------------------------------------------------------------------------------**/


/**------------------------------Delete Customer By CustomerIdentifier-------------------------------------**/
@Override
public void deleteCustomerById(String customerIdentifier) {
	Customer customer=customerRepository.findByCustomerIdentifier(customerIdentifier);
	if(customer==null) {
		throw new CustomerException("Id: "+customerIdentifier+" doesn't exists");
	}
	customerRepository.delete(customer);
}
}
/**-------------------------------------------------------------------------------------------------------**/

/*try {
		customer.setIdentifier(customer.getIdentifier().toUpperCase());
		catch(Exception e) {
		throw new CustomerNameException("Name: "+customer.getIdentifier().toUpperCase()+" already there");
	}*/