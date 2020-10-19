package login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

	public static boolean validateEmail(String username) {
		if (username != null) {         
			// requires a valid email with no digits, "-", "_", and "." at the beginning, with a-z, digits and special characters in login, 
			//with @, with a-z, digits, "-", "_" and "." in domain, and without "-", "_", and "." at the end of domain
            String EMAIL_PATTERN = "[^0-9-_.][a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(\\.{1}[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@([a-zA-Z0-9_-]+([a-zA-Z]*)\\.{1})+([a-zA-Z]*)[^-_.]";
			Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(username);
            
            //*************************************************************
            //alternative email validator with javax.mail.jar
			boolean javax = EmailValidator.emailValidator(username);
			if (javax) System.out.println("Email is valid: " + username); 
			//*************************************************************
			
            if (matcher.matches()) return true;              
        }								
		return false;
	}

	public static boolean validatePassword(String password) {
		if (password != null) {
		    // requires a valid password with at least 2 numbers, 2 lower case letters, 2 upper case letters, 1 special character,
			// no blank spaces, and at least 8 characters
		    String PASSWORD_PATTERN = "(?=.*[0-9]{2,})(?=.*[a-z]{2,})(?=.*[A-Z]{2,})(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		    Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
	        Matcher matcher = pattern.matcher(password); 
		    if(matcher.matches())return true;
		}
		return false;
	}
	
}