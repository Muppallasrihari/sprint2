package com.cg.healthify.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
public class Exercise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Exercise Identifier should not be blank")
	@Size(min=3, max=10, message = "Please use 3 to 10 charecters")
	@Column(updatable = false, unique = true)
	private String exPlanIdentifier;
	
	@NotBlank
	private String exType;
	
	@NotNull
	@Range(min=1,max=10,message="set range should be within 1 to 10 ")
	private int exSets;
	
	@NotNull
	@Range(min=1,max=40,message="rep range should be within 1 to 40 ")
	private int exReps;
	
	@NotBlank
	private String exPlan;
	//-------------------------------------------------------------
	
	
	@ElementCollection
	@CollectionTable(name="ExercisePlans")
	private Collection<String> exPlans = new ArrayList<>();
	
	
	public Collection<String> getExPlans() {
		return exPlans;
	}
	public void setExPlans(Collection<String> exPlans) {
		this.exPlans = exPlans;
	}

	//--------------------------^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^------------------------------------------------------
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date created_At;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updated_At;
	
	//OneToMany with User -- one user can have many exercises
	
	//-------------------------------------------------------------------------------

	//ManyToOne -- many Exercises can belong to one user
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="User_id")
//	private User user;
//	
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	
	
	//--------------------------------------------------------------------------------
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getExPlanIdentifier() {
		return exPlanIdentifier;
	}
	public void setExPlanIdentifier(String exPlanIdentifier) {
		this.exPlanIdentifier = exPlanIdentifier;
	}
	public String getExType() {
		return exType;
	}
	public void setExType(String exType) {
		this.exType = exType;
	}
	public int getExSets() {
		return exSets;
	}
	public void setExSets(int exSets) {
		this.exSets = exSets;
	}
	public int getExReps() {
		return exReps;
	}
	public void setExReps(int exReps) {
		this.exReps = exReps;
	}
	public String getExPlan() {
		return exPlan;
	}
	public void setExPlan(String exPlan) {
		this.exPlan = exPlan;
	}
	public Date getCreated_At() {
		return created_At;
	}
	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}
	public Date getUpdated_At() {
		return updated_At;
	}
	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}
	
	@PrePersist
	public void onCreate() {
		this.created_At = new Date();
	}
	
	@PreUpdate
	public void onUpdate() {
		this.updated_At = new Date();
	}

}
