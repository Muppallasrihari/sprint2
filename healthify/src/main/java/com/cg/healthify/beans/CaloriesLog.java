package com.cg.healthify.beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class CaloriesLog {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Calories required" )
	@Range(min=1,max=20000,message="Calories value cannot be negative")
	private int calories;
	
	@NotBlank(message="CaloriesLog Identifier is Required")
	@Size(min=3,max=4,message="Size must be 3 to 4 charecters")
	@Column(unique=true,updatable=false)
	private String caloriesLogIdentifier;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	
	public CaloriesLog() {
		super();
		
	}

	public CaloriesLog(Long id, int calories, String caloriesLogIdentifier,Date createdAt, Date updatedAt) {
		super();
		this.id = id;
		this.calories = calories;
		this.caloriesLogIdentifier = caloriesLogIdentifier;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public String getCaloriesLogIdentifier() {
		return caloriesLogIdentifier;
	}
	public void setCaloriesLogIdentifier(String caloriesLogIdentifier) {
		this.caloriesLogIdentifier = caloriesLogIdentifier;
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
	
	@PrePersist
	public void onCreate() {
  	this.createdAt=new Date();
    }
	
    @PreUpdate
    public void onUpdate() {
    this.updatedAt=new Date();
    }
    @Override
	public String toString() {
		return "CaloriesLog [id=" + id + ", calories=" + calories + ", caloriesLogIdentifier=" + caloriesLogIdentifier
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
