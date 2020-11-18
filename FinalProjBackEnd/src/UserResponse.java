public class UserResponse {
	private String firstName; 
	private String lastName;
	private String email;
	private String phone; // NULL
	
	public UserResponse(CreateUser cu) {
		this.firstName = cu.getFirstName();
		this.lastName = cu.getLastName();
		this.email = cu.getEmail();
		this.phone = cu.getPhone();
	}
	
}
