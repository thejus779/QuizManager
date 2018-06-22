package fr.epita.quiz.datamodel;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This class is dealing with the LOGIN Entity
 *
 * @author  THEJUS
 *
 */

@Entity
public class Login implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7328891416101783582L;

	/** The e-mail */
	@Id
	private String email;
	
	/** The password */
	private String password;
	
	/** The confirm password **/
	private String confirmPassword;
	
	/** The user Type data or  password **/
	private String userType;
	
	public Login() {
		//default constructor
	}

	public Login(String email2, String password2, String confirmPassword2, String userType2) {
		this.email=email2;
		this.password=password2;
		this.confirmPassword = confirmPassword2;
		this.userType=userType2;
	}
	

	/**
	 * Gets the e-mail.
	 * 
	 * @return String The e-mail
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the e-mail.
	 * 
	 * @param email The e-mail address
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 * 
	 * @return String The password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password The password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the string for the confirm password.
	 * 
	 * @return String The password
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * Sets the confirm password. 
	 * 
	 * @param confirmPassword The confirm password string
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}
