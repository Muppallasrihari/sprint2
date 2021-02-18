package com.cg.healthify.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonFormat;
=======
import com.fasterxml.jackson.annotation.JsonIgnore;
>>>>>>> branch 'master' of https://github.com/Muppallasrihari/sprint2.git

@Entity
public class NutritionPlan {
	
	@Id
<<<<<<< HEAD
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull(message = "Nutrition Plan Id is required.")
	@Column(unique = true, updatable = false)
=======
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Nutrition Plan Id is required.")
	@Column(updatable=false)
>>>>>>> branch 'master' of https://github.com/Muppallasrihari/sprint2.git
	private int planId;
<<<<<<< HEAD
	@NotBlank(message = "Nutrition Plan Name is required.")
=======
	
	@NotBlank(message="Nutrition Plan Name is required.")
>>>>>>> branch 'master' of https://github.com/Muppallasrihari/sprint2.git
	private String name;
<<<<<<< HEAD
	@NotBlank(message = "Nutrition Plan Description is required.")
=======
	
	@NotBlank(message="Nutrition Plan Description is required.")
>>>>>>> branch 'master' of https://github.com/Muppallasrihari/sprint2.git
	private String description;
<<<<<<< HEAD
	@JsonFormat
=======
	
>>>>>>> branch 'master' of https://github.com/Muppallasrihari/sprint2.git
	private Date createdAt;
	@JsonFormat
	private Date updatedAt;
<<<<<<< HEAD
	@NotNull(message = "Nutrition Plan Id is required.")
	@Min(value = 0)
=======
	
	@NotNull(message="Nutrition Plan Id is required.")
>>>>>>> branch 'master' of https://github.com/Muppallasrihari/sprint2.git
	private double price;
<<<<<<< HEAD
=======
	
	//@OneToOne(fetch=FetchType.EAGER)
	//@JoinColumn(name="id",nullable=false)
	//@JsonIgnore
	//private Payment payment;
>>>>>>> branch 'master' of https://github.com/Muppallasrihari/sprint2.git

	public NutritionPlan() {
		super();
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public Long getId() {
		return id;
	}

<<<<<<< HEAD
	public void setId(Integer id) {
=======

	public void setId(Long id) {
>>>>>>> branch 'master' of https://github.com/Muppallasrihari/sprint2.git
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
<<<<<<< HEAD
		this.createdAt = new Date();
=======
		this.createdAt=new Date();
>>>>>>> branch 'master' of https://github.com/Muppallasrihari/sprint2.git
	}

	@PreUpdate
	public void onUpdate() {
		this.updatedAt = new Date();
	}
	
	

}
