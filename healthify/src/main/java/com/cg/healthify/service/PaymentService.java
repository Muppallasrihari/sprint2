package com.cg.healthify.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.healthify.beans.Payment;

@Service
public interface PaymentService {
	public Payment addPayment(String paymentIdentifier, Payment payment);

	public Payment findPaymentByTransactionId(String transactionId);

	public void deletePaymentByTransactionId(Long id);

	public List<Payment> getAllPayments();

}
