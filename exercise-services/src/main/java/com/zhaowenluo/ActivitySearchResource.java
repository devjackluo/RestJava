package com.zhaowenluo;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.zhaowenluo.model.Activity;
import com.zhaowenluo.model.ActivitySearch;
import com.zhaowenluo.repository.ActivityRepository;
import com.zhaowenluo.repository.ActivityRepositoryStub;

@Path("search/activities")
public class ActivitySearchResource {
	
	private ActivityRepository activityRepo = new ActivityRepositoryStub();
	
//	@GET
//	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//	//@Path("{activityId}")
//	public Response searchForActivities(@QueryParam(value = "description") List<String> descriptions) {
//		
//		System.out.println(descriptions);
//		
//		List<Activity> activities = activityRepo.findByDescription(descriptions);
//		
//		if(activities == null || activities.size() <= 0) {
//			return Response.status(Status.NOT_FOUND).build();
//		}
//		
//		return Response.ok().entity(new GenericEntity<List<Activity>>(activities) {}).build();
//		
//	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	//@Path("{activityId}")
	public Response searchForActivities(@QueryParam(value = "description") List<String> descriptions, 
			@QueryParam(value = "durationFrom") int durationFrom,
			@QueryParam(value = "durationTo") int durationTo) {
		
		System.out.println(descriptions + ", " + durationFrom + ", " + durationTo);
		
		List<Activity> activities = activityRepo.findByDescription(descriptions, durationFrom, durationTo);
		
		if(activities == null || activities.size() <= 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(new GenericEntity<List<Activity>>(activities) {}).build();
		
	}
	
	
	@POST
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	//@Path("{activityId}")
	public Response searchForActivities(ActivitySearch activitySearch) {
		
		List<Activity> activities = activityRepo.findByConstraints(activitySearch);
		
		if(activities == null || activities.size() <= 0) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		return Response.ok().entity(new GenericEntity<List<Activity>>(activities) {}).build();
		
	}
	
}
