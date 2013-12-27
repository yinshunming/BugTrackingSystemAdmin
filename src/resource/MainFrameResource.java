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

import service.IBuginfoService;
import service.IManagedbugsService;
import util.Helper;

public class MainFrameResource extends ServerResource{
	private IBuginfoService buginfoService;
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
		List<Buginfo> ownerBuginfoList = buginfoService.getBuginfoListByUserName(username, true);
		List<Buginfo> managedBuginfoList = managedbugsService.getManagedBugsByUserName(username);
		
		JSONObject returnjn = new JSONObject();
		try {
			returnjn.put("ownerList", Helper.convertFromList(ownerBuginfoList));
			returnjn.put("managedList", Helper.convertFromList(managedBuginfoList));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new JsonRepresentation(returnjn);
	}

	public IBuginfoService getBuginfoService() {
		return buginfoService;
	}

	public void setBuginfoService(IBuginfoService buginfoService) {
		
		this.buginfoService = buginfoService;
	}
}
