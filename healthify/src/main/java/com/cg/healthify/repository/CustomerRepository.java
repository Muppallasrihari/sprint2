package com.cg.healthify.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthify.beans.Customer;
//import com.cg.healthify.beans.Payment;


@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long>{
Customer findByCustomerIdentifier(String customerIdentifier);
//Optional <Customer> findByCustomerIdentifie(String paymentidentifier);
}
