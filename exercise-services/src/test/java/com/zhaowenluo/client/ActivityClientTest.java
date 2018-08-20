package com.zhaowenluo.client;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.zhaowenluo.model.Activity;

public class ActivityClientTest {

	@Test
	public void testGet() {
		ActivityClient client = new ActivityClient();
		Activity activity = client.get("3");
		System.out.println(activity);
		System.out.println(activity.getId());
		System.out.println(activity.getDescription());
		System.out.println(activity.getDuration());
		assertNotNull(activity);
	}
	
	@Test
	public void testGetList() {
		ActivityClient client = new ActivityClient();
		List<Activity> activities = client.get();
		System.out.println(activities.get(0).getId());
		System.out.println(activities.get(0).getDescription());
		System.out.println(activities.get(0).getDuration());
		assertNotNull(activities);
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetWithBadRequest() {
		ActivityClient client = new ActivityClient();
		Activity activity = client.get("33");
	}
	
	@Test(expected=RuntimeException.class)
	public void testGetWithNotFound() {
		ActivityClient client = new ActivityClient();
		Activity activity = client.get("0");
	}
	
	@Test
	public void testAdd() {
		ActivityClient client = new ActivityClient();
		Activity activity = new Activity();
		activity.setId(4);
		activity.setDescription("Eating");
		activity.setDuration(90);
		
		activity = client.add(activity);
		
		assertNotNull(activity);
	}

	@Test
	public void testPut() {
		Activity activity = new Activity();
		activity.setId(2);
		activity.setDescription("Learning");
		activity.setDuration(12);
		
		ActivityClient client = new ActivityClient();
		activity = client.update(activity);
		
		assertNotNull(activity);
	}
	
	@Test
	public void testDelete() {
		ActivityClient client = new ActivityClient();
		Activity activity = client.delete(1);
		
		assertNotNull(activity);
	}

}
