package com.cg.healthify.beans;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PaymentId")
	private Long id;
	
	private int planId;

	@NotBlank(message = "Name should not be empty")
	@Column(unique = true, updatable = false)
	private String name;

	@NotNull(message = "Payment should not be null")
	private double payment;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;

	@NotBlank(message = "Plan Category should not be empty")
	private String planCategory;

	//@OneToOne(mappedBy="payment",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    //private NutritionPlan nutritionPlan;

	public Payment() {
		super();
	}

	public Payment(long id, @NotBlank(message = "Name should not be empty") String name,
			@NotNull(message = "Payment should not be null") double payment, Date createdAt,
			@NotBlank(message = "Plan Category should not be empty") String planCategory) {
		super();
		this.id = id;
		this.name = name;
		this.payment = payment;
		this.createdAt = createdAt;
		this.planCategory = planCategory;
	}
/*
	public NutritionPlan getNutritionPlan() {
		return nutritionPlan;
	}

	public void setNutritionPlan(NutritionPlan nutritionPlan) {
		this.nutritionPlan = nutritionPlan;
	}
*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getPlanCategory() {
		return planCategory;
	}

	public void setPlanCategory(String planCategory) {
		this.planCategory = planCategory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", name=" + name + ", payment=" + payment + ", createdAt=" + createdAt
				+ ", planCategory=" + planCategory + "]";
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}
}