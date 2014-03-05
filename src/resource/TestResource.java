package resource;

import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

public class TestResource extends BaseResource{
	@Delete
	public Representation delete(Representation entity) {
		return null;
	}
	
	@Get
	public Representation get(Representation entity) {
		return null;
	}
	
	@Post
	public Representation post(Representation entity) {
		return null;
	}
	
	@Put
	public Representation put(Representation entity) {
		return null;
	}
}
