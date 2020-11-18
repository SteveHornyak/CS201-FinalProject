
public class SignInUser {
	
	private String passwordHash;
	private String email;
	
	SignInUser(String email, String passwordHash){
		this.passwordHash = passwordHash;
		this.email = email;
	}
		
}
