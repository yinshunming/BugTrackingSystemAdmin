package resource;

import java.util.List;

import org.json.JSONArray;
import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




import bean.WarppedManagedbugs;

import service.IManagedbugsService;
import util.ConstantUtil;
import util.Helper;

public class ManagedbugsResource extends BaseResource{

	private static final Logger log = LoggerFactory.getLogger(ManagedbugsResource.class);

	private IManagedbugsService managedbugsService;


	@Delete
	public Representation delete() {
		log.info("doing delete method!");
		
		Form form = getRequest().getResourceRef().getQueryAsForm();
		
		String id = form.getFirstValue("id");
		
		log.info("id : " + id);
		
		managedbugsService.deleteManagedbug(Integer.valueOf(id));
		
		log.info("doing delete method ok!");
		
		return new StringRepresentation(ConstantUtil.deletingManagedbugOK);				
	}
	
	@Get
	public Representation get() {
		log.info("doing get method!!!");
		
		List<WarppedManagedbugs> warList = managedbugsService.getManagedbugsList();
		JSONArray returnjn = Helper.convertFromList(warList);
		
		log.info("doing get method ok!!!");
		return new JsonRepresentation(returnjn);
	}
	
	public IManagedbugsService getManagedbugsService() {
		return managedbugsService;
	}

	public void setManagedbugsService(IManagedbugsService managedbugsService) {
		this.managedbugsService = managedbugsService;
	}

	@Post
	public Representation post(Representation entity) {
		Form form = getRequest().getResourceRef().getQueryAsForm();
		
		String userinfoId = form.getFirstValue("userinfoId");
		String buginfoId = form.getFirstValue("buginfoId");
		
		managedbugsService.addManagedbug(Integer.valueOf(userinfoId), buginfoId);
		
		return new StringRepresentation(ConstantUtil.addManagedbugsOK);
	}
	
	
	@Put
	public Representation put(Representation entity) {
		Form form = getRequest().getResourceRef().getQueryAsForm();
			
		String id = form.getFirstValue("id");
		String userinfoId = form.getFirstValue("userinfoId");
		String buginfoId = form.getFirstValue("buginfoId");
		
		managedbugsService.updateManagedbug( Integer.valueOf(id), Integer.valueOf(userinfoId), Integer.valueOf(buginfoId));
		
		return new StringRepresentation(ConstantUtil.updatingManagedbugOK);
	}
	

	
	
}
