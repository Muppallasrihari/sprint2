package com.cg.healthify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.healthify.beans.Customer;
import com.cg.healthify.beans.Payment;
import com.cg.healthify.exceptions.PaymentIdNotFoundException;
import com.cg.healthify.repository.CustomerRepository;
import com.cg.healthify.repository.PaymentRepository;

//import com.cg.ppmtoolapi.domain.ProjectTask;


@Service
public class PaymentServiceImpl implements PaymentService{
	
@Autowired
private CustomerRepository customerRepository;
@Autowired
private PaymentRepository paymentRepository;
Integer PTSsequence=0;
String paymentTransactionId;
@Override
public Payment addPayment(String paymentIdentifier, Payment payment) {
	try {	
	Customer customer=customerRepository.findByPaymentIdentifier(paymentIdentifier);
	System.out.println(payment.getId());
	if(payment.getId()==null){
    paymentTransactionId=payment.getTransactionId();
	PTSsequence++;
	paymentTransactionId=Integer.toString(PTSsequence)+"-PAY";
	payment.setTransactionId(paymentTransactionId);
	customer.setPaymentIdentifier(paymentIdentifier);
	payment.setPaymentIdentifier(paymentIdentifier);
	payment.setCustomer(customer);
	}
	if(payment.getId()!=null) {
		payment.setTransactionId(paymentTransactionId);
		customer.setPaymentIdentifier(paymentIdentifier);
		payment.setPaymentIdentifier(paymentIdentifier);
		payment.setCustomer(customer);
	 }
	return paymentRepository.save(payment);
	}
	catch (Exception e) {
	throw new PaymentIdNotFoundException("Specified Payment is not there, Please check your input");
	}
}
@Override
public Payment findPaymentByTransactionId(String transactionId) {
	Payment pay=paymentRepository.findByTransactionId(transactionId);
	if(pay==null) {
		throw new PaymentIdNotFoundException("Pay Id:"+transactionId+" not found");
	}
	return pay;
}

@Override
public void deletePaymentByTransactionId(Long id) {
	 paymentRepository.deleteById(1L);
	
}
@Override
public List<Payment> getAllPayments() {
	return paymentRepository.findAll();
	
}

}
