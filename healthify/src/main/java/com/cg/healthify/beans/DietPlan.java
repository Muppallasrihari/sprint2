package com.cg.healthify.beans;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@Entity
public class DietPlan {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@NotBlank(message="Customer Identifier Reqiured")
@Column(unique=true,updatable=false)
private String customerIdentifier;
private String foodType;
private Double carbProtien;
private Double fatProtien;
private Double totalProtien;


/**--------------------------------------One-To-One Mapping With Customer--------------------**/
@OneToOne(fetch=FetchType.EAGER)
@JoinColumn(name="id",nullable=false)
@JsonIgnore
private Customer customer;


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}


public String getCustomerIdentifier() {
	return customerIdentifier;
}


public void setCustomerIdentifier(String customerIdentifier) {
	this.customerIdentifier = customerIdentifier;
}


public String getFoodType() {
	return foodType;
}


public void setFoodType(String foodType) {
	this.foodType = foodType;
}


public Double getCarbProtien() {
	return carbProtien;
}


public void setCarbProtien(Double carbProtien) {
	this.carbProtien = carbProtien;
}


public Double getFatProtien() {
	return fatProtien;
}


public void setFatProtien(Double fatProtien) {
	this.fatProtien = fatProtien;
}


public Double getTotalProtien() {
	return totalProtien;
}


public void setTotalProtien(Double totalProtien) {
	this.totalProtien = totalProtien;
}


public Customer getCustomer() {
	return customer;
}


public void setCustomer(Customer customer) {
	this.customer = customer;
}


}
