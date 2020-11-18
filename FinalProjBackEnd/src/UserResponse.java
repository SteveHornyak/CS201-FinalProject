public class UserResponse {
	private String firstName; 
	private String lastName;
	private String email;
	private String phone; // NULL
	
	public UserResponse(String firstName, String lastName, String email, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	
}
