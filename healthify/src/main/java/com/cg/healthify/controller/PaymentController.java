package com.cg.healthify.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthify.beans.Payment;
import com.cg.healthify.service.MapValidationErrorService;
import com.cg.healthify.service.PaymentService;



@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@Autowired
	MapValidationErrorService mapValidationErrorService;

	//NutritionPlan nutritionPlan = new  NutritionPlan();
	
	@PostMapping(value = "/payments")
	public ResponseEntity<?> savePayment(@Valid @RequestBody Payment payment, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Payment pay = paymentService.saveOrUpdate(payment);
		return new ResponseEntity<Payment>(pay, HttpStatus.CREATED);
	}

	
	@PutMapping("/payments")
	public Payment updatePayment(@RequestBody Payment payment) {
		return paymentService.saveOrUpdate(payment);
	}

	@GetMapping("/payments")
	public List<Payment> getAllPayments() {
		return paymentService.getAllPayments();
	}

	@GetMapping("/payment/{id}")
	public ResponseEntity<Payment> findPaymentById(@PathVariable("id") int id) {
		Payment payment = paymentService.findPaymentById(id);
		/*if (payment == null) {
			throw new Payment("Invalid ID" + id);
		}*/
		return new ResponseEntity<Payment>(payment, HttpStatus.OK);
		
	}

	@DeleteMapping("/payment/{id}")
	public void deletePayment(@PathVariable("id") int id) {
		paymentService.deletePayment(id);
	}

}
