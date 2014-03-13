package resource;

import java.util.List;

import org.json.JSONArray;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean.Userinfo;

import service.IUserinfoService;
import util.Helper;

public class UserinfosResource extends BaseResource{
	private static final Logger log = LoggerFactory.getLogger(UserinfosResource.class);
	
	private IUserinfoService userinfoService;
	
	public IUserinfoService getUserinfoService() {
		return userinfoService;
	}
	
	public void setUserinfoService(IUserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}
	
	
	@Get
	public Representation get() {
		log.info("doing get method!");
		
		List<Userinfo> userinfoList = userinfoService.getUserinfoList();
		JSONArray returnStr = Helper.convertFromList(userinfoList);
		
		log.info("doing get method ok!");
		return new JsonRepresentation(returnStr);
	}
}
