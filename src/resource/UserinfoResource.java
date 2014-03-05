package resource;

import java.util.HashMap;
import java.util.Map;

import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;

import org.restlet.resource.Delete;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import service.IUserinfoService;
import util.ConstantUtil;

public class UserinfoResource extends BaseResource{
	private IUserinfoService userinfoService;
	
	
	public IUserinfoService getUserinfoService() {
		return userinfoService;
	}

	public void setUserinfoService(IUserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}
	

	@Post
	public Representation post(Representation entity) {
		Form form = new Form(entity);
		
		String username = form.getFirstValue("username");
		String password = form.getFirstValue("password");
		String oneBugFullName = form.getFirstValue("oneBugFullName");
		String email = form.getFirstValue("email");
		
		Integer id = userinfoService.addUserinfo(username, password, oneBugFullName, email);
		
		Map<String, String> map = new HashMap<String,String>();
		map.put(id.toString(), ConstantUtil.savingUserinfoOK);
		
		return new JsonRepresentation(map);
	}
	
	@Put
	public Representation put(Representation entity) {
		Form form =  getRequest().getResourceRef().getQueryAsForm();
		String id = form.getFirstValue("id");
		String username = form.getFirstValue("username");
		String password = form.getFirstValue("password");
		String oneBugFullName = form.getFirstValue("oneBugFullName");
		String email = form.getFirstValue("email");
		userinfoService.updateUserinfo(Integer.valueOf(id), username, password, oneBugFullName, email);
		
		return new StringRepresentation(ConstantUtil.updatingUserinfoOK);
	}
	
	@Delete
	public Representation delete() {
		Form form = getRequest().getResourceRef().getQueryAsForm();
		String id = form.getFirstValue("id");
		
		userinfoService.deleteUserinfo(Integer.valueOf(id));
		
		
		return new StringRepresentation(ConstantUtil.deletingUserinfoOK);
	}
}
