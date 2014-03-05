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

import bean.WarppedManagedbugs;
import bean.WarppedOwnerbugs;

import service.IOwnerbugsService;
import util.ConstantUtil;
import util.Helper;

public class OwnerbugsResource extends BaseResource{
	private IOwnerbugsService ownerbugsService;
	
	public IOwnerbugsService getOwnerbugsService() {
		return ownerbugsService;
	}

	public void setOwnerbugsService(IOwnerbugsService ownerbugsService) {
		this.ownerbugsService = ownerbugsService;
	}

	@Delete
	public Representation delete() {
		Form form = getRequest().getResourceRef().getQueryAsForm();
		
		String id = form.getFirstValue("id");
		
		ownerbugsService.deleteOwnerbugs(Integer.valueOf(id));
		
		return new StringRepresentation(ConstantUtil.deletingOwnerbugOK);
	}
	
	@Get
	public Representation get() {
		
		List<WarppedOwnerbugs> warList = ownerbugsService.getOwnerbugs();
		JSONArray returnjn = Helper.convertFromList(warList);
		return new JsonRepresentation(returnjn);
	}
}
