package resource;

import java.util.Map;

import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;

import bean.Buginfo;

import service.IBuginfoService;
import service.IOwnerbugsService;

public class BuginfoResource extends BaseResource{
	
	private IBuginfoService buginfoService;

	
	@Get
	public Representation get() {
		
		Form form = getRequest().getResourceRef().getQueryAsForm();  
		String bugId = form.getFirstValue("bugId");
		
		System.out.println("bugId " + bugId);
		
		Buginfo bi = buginfoService.getBuginfoById(bugId);
		
		return new JsonRepresentation(new JSONObject(bi));
	}
	
	
	/*
	@Put
	public Representation put(Representation entity) {
		String username = this.getRequest().getChallengeResponse().getIdentifier();
		Form form = new Form(entity);  
		
		Map<String, String> radio_map = form.getValuesMap();
		
		buginfoService.modifyBugCategory(radio_map, username);
		
		return new StringRepresentation("Modify OK");
	}
	*/
	
	
	public IBuginfoService getBuginfoService() {
		return buginfoService;
	}
	
	public void setBuginfoService(IBuginfoService buginfoService) {
		this.buginfoService = buginfoService;
	}

	
}
