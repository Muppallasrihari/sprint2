package com.cg.healthify.beans;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@Entity
public class Customer {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@NotBlank(message="Contact Required")
@Size(max=10,min=10,message="Phone number must be 10 digits")
@Column(unique=true)
private String contact;
@NotBlank(message="Name Required")
private String name;
@NotBlank(message="Gender Required")
private String gender;
@NotBlank(message="Customer Identifier Reqiured")
@Column(unique=true,updatable=false)
private String customerIdentifier;
@NotBlank(message="Payment Identifier Required")
private String paymentIdentifier;
private Integer PTSequence = 0;

/**----------------------------------OneToOne mapping with DietPlan-------------------------**/
@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="customer")
private DietPlan dietPlan;

/**----------------------------------OneToMany mapping with Payment-----------------------**/
//@OneToMany(targetEntity = Payment.class)
//@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL , mappedBy = "customer")
//private List<Payment> payment;

@Column(updatable=false)
private Date createdDate;
private Date updatedDate;

@PrePersist
public void onCreate() {
	this.createdDate=new Date();
}
@PreUpdate
public void onUpdate() {
	this.updatedDate=new Date();
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getCustomerIdentifier() {
	return customerIdentifier;
}
public void setCustomerIdentifier(String customerIdentifier) {
	this.customerIdentifier = customerIdentifier;
}
public String getPaymentIdentifier() {
	return paymentIdentifier;
}
public void setPaymentIdentifier(String paymentIdentifier) {
	this.paymentIdentifier = paymentIdentifier;
}
public Integer getPTSequence() {
	return PTSequence;
}
public void setPTSequence(Integer pTSequence) {
	PTSequence = pTSequence;
}
public DietPlan getDietPlan() {
	return dietPlan;
}
public void setDietPlan(DietPlan dietPlan) {
	this.dietPlan = dietPlan;
}
public Date getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}
public Date getUpdatedDate() {
	return updatedDate;
}
public void setUpdatedDate(Date updatedDate) {
	this.updatedDate = updatedDate;
}


}
