package filter;

import org.restlet.Context;
import org.restlet.data.ChallengeScheme;
import org.restlet.security.ChallengeAuthenticator;

public class CustomerAuthenticator extends ChallengeAuthenticator{
	
	public CustomerAuthenticator(Context context, ChallengeScheme challengeScheme,
			String realm) {
		
		super(context, challengeScheme, realm);
		// TODO Auto-generated constructor stub

	}
	
	public CustomerAuthenticator() {
		this(Context.getCurrent(), ChallengeScheme.HTTP_BASIC, "Please input your username and password");
	}

}
