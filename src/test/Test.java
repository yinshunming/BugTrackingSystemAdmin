package test;

import java.io.IOException;

import org.restlet.data.ChallengeScheme;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

public class Test {
	public static void main(String args[]) {
		ClientResource resource = new ClientResource("http://localhost:8080/BugTrackingSystemAdmin/api/managedBugs?id=2");

		resource.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "admin", "admin");
		// Send the first request with unsufficient authentication.
			try {
			    resource.delete();
			} catch (ResourceException re) {
		}
		
			System.out.println(resource.getResponse());
	}
}
