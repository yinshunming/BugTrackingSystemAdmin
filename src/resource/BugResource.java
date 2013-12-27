package resource;

import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import bean.Buginfo;

import service.IBuginfoService;

public class BugResource extends ServerResource{
	
	private IBuginfoService bugInfoService;
	
	public IBuginfoService getBugInfoService() {
		return bugInfoService;
	}

	public void setBugInfoService(IBuginfoService bugInfoService) {
		this.bugInfoService = bugInfoService;
	}
	
	@Get
	public Representation get(Representation entity) {
		Form form = getRequest().getResourceRef().getQueryAsForm();  
		Integer id = Integer.valueOf(form.getFirstValue("id"));
		
		System.out.println("Database Id " + id);
		
		Buginfo bi = bugInfoService.getBuginfoFromLocalById(id);
		
		return new JsonRepresentation(new JSONObject(bi));
	}
}
