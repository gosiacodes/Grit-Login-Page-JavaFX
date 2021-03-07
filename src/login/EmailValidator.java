package login;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

//Email validator with javax.mail.jar
public class EmailValidator{	

	 public static boolean emailValidator(String email) {
	    boolean isValid = false;
	    try {
	        // Creating InternetAddress object and validating given email address
	        InternetAddress internetAddress = new InternetAddress(email);
	        internetAddress.validate();
	        isValid = true;
	    } catch (AddressException e) {
	        System.out.println("Email is not valid: " + email);
	    }
	    return isValid;
	}
}
