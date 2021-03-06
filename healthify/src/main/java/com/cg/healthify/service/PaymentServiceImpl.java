package com.cg.healthify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthify.beans.Customer;
import com.cg.healthify.beans.Payment;
import com.cg.healthify.exceptions.PaymentIdNotFoundException;
import com.cg.healthify.repository.CustomerRepository;
import com.cg.healthify.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	Integer PTSsequence = 0;
	String paymentTransactionId;

	@Override
	public Payment addPayment(String paymentIdentifier, Payment payment) {
		try {
			Customer customer = customerRepository.findByPaymentIdentifier(paymentIdentifier);
			String planCategory = payment.getPaymentGateway();
			Double price = customer.getNutritionPlan().getPrice();
			if (payment.getId() == null) {
				paymentTransactionId = payment.getTransactionId();
				PTSsequence++;
				paymentTransactionId = Integer.toString(PTSsequence) + "-PAY";
				payment.setTransactionId(paymentTransactionId);
				customer.setPaymentIdentifier(paymentIdentifier);
				payment.setPaymentIdentifier(paymentIdentifier);
				payment.setCustomer(customer);
				if (planCategory.equalsIgnoreCase("UPI")) {
					payment.setDiscount(10.0);
					Double amount = price - (payment.getDiscount() * 10);
					payment.setActualAmount(amount);
				} else if (planCategory.equalsIgnoreCase("Card")) {
					payment.setDiscount(5.0);
					Double amount = price - (payment.getDiscount() * 10);
					payment.setActualAmount(amount);
				}
			}
			if (payment.getId() != null) {
				payment.setTransactionId(paymentTransactionId);
				customer.setPaymentIdentifier(paymentIdentifier);
				payment.setPaymentIdentifier(paymentIdentifier);
				payment.setCustomer(customer);
			}
			return paymentRepository.save(payment);
		} catch (Exception e) {
			throw new PaymentIdNotFoundException("Specified Payment is not there, Please check your id");
		}
	}

	@Override
	public Payment findPaymentByTransactionId(String transactionId) {
		Payment pay = paymentRepository.findByTransactionId(transactionId);
		if (pay == null) {
			throw new PaymentIdNotFoundException("Pay Id:" + transactionId + " not found");
		}
		return pay;
	}

	@Override
	public int deletePaymentById(String transactionId) {
		int result = 0;
		Payment payment = paymentRepository.findByTransactionId(transactionId);
		if (payment == null) {
			throw new PaymentIdNotFoundException("Pay Id:" + transactionId + " not found");
		} else {
			result = 1;
			paymentRepository.delete(payment);

		}

		return result;

	}

	@Override
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();

	}

}
