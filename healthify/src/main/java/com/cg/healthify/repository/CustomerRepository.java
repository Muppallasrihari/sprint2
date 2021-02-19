package com.cg.healthify.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.healthify.beans.Customer;



@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
Customer findByCustomerIdentifier(String customerIdentifier);
Customer  findByPaymentIdentifier(String paymentIdentifier);
}
