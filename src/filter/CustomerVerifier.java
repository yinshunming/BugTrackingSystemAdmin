package filter;

import java.util.List;

import org.restlet.security.MapVerifier;

import service.IAdmininfoService;

import bean.Admininfo;
import bean.Userinfo;



public class CustomerVerifier extends MapVerifier{
		
		private IAdmininfoService admininfoService;
	
	
		public IAdmininfoService getAdmininfoService() {
			return admininfoService;
		}


		public void setAdmininfoService(IAdmininfoService admininfoService) {
			this.admininfoService = admininfoService;
		}


		public char[] getLocalSecret(String identifier) {
			// Could have a look into a database, LDAP directory, etc.
			Admininfo admininfo = admininfoService.getAdmininfoByUsername(identifier);
			
	        if (admininfo != null && admininfo.getUsername().equals(identifier)) {  
	            return admininfo.getPassword().toCharArray();  
	        }  
	  
	        return null; 

		}
		
		
}
