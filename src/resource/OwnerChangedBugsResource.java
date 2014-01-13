package resource;

import java.util.List;

import org.json.JSONArray;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import bean.WarppedBuginfo;

import service.IOwnerbugsService;
import util.Helper;

public class OwnerChangedBugsResource extends ServerResource{
	
	private IOwnerbugsService ownerbugsService;
	
	public IOwnerbugsService getOwnerbugsService() {
		return ownerbugsService;
	}

	public void setOwnerbugsService(IOwnerbugsService ownerbugsService) {
		this.ownerbugsService = ownerbugsService;
	}

	
	@Get
	public Representation get(Representation entity) {
		String username = this.getRequest().getChallengeResponse().getIdentifier();
		List<WarppedBuginfo> changedList = ownerbugsService.getChangedListByUserName(username);
		
		JSONArray returnjn = Helper.convertFromList(changedList);
		return new JsonRepresentation(returnjn);
	}
}
