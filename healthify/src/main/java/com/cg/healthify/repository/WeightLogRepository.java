package com.cg.healthify.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.healthify.beans.WeightLog;

/**
 * WeightLog repository interface
 * @author vinotraj
 *
 */

public interface WeightLogRepository extends JpaRepository<WeightLog, Long> {

	/**
	 * @param weightId
	 * find weightLog by using weightId
	 * @return
	 */
	
	WeightLog findByWeightId(String weightId);

}
