package com.zhaowenluo.repository;

import java.util.List;

import com.zhaowenluo.model.Activity;
import com.zhaowenluo.model.ActivitySearch;

public interface ActivityRepository {

	List<Activity> findAllActivities();
	Activity findActivity(String activityId);
	
	void addActivity(Activity activity);
	Activity updateActivity(Activity activity);
	Activity deleteActivity(String activityId);
	//List<Activity> findByDescription(List<String> descriptions);
	List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo);
	List<Activity> findByConstraints(ActivitySearch activitySearch);


}