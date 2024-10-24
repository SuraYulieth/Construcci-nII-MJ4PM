package club.controller.validator;

import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class PersonValidator extends CommonsValidator{
	
	public void validName(String name) throws Exception{
		super.isValidString("The name's person ", name);
	}
	
	public long validDocument(String document) throws Exception{
		return super.isValidLong("The identification's person", document);
	}
	
	public void cellphone(String cellphone) throws Exception{
		super.isValidString("The cellphone number's person ", cellphone);
	}
	
	public void userName(String userName) throws Exception{
		super.isValidString("The Username's person ", userName);
	}
	
	public void password(String password) throws Exception{
		super.isValidString("The password's person ", password);
	}
	
	
}
