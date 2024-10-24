package club.controller;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import club.controller.validator.PersonValidator;
import club.controller.validator.UserValidator;
import club.dto.PartnerDto;
import club.dto.PersonDto;
import club.dto.UserDto;
import club.service.interfaces.AdminService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Controller
public class AdminController implements InterfaceController{
	@Autowired
	private PersonValidator  personValidator;
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private AdminService service;
	
	private static final String MENU = "MENU \n 1. Create a partner \n 2. Run promotion to VIP \n 3. Logout \n";
	
	@Override
	public void session() throws Exception{
		boolean session = true;
		while (session) {
			session = menu();
		}	
	}
	
	private boolean menu() {
		try {
			//System.out.print("Welcome " + Service.user.getUserNameDto());
			System.out.print(MENU);
			String option = Utils.getReader().nextLine();
			return options(option);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}
	
	private boolean options(String option) throws Exception{
		switch(option) {
		
		case "1": {
			this.createPartner();
			return true;
		}
		
		case "2":{
			//Función beVIP()
		}
		
		case "3":{
			System.out.println("Session has been logged out");
			return false;
		}
		
		default: {
			System.out.println("ingrese una opcion valida");
			return true;
		}
		}
	}

	public void createPartner() throws Exception {
		System.out.println("Enter name's partner");
		String name = Utils.getReader().nextLine();
		personValidator.validName(name);
		System.out.println("Enter document's partner");
		Long document = personValidator.validDocument(Utils.getReader().nextLine());
		System.out.println("Enter cellphone number of partner");
		String cellPhoneNumber = Utils.getReader().nextLine();
		personValidator.cellphone(cellPhoneNumber);
		System.out.println("Enter user name");
		String userName = Utils.getReader().nextLine();
		userValidator.validUserName(userName);
		System.out.println("Enter password");
		String password = Utils.getReader().nextLine();
		userValidator.validPassword(password);

		PersonDto personDto = new PersonDto();
		personDto.setNameDto(name);
		personDto.setCellPhoneDto(cellPhoneNumber);
		personDto.setDocumentDto(document);
	
		UserDto userDto = new UserDto();
		userDto.setUserNameDto(userName);
		userDto.setPasswordDto(password);
		userDto.setRoleDto("partner");
		userDto.setPersonnIdDto(personDto);
		
		PartnerDto partnerDto = new PartnerDto();
		partnerDto.setUserIdDto(userDto);
		partnerDto.setCreationDateDto(new Date(System.currentTimeMillis()));
		partnerDto.setAmountDto(50000);
		partnerDto.setTypeDto("regular");
		
		this.service.createPartner(partnerDto);
		System.out.println("The new partner was successfully created");
	}

	


	

}
