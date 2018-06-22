
package fr.epita.quiz.services;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import fr.epita.quiz.datamodel.Login;

/**
 * This class is Authentication service for logging in the user
 *
 * @author  THEJUS
 *
 */

@Repository
public class AuthenticationService {
	
	@Inject
	private LoginDAO loginDao;
	
	
	
	public boolean authenticate(Login login) {
		return loginDao.search(login).size()>=1;
	}
	

}
