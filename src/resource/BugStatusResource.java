package resource;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import service.IBuginfoService;

import crawl.CrawlStatusFromOneBug;

public class BugStatusResource extends ServerResource{
	
	private IBuginfoService buginfoService;
	
	@Get 
	public Representation get(Representation entity) {
		Form form = getRequest().getResourceRef().getQueryAsForm();  
		String id = form.getFirstValue("id");
		String bugId = form.getFirstValue("bugId");

		String bugStatus = CrawlStatusFromOneBug.crawlOneBug(bugId);
		
		buginfoService.updateStatus(Integer.valueOf(id), bugId, bugStatus);
			
		return new StringRepresentation(bugStatus);
	}

	public IBuginfoService getBuginfoService() {
		return buginfoService;
	}

	public void setBuginfoService(IBuginfoService buginfoService) {
		this.buginfoService = buginfoService;
	}
	
}
