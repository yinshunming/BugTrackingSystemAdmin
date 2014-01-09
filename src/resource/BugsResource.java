package resource;

import java.util.Map;

import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import bean.Buginfo;

import service.IBuginfoService;

public class BugsResource extends ServerResource{
	
	private IBuginfoService buginfoService;
	
	@Post 
	public Representation post(Representation entity) {
		Form form = new Form(entity);
		String bugId = form.getFirstValue("bugId");
		String component = form.getFirstValue("component");
		String title = form.getFirstValue("title");
		String project = form.getFirstValue("project");
		String type = form.getFirstValue("type");
		String status = form.getFirstValue("status");
		String description = form.getFirstValue("description");
		String owner = form.getFirstValue("owner");
		String submitter = form.getFirstValue("submitter");
		String submitData = form.getFirstValue("submitData");
		String severity = form.getFirstValue("severity");
		String tags = form.getFirstValue("tags");
		String regression = form.getFirstValue("regression");
		
		String username = this.getRequest().getChallengeResponse().getIdentifier();
		buginfoService.saveBuginfo(username, bugId, component, title, project,  type, status, description, owner, submitter, submitData, severity, tags, regression);
		
		return new StringRepresentation("add this bug successfully!");
	}
	
	@Get
	public Representation get(Representation entity) {
		
		Form form = getRequest().getResourceRef().getQueryAsForm();  
		String bugId = form.getFirstValue("bugId");
		
		System.out.println("bugId " + bugId);
		
		Buginfo bi = buginfoService.getBuginfoById(bugId);
		
		return new JsonRepresentation(new JSONObject(bi));
	}
	
	@Put
	public Representation put(Representation entity) {
		String username = this.getRequest().getChallengeResponse().getIdentifier();
		Form form = new Form(entity);  
		
		Map<String, String> radio_map = form.getValuesMap();
		
		buginfoService.modifyBugCategory(radio_map, username);
		
		return new StringRepresentation("Modify OK");
	}
	
	
	public IBuginfoService getBuginfoService() {
		return buginfoService;
	}
	
	public void setBuginfoService(IBuginfoService buginfoService) {
		this.buginfoService = buginfoService;
	}
}
