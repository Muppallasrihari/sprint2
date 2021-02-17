package com.cg.healthify.repository;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.cg.healthify.beans.WeightLog;

/**
 * WeightLog repository interface
 * @author vinotraj
 *
 */
@Repository
public interface WeightLogRepository extends CrudRepository<WeightLog, String> {

	/**
	 * @param weightId
	 * find weightLog by using weightId
	 * @return
	 */
	WeightLog findByWeightId(String weightId);

}
