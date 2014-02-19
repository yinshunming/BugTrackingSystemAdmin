package resource;

import org.restlet.data.Form;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class LogoutResource extends ServerResource{
	@Get 
	public Representation get(Representation entity) {
		String username = this.getRequest().getChallengeResponse().getIdentifier();
		
		return new StringRepresentation(username);	
	}
	
	
	@Post 
	public Representation post(Representation entity) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
//		String username = this.getRequest().getChallengeResponse().getIdentifier();
//		Form form = getRequest().getResourceRef().getQueryAsForm();  
//		String username1 = form.getFirstValue("username");

	//	this.getResponse().setStatus(Status.CLIENT_ERROR_UNAUTHORIZED);
		
		return new StringRepresentation("logouting ok!");
	}
}
