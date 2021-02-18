package com.cg.healthify.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class NutritionPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Nutrition Plan Id is required.")
	@Column(unique = true, updatable = false)
	private String planId;
	@NotBlank(message = "Nutrition Plan Name is required.")
	private String name;
	@NotBlank(message = "Nutrition Plan Description is required.")
	private String description;
	@JsonFormat
	private Date createdAt;
	@JsonFormat
	private Date updatedAt;
	@NotNull(message = "Nutrition Plan Price is required.")
	@Min(value = 0)
	private double price;

	// @OneToOne(fetch=FetchType.EAGER)
	// @JoinColumn(name="id",nullable=false)
	// @JsonIgnore
	// private Payment payment;

	public NutritionPlan() {
		super();
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@PrePersist
	public void onCreate() {
		this.createdAt = new Date();

		this.createdAt = new Date();
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}

}
