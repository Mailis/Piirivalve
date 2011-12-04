package ee.piirivalve.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityStuff {	
	public static String username () {
		String username;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		username = auth.getName();
		return username;
	}
}

