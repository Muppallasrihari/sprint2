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
private Double fatRatio;
private Double carbsRatio;
private Double proteinRatio;
private Double total;
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

public Double getFatRatio() {
	return fatRatio;
}
public void setFatRatio(Double fatRatio) {
	this.fatRatio = fatRatio;
}
public Double getCarbsRatio() {
	return carbsRatio;
}
public void setCarbsRatio(Double carbsRatio) {
	this.carbsRatio = carbsRatio;
}
public Double getProteinRatio() {
	return proteinRatio;
}
public void setProteinRatio(Double proteinRatio) {
	this.proteinRatio = proteinRatio;
}
public Double getTotal() {
	return total;
}
public void setTotal(Double total) {
	this.total = total;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}


}
