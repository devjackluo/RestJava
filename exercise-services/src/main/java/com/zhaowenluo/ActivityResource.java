package com.zhaowenluo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.zhaowenluo.model.Activity;
import com.zhaowenluo.model.User;
import com.zhaowenluo.repository.ActivityRepository;
import com.zhaowenluo.repository.ActivityRepositoryStub;

@Path("activities")
public class ActivityResource {

	//kind of creating a new instance of this every request(get,post,etc) so the constructor is making a new one every time
	private ActivityRepository activityRepository = new ActivityRepositoryStub();
	
	@GET
	//@Produces(MediaType.APPLICATION_XML)
	//@Produces(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities(){
		return activityRepository.findAllActivities();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}")
	public Response getActivity(@PathParam ("activityId") String activityId){
		
//		System.out.println(Integer.parseInt(activityId));
//		System.out.println(activityRepository.findAllActivities().size());
		if(activityId == null || Integer.parseInt(activityId) > activityRepository.findAllActivities().size() || activityId.length() > 1) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		Activity activity = activityRepository.findActivity(activityId);
		
		if(activity == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
		
		//return Response.status(Status.OK).build();
		return Response.ok().entity(activity).build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}/user")
	public User getActivityUser(@PathParam ("activityId") String activityId){
		return activityRepository.findActivity(activityId).getUser();
	}
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Activity createActivityParams(MultivaluedMap<String, String> formParams) {
		
		System.out.println(formParams.getFirst("description"));
		System.out.println(formParams.getFirst("duration"));
		
		Activity activity1 = new Activity();
		activity1.setId(666);
		activity1.setDescription(formParams.getFirst("description"));
		activity1.setDuration(Integer.parseInt(formParams.getFirst("duration")));
		
		//doesn't really save it...
		activityRepository.addActivity(activity1);

		return activity1;
	}
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Activity createActivity(Activity activity) {
		
		System.out.println(activity.getId());
		System.out.println(activity.getDescription());
		System.out.println(activity.getDuration());
		System.out.println(activity.getUser());
		
		//doesn't really save it...
		activityRepository.addActivity(activity);

		return activity;
	}
	
	
	@PUT
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response updateActivity(Activity activity) {
		
//		System.out.println(activity.getId());
//		System.out.println(activity.getDescription());
//		System.out.println(activity.getDuration());
//		System.out.println(activity.getUser());
		
		Activity activityUpdated = activityRepository.updateActivity(activity);

		return Response.ok().entity(activityUpdated).build();
	}
	
	@DELETE
	@Path("{activityId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response deleteActivity(@PathParam ("activityId") String activityId) {

		Activity activityUpdated = activityRepository.deleteActivity(activityId);

		return Response.ok().entity(activityUpdated).build();
	}
	
}
