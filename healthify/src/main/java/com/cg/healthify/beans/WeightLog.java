package com.cg.healthify.beans;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.UniqueConstraint;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;


/**
 * Pojo class= WeightLog
 * @author vinotraj
 *
 */

@Entity
public class WeightLog {

	
	/**
	 * @param WeightId
	 * It must not be empty
	 * size of the string between 2 to 4
	 * weightId must be unique.
	 */
	@NotBlank(message="weightId Required")
	@Size(min=2,max=4,message="Must be between the size(min=2 ,max=4)")
	@Column(unique = true,updatable = false)
	@Id
	private String weightId;

	/**
	 * @param weight
	 * It must not be empty
	 * 
	 */
	@NotBlank(message="weight Required")
	private String weight;

	/**
	 * @param created_At
	 * Date must be in json format
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date created_At;

	/**
	 * @param updated_At
	 * Date must be json format
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date Updated_At;

	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getWeightId() {
		return weightId;
	}
	public void setWeightId(String weightId) {
		this.weightId = weightId;
	}
	public Date getCreated_At() {
		return created_At;
	}
	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}
	public Date getUpdated_At() {
		return Updated_At;
	}
	public void setUpdated_At(Date updated_At) {
		Updated_At = updated_At;
	}

	@PrePersist
	public void onCreate()
	{
		this.created_At=new Date();
	}
	@PreUpdate
	public void onUpdate()
	{
		this.Updated_At=new Date();
	}
}