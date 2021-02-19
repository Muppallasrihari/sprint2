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


@Entity
public class DietPlan {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@NotBlank(message="Customer Identifier Reqiured")
@Column(unique=true,updatable=false)
private String customerIdentifier;
private String foodType;
private double carbs;
private double fatProtien;
private double totalProtien;
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
public double getCarbs() {
	return carbs;
}
public void setCarbs(double carbs) {
	this.carbs = carbs;
}
public double getFatProtien() {
	return fatProtien;
}
public void setFatProtien(double fatProtien) {
	this.fatProtien = fatProtien;
}
public double getTotalProtien() {
	return totalProtien;
}
public void setTotalProtien(double totalProtien) {
	this.totalProtien = totalProtien;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}


}
