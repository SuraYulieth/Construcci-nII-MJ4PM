package club.controller;

import java.sql.Date;
import club.controller.validator.PersonValidator;
import club.controller.validator.UserValidator;
import club.dto.PartnerDto;
import club.dto.PersonDto;
import club.dto.UserDto;
import club.service.Service;
import club.service.interfaces.AdminService;

public class AdminController implements InterfaceController{
	private PersonValidator  personValidator;
	private UserValidator userValidator;
	private AdminService service;
	
	private static final String MENU = "MENU \n 1. Create a partner \n 2. Run promotion to VIP \n 3. Logout \n";
	
	public AdminController() {
		this.personValidator = new PersonValidator();
		this.userValidator = new UserValidator();
		this.service = new Service();
	}
	
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
		personDto.setCellPhoneNumberDto(cellPhoneNumber);
		personDto.setIdentificationCardDto(document);
	
		UserDto userDto = new UserDto();
		userDto.setUserNameDto(userName);
		userDto.setPasswordDto(password);
		userDto.setRolDto("partner");
		userDto.setPersonIdDto(personDto);
		
		PartnerDto partnerDto = new PartnerDto();
		partnerDto.setUserIdDto(userDto);
		partnerDto.setAfiliationDateDto(new Date(System.currentTimeMillis()));
		partnerDto.setAvaibleFundsDto(50000);
		partnerDto.setSuscriptionTypeDto("regular");
		
		this.service.createPartner(partnerDto);
		System.out.println("The new partner was successfully created");
	}
	

}
