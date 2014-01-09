package resource;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import bean.Buginfo;
import bean.WarppedBuginfo;

import service.IManagedbugsService;
import util.Helper;

public class ManagedBugsResource extends ServerResource{
	
	private IManagedbugsService managedbugsService;
	
	@Get 
	public Representation get(Representation entity) {
		
		String username = this.getRequest().getChallengeResponse().getIdentifier();
		List<WarppedBuginfo> historyBuginfoMap = managedbugsService.getHistroyManagedBugsByUserName(username);
		
		JSONArray returnjn = Helper.convertFromList(historyBuginfoMap);
		
		return new JsonRepresentation(returnjn);
	}
	
	@Post 
	public Representation post(Representation entity) {
		
		return null;
	}
	
	@Put
	public Representation put(Representation entity) {
		String username = this.getRequest().getChallengeResponse().getIdentifier();
		System.out.println("putingputingputing");
		Form form = getRequest().getResourceRef().getQueryAsForm();  
		String managedBugId = form.getFirstValue("managedBugId");
		String id = form.getFirstValue("id");
		String operate = form.getFirstValue("operate");
		
		managedbugsService.operateBugsByUserName(username, Integer.valueOf(managedBugId), Integer.valueOf(id), operate);
		return new StringRepresentation("operating ok!");
	}
	
	@Delete 
	public Representation delete(Representation entity) {
		String username = this.getRequest().getChallengeResponse().getIdentifier();
		System.out.println("deleting!!!");
		Form form = getRequest().getResourceRef().getQueryAsForm();  
		String managedBugId = form.getFirstValue("managedBugId");
		String id = form.getFirstValue("id");
		
		managedbugsService.deleteBugsByUserName(username, Integer.valueOf(managedBugId), Integer.valueOf(id));
		
		return new StringRepresentation("deteing ok!");
	}

	public IManagedbugsService getManagedbugsService() {
		return managedbugsService;
	}

	public void setManagedbugsService(IManagedbugsService managedbugsService) {
		this.managedbugsService = managedbugsService;
	}
}
