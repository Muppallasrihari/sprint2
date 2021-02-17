package com.cg.healthify.service;

import org.springframework.stereotype.Component;

import com.cg.healthify.beans.WeightLog;

@Component
public interface WeightLogService {

	public WeightLog addOrUpdateWeightLog(WeightLog weightLog);
	public Iterable<WeightLog> getAllWeightLog();
	public  void deleteWeightLogById(String weightId);
	public WeightLog getWeightLogById(String weightId);
	public WeightLog updateWeightLog(String weightId, WeightLog weightLog);
}
