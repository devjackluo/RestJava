package com.zhaowenluo.repository;

import java.util.List;

import com.zhaowenluo.model.Activity;

public interface ActivityRepository {

	List<Activity> findAllActivities();
	Activity findActivity(String activityId);
	
	void addActivity(Activity activity);
	Activity updateActivity(Activity activity);
	Activity deleteActivity(String activityId);

}