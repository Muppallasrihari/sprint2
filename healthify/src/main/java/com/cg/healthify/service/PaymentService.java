package com.cg.healthify.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.healthify.beans.Payment;
      
@Service
public interface PaymentService {

	
	public Payment saveOrUpdate(Payment payment);

	public List<Payment> getAllPayments();
	
	public Payment findPaymentById(long id);

	public void deletePayment(long id);

	public Payment Update(Payment payment, long id) ;

}
