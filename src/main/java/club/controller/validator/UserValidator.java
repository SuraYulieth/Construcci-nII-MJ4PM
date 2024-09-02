package club.controller.validator;

public class UserValidator extends CommonsValidator {
	
	public UserValidator() {
		super();
	}
	
	public void validUserName (String userName) throws Exception {
		super.isValidString("The user name ", userName);
	}
	
	public void validPassword (String password ) throws Exception {
		super.isValidString("The user password", password);;
	}
	
	public void validRole (String role) throws Exception {
		super.isValidString("The user role ", role);
	}
	
	
}
