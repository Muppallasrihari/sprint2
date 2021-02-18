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

@Entity
public class NutritionPlan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message="Nutrition Plan Id is required.")
	@Column(updatable=false)
	private int planId;
	@NotBlank(message="Nutrition Plan Name is required.")
	private String name;
	@NotBlank(message="Nutrition Plan Description is required.")
	private String description;
	private Date createdAt;
	private Date updatedAt;
	@NotBlank(message="Nutrition Plan Id is required.")
	@Min(value=0)
	private double price;
	
	

	public NutritionPlan() {
		super();
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
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
	public void onCretae() {
		this.createdAt=new Date();
	}
	@PreUpdate
	public void onUpdate() {
		this.updatedAt=new Date();
	}
	
	

}
