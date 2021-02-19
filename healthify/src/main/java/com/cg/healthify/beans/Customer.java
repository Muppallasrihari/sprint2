package com.cg.healthify.beans;

import java.util.ArrayList;
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

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Contact Required")
//@Size(max=10,min=10,message="Phone number must be 10 digits")
//@Column(unique=true)
	private String contact;
	@NotBlank(message = "Name Required")
	private String name;
	@NotBlank(message = "Gender Required")
	private String gender;
//@NotBlank(message="Nutrition-Plan Name Required")
//private String nutritionName;
	@NotBlank(message = "Customer Identifier Reqiured")
	@Column(unique = true, updatable = false)
	private String customerIdentifier;
	@NotBlank(message = "Payment Identifier Required")
	@Column(unique = true, updatable = false)
	private String paymentIdentifier;
	@NotBlank(message = "Plan Id is Required")
	private String planId;
	private Integer PTSequence = 0;

	/**
	 * ----------------------------------OneToOne mapping with
	 * NutritionPLan-------------------------
	 **/
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
	private DietPlan dietPlan;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = NutritionPlan.class)
	private NutritionPlan nutritionPlan;

	/**
	 * ----------------------------------OneToMany mapping with
	 * Payment-----------------------
	 **/
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Payment> payment = new ArrayList<>();

	@Column(updatable = false)
	private Date createdDate;
	private Date updatedDate;

	@PrePersist
	public void onCreate() {
		this.createdDate = new Date();
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedDate = new Date();
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

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
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

	public NutritionPlan getNutritionPlan() {
		return nutritionPlan;
	}

	public void setNutritionPlan(NutritionPlan nutritionPlan) {
		this.nutritionPlan = nutritionPlan;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
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

	public Customer(Long id, @NotBlank(message = "Contact Required") String contact,
			@NotBlank(message = "Name Required") String name, @NotBlank(message = "Gender Required") String gender,
			@NotBlank(message = "Customer Identifier Reqiured") String customerIdentifier,
			@NotBlank(message = "Payment Identifier Required") String paymentIdentifier,
			@NotBlank(message = "Plan Id is Required") String planId, Integer pTSequence, DietPlan dietPlan,
			NutritionPlan nutritionPlan, List<Payment> payment, Date createdDate, Date updatedDate) {
		super();
		this.id = id;
		this.contact = contact;
		this.name = name;
		this.gender = gender;
		this.customerIdentifier = customerIdentifier;
		this.paymentIdentifier = paymentIdentifier;
		this.planId = planId;
		PTSequence = pTSequence;
		this.dietPlan = dietPlan;
		this.nutritionPlan = nutritionPlan;
		this.payment = payment;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", contact=" + contact + ", name=" + name + ", gender=" + gender
				+ ", customerIdentifier=" + customerIdentifier + ", paymentIdentifier=" + paymentIdentifier
				+ ", planId=" + planId + ", PTSequence=" + PTSequence + ", dietPlan=" + dietPlan + ", nutritionPlan="
				+ nutritionPlan + ", payment=" + payment + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}

}
