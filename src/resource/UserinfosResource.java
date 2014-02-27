package resource;

import java.util.List;

import org.json.JSONArray;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import bean.Userinfo;

import service.IUserinfoService;
import util.Helper;

public class UserinfosResource extends ServerResource{
	
	private IUserinfoService userinfoService;
	
	public IUserinfoService getUserinfoService() {
		return userinfoService;
	}
	
	public void setUserinfoService(IUserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}
	
	
	@Get
	public Representation get(Representation entity) {
		List<Userinfo> userinfoList = userinfoService.getUserinfoList();
		JSONArray returnStr = Helper.convertFromList(userinfoList);
		
		return new JsonRepresentation(returnStr);
	}
}
