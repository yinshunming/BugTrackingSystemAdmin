package resource;

import java.util.List;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import bean.Buginfo;
import bean.WarppedBuginfo;

import service.IBuginfoService;
import service.IManagedbugsService;
import service.IOwnerbugsService;
import util.Helper;

public class MainFrameResource extends ServerResource{

	private IOwnerbugsService ownerbugsService;
	private IManagedbugsService managedbugsService;
	
	public IManagedbugsService getManagedbugsService() {
		return managedbugsService;
	}

	public void setManagedbugsService(IManagedbugsService managedbugsService) {
		this.managedbugsService = managedbugsService;
	}

	@Get
	public Representation get(Representation entity) {		
		String username = this.getRequest().getChallengeResponse().getIdentifier();
		List<Buginfo> ownerBuginfoList = ownerbugsService.getOwnerBuginfoListByUserName(username);
		List<Buginfo> managedBuginfoList = managedbugsService.getManagedBugsByUserName(username);
		List<WarppedBuginfo> changedBuginoList = ownerbugsService.getChangedListByUserName(username);
		
		JSONObject returnjn = new JSONObject();
		try {
			returnjn.put("ownerList", Helper.convertFromList(ownerBuginfoList));
			returnjn.put("managedList", Helper.convertFromList(managedBuginfoList));
			returnjn.put("changedList", Helper.convertFromList(changedBuginoList));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new JsonRepresentation(returnjn);
	}

	public IOwnerbugsService getOwnerbugsService() {
		return ownerbugsService;
	}

	public void setOwnerbugsService(IOwnerbugsService ownerbugsService) {
		this.ownerbugsService = ownerbugsService;
	}
}
