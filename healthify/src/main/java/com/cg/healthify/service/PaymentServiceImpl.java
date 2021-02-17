package com.cg.healthify.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthify.beans.Payment;
import com.cg.healthify.repository.PaymentRepository;


@Service("PaymentServiceImpl")
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	
	public Payment saveOrUpdate(Payment payment) {
		
	//	payment.setNutritionPlan(payment.getNutritionPlan());
		return paymentRepository.save(payment);
/*
		try {
			payment.setName(payment.getName().toUpperCase());
			return paymentRepository.save(payment);
		} catch (Exception e) {
			throw new PaymentNameException("Name : " + payment.getName().toUpperCase() + " already exists");
		}
*/
	}

	

	
	public List<Payment> getAllPayments() {
		List<Payment> payments = new ArrayList<Payment>();
		paymentRepository.findAll().forEach(pay -> payments.add(pay));
		return payments;
	}

	public Payment findPaymentById(long id) {
		return paymentRepository.findById(id).get();
	}

	public void deletePayment(long id) {
		paymentRepository.deleteById(id);
	}

	public Payment Update(Payment payment, long id) {
		return paymentRepository.save(payment);
	}

	
}
