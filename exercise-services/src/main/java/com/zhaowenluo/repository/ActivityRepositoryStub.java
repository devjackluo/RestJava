package com.zhaowenluo.repository;

import java.util.ArrayList;
import java.util.List;

import com.zhaowenluo.model.Activity;
import com.zhaowenluo.model.ActivitySearch;
import com.zhaowenluo.model.User;

public class ActivityRepositoryStub implements ActivityRepository {
	

	private List<Activity> activities = new ArrayList<Activity>();
	
	public ActivityRepositoryStub() {
		
		User user = new User();
		user.setId("1");
		user.setName("Jack");
		
		Activity activity1 = new Activity();
		activity1.setId(1);
		activity1.setDescription("Swimming");
		activity1.setDuration(55);
		activity1.setUser(user);
		
		Activity activity2 = new Activity();
		activity2.setId(2);
		activity2.setDescription("Cycling");
		activity2.setDuration(120);
		activity2.setUser(user);
		
		Activity activity3 = new Activity();
		activity3.setId(3);
		activity3.setDescription("Jogging");
		activity3.setDuration(45);
		activity3.setUser(user);
		
		activities.add(activity1);
		activities.add(activity2);
		activities.add(activity3);
		
		System.out.println("Ran Repo constructor");
	}
	
	@Override
	public List<Activity> findAllActivities(){

		return activities;
	}

	@Override
	public Activity findActivity(String activityId) {
		
		if(activityId.equals("0")) {
			return null;
		}
		return activities.get(Integer.parseInt(activityId)-1);
		
	}

	@Override
	public void addActivity(Activity activity) {
		this.activities.add(activity);
	}

	@Override
	public Activity updateActivity(Activity activity) {
		//System.out.println(activity.getDescription());
		//System.out.println(activity.getDuration());
		Activity toUpdate = activities.get(activity.getId()-1);
		//System.out.println(toUpdate);
		toUpdate.setDescription(activity.getDescription());
		toUpdate.setDuration(activity.getDuration());
		toUpdate.setUser(activity.getUser());
		
		return toUpdate;
	}

	@Override
	public Activity deleteActivity(String activityId) {
		return activities.remove(Integer.parseInt(activityId)-1);
	}

//	@Override
//	public List<Activity> findByDescription(List<String> descriptions) {
//		
//		// select * from activities where description in (?,?,?)
//		
//		Activity activity = new Activity();
//		activity.setId(7);
//		activity.setDescription("Camping");
//		activity.setDuration(1000);
//		
//		this.activities.add(activity);
//		
//		return this.activities;
//	}

	@Override
	public List<Activity> findByDescription(List<String> descriptions, int durationFrom, int durationTo) {
		// select * from activities where description in (?,?,?) and duration > ? and duration < ?
		
		Activity activity = new Activity();
		activity.setId(7);
		activity.setDescription("Camping");
		activity.setDuration(1000);
		
		Activity activity2 = new Activity();
		activity2.setId(10);
		activity2.setDescription("Coding");
		activity2.setDuration(10000000);
		
		this.activities.add(activity);
		this.activities.add(activity2);
		
		return this.activities;
	}

	@Override
	public List<Activity> findByConstraints(ActivitySearch activitySearch) {
		
		System.out.println(activitySearch.getSearchType());
		
		Activity activity = new Activity();
		activity.setId(7);
		activity.setDescription("Camping");
		activity.setDuration(1000);
		
		Activity activity2 = new Activity();
		activity2.setId(10);
		activity2.setDescription("Coding");
		activity2.setDuration(10000000);
		
		Activity activity3 = new Activity();
		activity3.setId(10);
		activity3.setDescription("Coding2.0");
		activity3.setDuration(325236535);
		
		this.activities.add(activity);
		this.activities.add(activity2);
		this.activities.add(activity3);
		
		return this.activities;
		
	}
	
}
