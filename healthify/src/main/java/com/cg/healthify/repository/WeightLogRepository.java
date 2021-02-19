package com.cg.healthify.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthify.beans.WeightLog;

/**
 * WeightLog repository interface
 * @author vinotraj
 *
 */
@Repository
public interface WeightLogRepository extends JpaRepository<WeightLog, Long> {

	/**
	 * @param weightId
	 * find weightLog by using weightId
	 * @return
	 */
	
	WeightLog findByWeightId(String weightId);

}
