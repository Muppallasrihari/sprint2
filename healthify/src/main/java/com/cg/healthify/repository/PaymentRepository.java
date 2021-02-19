package com.cg.healthify.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.stereotype.Repository;

import com.cg.healthify.beans.Payment;


@Repository
@EnableJpaRepositories
public interface PaymentRepository extends JpaRepository<Payment,Long>{
	
Payment findByTransactionId(String transactionId);
Payment findByPaymentIdentifier(String paymentIdentifier);

//List<Payment> findByPaymentIdentifier(String paymentIdentifier);
}