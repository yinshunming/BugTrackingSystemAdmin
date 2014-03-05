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




import bean.WarppedManagedbugs;

import service.IManagedbugsService;
import util.ConstantUtil;
import util.Helper;

public class ManagedbugsResource extends BaseResource{
	
	private IManagedbugsService managedbugsService;

	


	@Delete
	public Representation delete() {
		Form form = getRequest().getResourceRef().getQueryAsForm();
		
		String id = form.getFirstValue("id");
		System.out.println("id : " + id);
		managedbugsService.deleteManagedbug(Integer.valueOf(id));
		
		return new StringRepresentation(ConstantUtil.deletingManagedbugOK);		
		
	}
	
	@Get
	public Representation get() {
		List<WarppedManagedbugs> warList = managedbugsService.getManagedbugsList();
		JSONArray returnjn = Helper.convertFromList(warList);
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
		Form form = new Form(entity);
		
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
