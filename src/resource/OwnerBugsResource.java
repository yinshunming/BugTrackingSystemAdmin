package resource;

import java.util.List;

import org.json.JSONArray;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import bean.Buginfo;
import bean.WarppedBuginfo;

import service.IBuginfoService;
import util.Helper;

public class OwnerBugsResource extends ServerResource{
	private IBuginfoService buginfoService;
	
	@Get 
	public Representation get(Representation entity) {
		String username = this.getRequest().getChallengeResponse().getIdentifier();
		
		List<WarppedBuginfo> buginfoList = buginfoService.getHistoryOwnerBuginfoListByUserName(username);
		
		JSONArray returnjn = Helper.convertFromList(buginfoList);
		return new JsonRepresentation(returnjn);
	}
	
	@Put
	public Representation put(Representation entity) {
		String username = this.getRequest().getChallengeResponse().getIdentifier();
		
		Form form = getRequest().getResourceRef().getQueryAsForm();  
		String id = form.getFirstValue("id");
		String operate = form.getFirstValue("operate");
		String managedBugId = form.getFirstValue("managedBugId");
		
		buginfoService.operateBuginfoByUserName(username, Integer.valueOf(managedBugId), Integer.valueOf(id), operate);
		return new StringRepresentation("operating ok!");
	}
	
	@Delete
	public Representation delete(Representation entity) {
		String username = this.getRequest().getChallengeResponse().getIdentifier();
		
		Form form = getRequest().getResourceRef().getQueryAsForm();  
		String id = form.getFirstValue("id");
		String managedBugId = form.getFirstValue("managedBugId");
		
		buginfoService.deleteById(username, Integer.valueOf(managedBugId), Integer.valueOf(id));

		return new StringRepresentation("deleting ok!");
	}
	
	public IBuginfoService getBuginfoService() {
		return buginfoService;
	}
	
	public void setBuginfoService(IBuginfoService buginfoService) {
		this.buginfoService = buginfoService;
	}
}
