package club.controller.validator;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class UserValidator extends CommonsValidator {
	
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
