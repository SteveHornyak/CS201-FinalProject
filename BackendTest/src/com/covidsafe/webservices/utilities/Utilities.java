package com.covidsafe.webservices.utilities;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.covidsafe.webservices.objects.CreateUser;



public class Utilities
{
	 //Verifying correct or acceptable user input
		public static String verifyUserInfo(CreateUser user) {
			if(user.getFirstName()==null) {
				return "Failed. First name can't be empty.";
			}
			else if(user.getLastName()==null) {
				return "Failed. Last name can't be empty.";
			}
			else if(user.getEmail()==null) {
				return "Failed. E-mail can't be empty.";
			}
			// phone number maybe country codes? -> up to three digits. Number formatted?
			else if(user.getPhone()!=null && user.getPhone().length()>=20) {
				return "Failed. Invalid phone number format.";
			}
			else if(!user.getEmail().matches("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")) {
				return "Failed. Invalid email format.";
			}
			else if(user.getFirstName().contains("\s") || user.getLastName().contains("\s")) {
				return "Failed. Name can't contain spaces.";
			}
			return "Success";
		}
		
		public static String hashPassword(String password) {
			MessageDigest digest = null;
			try {
				digest = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			byte[] hash = digest.digest(
			  password.getBytes(StandardCharsets.UTF_8));
			  StringBuilder hexString = new StringBuilder(2 * hash.length);
			    for (int i = 0; i < hash.length; i++) {
			        String hex = Integer.toHexString(0xff & hash[i]);
			        if(hex.length() == 1) {
			            hexString.append('0');
			        }
			        hexString.append(hex);
			    }
			    return hexString.toString();
			}

}
