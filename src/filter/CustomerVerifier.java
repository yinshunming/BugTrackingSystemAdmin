package filter;

import java.util.List;

import org.restlet.security.MapVerifier;

import bean.Userinfo;

import service.IUserinfoSerivce;

public class CustomerVerifier extends MapVerifier{
		private IUserinfoSerivce userinfoService;
		public char[] getLocalSecret(String identifier) {
			// Could have a look into a database, LDAP directory, etc.
			Userinfo userinfo = userinfoService.getUserinfoByUsername(identifier);
	        if (userinfo != null && userinfo.getUsername().equals(identifier)) {  
	            return userinfo.getPassword().toCharArray();  
	        }  
	  
	        return null;  
		 }
		public IUserinfoSerivce getUserinfoService() {
			return userinfoService;
		}
		public void setUserinfoService(IUserinfoSerivce userinfoService) {
			this.userinfoService = userinfoService;
		}


}
