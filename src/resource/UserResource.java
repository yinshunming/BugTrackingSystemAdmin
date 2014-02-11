package resource;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import service.IBuginfoService;
import service.IUserinfoSerivce;

import dao.IUserinfoDAO;

public class UserResource extends ServerResource{
	private IUserinfoSerivce userinfoService;
	private IBuginfoService buginfoService;
	@Get
	public Representation get(Representation entity) {
		return new StringRepresentation("ok");
	}
	
	public IBuginfoService getBuginfoService() {
		return buginfoService;
	}

	public void setBuginfoService(IBuginfoService buginfoService) {
		this.buginfoService = buginfoService;
	}

	@Post
	public Representation post(Representation entity) {
		Form form = new Form(entity);
		String username = form.getFirstValue("username");
		String password = form.getFirstValue("password");
		String oneBugFullName = form.getFirstValue("oneBugFullName");
		String email = form.getFirstValue("email");
		
		userinfoService.save(username, password, oneBugFullName, email);
		buginfoService.addOwnerBuginfoList(oneBugFullName, username);
		
		return new StringRepresentation("adding userinfo successfully!");
	}

	public IUserinfoSerivce getUserinfoService() {
		return userinfoService;
	}

	public void setUserinfoService(IUserinfoSerivce userinfoService) {
		this.userinfoService = userinfoService;
	}


}
