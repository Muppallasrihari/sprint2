package com.cg.healthify.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.healthify.beans.Payment;
      
@Service
public interface PaymentService {

	
	public Payment saveOrUpdate(Payment payment);

	public Iterable<Payment> getAllPayments();
	
	public Payment findPaymentById(Long id);

	public void deletePayment(Long id);

	public Payment Update(Payment payment, Long id) ;

}
