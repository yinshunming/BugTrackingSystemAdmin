package resource;

import java.util.List;


import org.json.JSONArray;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import database.DataMartAccess;

import service.IBuginfoService;
import util.Helper;

import bean.Buginfo;

public class RereshResource extends ServerResource{
	
	private IBuginfoService buginfoService;
	public IBuginfoService getBuginfoService() {
		return buginfoService;
	}
	public void setBuginfoService(IBuginfoService buginfoService) {
		this.buginfoService = buginfoService;
	}
	
	@Get
	public Representation get(Representation entity) {
		String username = this.getRequest().getChallengeResponse().getIdentifier();
		
		List<Buginfo> ownerBuginfoList = buginfoService.getBuginfoListByUserName(username, true);
		
		List<Buginfo> differentBuginfo = buginfoService.refreshBuginfo(ownerBuginfoList);
		
		JSONArray return_arr = Helper.convertFromList(differentBuginfo);
		
		return new JsonRepresentation(return_arr);
	}
}
