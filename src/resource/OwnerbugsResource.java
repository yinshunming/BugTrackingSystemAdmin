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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bean.WarppedManagedbugs;
import bean.WarppedOwnerbugs;

import service.IOwnerbugsService;
import util.ConstantUtil;
import util.Helper;

public class OwnerbugsResource extends BaseResource{
	private static final Logger log = LoggerFactory.getLogger(OwnerbugsResource.class);
	
	private IOwnerbugsService ownerbugsService;
	
	public IOwnerbugsService getOwnerbugsService() {
		return ownerbugsService;
	}

	public void setOwnerbugsService(IOwnerbugsService ownerbugsService) {
		this.ownerbugsService = ownerbugsService;
	}

	@Delete
	public Representation delete() {
		
		log.info("doing delete method!");
		Form form = getRequest().getResourceRef().getQueryAsForm();
		
		String id = form.getFirstValue("id");
		
		log.info("id " + id);
		ownerbugsService.deleteOwnerbugs(Integer.valueOf(id));
		
		log.info("doing delete method ok!");
		return new StringRepresentation(ConstantUtil.deletingOwnerbugOK);
	}
	
	@Get
	public Representation get() {
		log.info("doing get method!");
		List<WarppedOwnerbugs> warList = ownerbugsService.getOwnerbugs();
		JSONArray returnjn = Helper.convertFromList(warList);
		
		log.info("doing get method ok!");
		return new JsonRepresentation(returnjn);
	}
}
