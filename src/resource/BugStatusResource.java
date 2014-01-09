package resource;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.restlet.data.Form;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import service.IBuginfoService;
import util.Helper;

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
	
	@Post
	public Representation post(Representation entity) {
		System.out.println("post post post");
		Form form = new Form(entity);
		Map<String, String> map = form.getValuesMap();
		System.out.println(form.getValuesMap());
		
		
		Map<String, String> retMap = new HashMap<String, String>();
		Iterator iter = map.entrySet().iterator(); 
		
		while (iter.hasNext()) { 
		    Map.Entry entry = (Map.Entry) iter.next(); 
		    String id = entry.getKey().toString(); 
		    String bugId = entry.getValue().toString(); 
		    String bugStatus = CrawlStatusFromOneBug.crawlOneBug(bugId);
		    buginfoService.updateStatus(Integer.valueOf(id), bugId, bugStatus);
		    System.out.println(id + "");
		    retMap.put(id, bugStatus);
		} 
		
		return new JsonRepresentation(Helper.convertFromMap(retMap));
	}

	public IBuginfoService getBuginfoService() {
		return buginfoService;
	}

	public void setBuginfoService(IBuginfoService buginfoService) {
		this.buginfoService = buginfoService;
	}
	
}
