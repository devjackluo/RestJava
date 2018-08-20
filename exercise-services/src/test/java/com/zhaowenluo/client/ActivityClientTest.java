package com.zhaowenluo.client;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zhaowenluo.model.Activity;
import com.zhaowenluo.model.ActivitySearch;
import com.zhaowenluo.model.ActivitySearchType;

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
	
	@Test
	public void testSearch() {
		ActivitySearchClient client = new ActivitySearchClient();
		
		String param = "description";
		List<String> searchValues = new ArrayList();
		searchValues.add("Camping");
		searchValues.add("Eating");
		
		String secondParam = "durationFrom";
		int durationFrom = 30;
		String thirdParam = "durationTo";
		int durationTo = 55;
		
		List<Activity> activities = client.search(param, searchValues, secondParam, durationFrom, thirdParam, durationTo);
		
		assertNotNull(activities);
	}
	
	
	//OVERLOAD IS NOT A GOOD IDEA, TOO MUCH REFRACTORING IS SUCH
//	@Test
//	public void testSearchOverload() {
//		ActivitySearchClient client = new ActivitySearchClient();
//		
//		String param = "description";
//		List<String> searchValues = new ArrayList();
//		searchValues.add("Camping");
//		searchValues.add("Eating");
//		
//		List<Activity> activities = client.search(param, searchValues);
//		
//		assertNotNull(activities);
//	}
	
	@Test
	public void testSearchObject() {
		ActivitySearchClient client = new ActivitySearchClient();
	
		List<String> searchValues = new ArrayList<>();
		searchValues.add("biking");
		searchValues.add("running");
		
		ActivitySearch search = new ActivitySearch();
		search.setDescriptions(searchValues);
		search.setDurationFrom(30);
		search.setDurationTo(55);
		search.setSearchType(ActivitySearchType.SEARCH_BY_DESCRIPTION);
		
		List<Activity> activities = client.search(search);
		
		assertNotNull(activities);
	}


}
