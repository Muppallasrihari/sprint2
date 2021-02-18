package com.cg.healthify.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthify.beans.NutritionPlan;
import com.cg.healthify.beans.Payment;
import com.cg.healthify.exceptions.PaymentNameException;
import com.cg.healthify.repository.PaymentRepository;


@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	
	public Payment saveOrUpdate(Payment payment) {
		
		try {
		
			payment.setName(payment.getName().toUpperCase());
			
			return paymentRepository.save(payment);
		} catch (Exception e) {
			throw new PaymentNameException("Name : " + payment.getName().toUpperCase() + " already exists");
		}

	}

	

	
	public  Iterable<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}

	public Payment findPaymentById(Long id) {
		return paymentRepository.findById(id).get();
	}

	public void deletePayment(Long id) {
		paymentRepository.deleteById(id);
	}

	public Payment Update(Payment payment, Long id) {
		return paymentRepository.save(payment);
	}

	
}
