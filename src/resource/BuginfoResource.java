package resource;

import java.util.Map;

import org.json.JSONObject;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean.Buginfo;

import service.IBuginfoService;
import service.IOwnerbugsService;


public class BuginfoResource extends BaseResource{
	
	private static final Logger log = LoggerFactory.getLogger(BuginfoResource.class);
	
	private IBuginfoService buginfoService;

	
	@Get
	public Representation get() {
		log.info("doing get method!");
		
		Form form = getRequest().getResourceRef().getQueryAsForm();  
		String bugId = form.getFirstValue("bugId");
		
		log.info("bugId " + bugId);
		
		Buginfo bi = buginfoService.getBuginfoById(bugId);
		
		log.info("doing get method ok!");
		
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
