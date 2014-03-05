package resource;

import org.restlet.resource.ServerResource;

public class BaseResource extends ServerResource{
	public BaseResource() {
		super();
		this.setNegotiated(false);
	}
}
