package resource;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONStringer;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;

import org.restlet.resource.Delete;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import service.IUserinfoService;
import util.ConstantUtil;

public class UserinfoResource extends BaseResource{
	
	private static final Logger log = LoggerFactory.getLogger(UserinfoResource.class);
	private IUserinfoService userinfoService;
	
	
	public IUserinfoService getUserinfoService() {
		return userinfoService;
	}

	public void setUserinfoService(IUserinfoService userinfoService) {
		this.userinfoService = userinfoService;
	}
	

	@Post
	public Representation post(Representation entity) {
		
		log.info("doing post method!");
		Form form = new Form(entity);
		
		String username = form.getFirstValue("username");
		String password = form.getFirstValue("password");
		String oneBugFullName = form.getFirstValue("oneBugFullName");
		String email = form.getFirstValue("email");
		
		Integer id = userinfoService.addUserinfo(username, password, oneBugFullName, email);
		
		String myString = "";
		try {
			myString = new JSONStringer().object().key("id").value(id.toString()).key("message").value(ConstantUtil.savingUserinfoOK).endObject().toString();
			log.info(myString.toString());
			log.info("doing post method ok!");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return new JsonRepresentation(myString);
	}
	
	@Put
	public Representation put(Representation entity) {
		log.info("doing put method!");
		
		Form form =  getRequest().getResourceRef().getQueryAsForm();
		String id = form.getFirstValue("id");
		String username = form.getFirstValue("username");
		String password = form.getFirstValue("password");
		String oneBugFullName = form.getFirstValue("oneBugFullName");
		String email = form.getFirstValue("email");
		
		log.info("id " + id);
		
		userinfoService.updateUserinfo(Integer.valueOf(id), username, password, oneBugFullName, email);
		
		log.info("doing put method ok!");
		return new StringRepresentation(ConstantUtil.updatingUserinfoOK);
	}
	
	@Delete
	public Representation delete() {
		
		log.info("doing delete method!");
		Form form = getRequest().getResourceRef().getQueryAsForm();
		String id = form.getFirstValue("id");
		
		log.info("id " + id);
		
		userinfoService.deleteUserinfo(Integer.valueOf(id));
		
		log.info("doing delete method ok!");
		
		return new StringRepresentation(ConstantUtil.deletingUserinfoOK);
	}
}
