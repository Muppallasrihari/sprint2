package com.cg.healthify.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.healthify.beans.Customer;
import com.cg.healthify.service.CustomerServiceImpl;
import com.cg.healthify.service.MapValidationErrorService;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

@Autowired	
private CustomerServiceImpl customerService;
@Autowired
private MapValidationErrorService validationService;

/**------------------------------Customer Data Formation-------------------------------------------**/
	@PostMapping("")
	public ResponseEntity<?> createCustomerData(@Valid @RequestBody Customer customer,BindingResult result) {
	ResponseEntity<?> errorMsg=	validationService.mapValidationError(result);
	if(errorMsg!=null)return errorMsg;
		Customer cust=customerService.save(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
/**-----------------------------------------------------------------------------------------------**/
	
	
/**----------------------------------Get Customer by Customer Id-------------------------------**/
	@GetMapping("/{customerIdentifier}")
	public ResponseEntity<Customer> getUserByCustId(@PathVariable String customerIdentifier){
		Customer cust=customerService.findCustomerById(customerIdentifier);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
/**------------------------------------------------------------------------------------------------**/	
	
	
/**------------------------------------------Get All Customer Details------------------------------**/	
	@GetMapping("/all")
	public Iterable<Customer> getAllUserDetails(){
		return customerService.getAllCustomerDetails();
	}
/**------------------------------------------------------------------------------------------------**/	
	
	
/**--------------------------------------Delete Customer By Id-------------------------------------**/	
	@DeleteMapping("/{customerIdentifier}")
	public ResponseEntity<?> DeleteUserById(@PathVariable String customerIdentifier){
		customerService.deleteCustomerById(customerIdentifier);
		return new ResponseEntity<String>("Customer with ID "+customerIdentifier+" was deleted",HttpStatus.OK);
	}
/**------------------------------------------------------------------------------------------------**/	
}
