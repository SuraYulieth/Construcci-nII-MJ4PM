package club.controller;

import club.controller.validator.PersonValidator;
import club.controller.validator.UserValidator;
import club.dto.GuestDto;
import club.dto.PersonDto;
import club.dto.UserDto;
import club.dto.PartnerDto;
import club.service.Service;
import club.service.interfaces.PartnerService;


public class PartnerController implements InterfaceController{
	
	private PersonValidator personValidator;
	private UserValidator userValidator;
	private PartnerService service;
	private PartnerDto partnerDto;
	private static final String MENU = "MENU \n 1. Request to VIP \n 2. Invoice history \n 3. Register Consumption \n 4. increase funds \n 5. Create a guest \n";
	
	public PartnerController() {
		this.service = new Service();
		this.personValidator = new PersonValidator();
		this.userValidator = new UserValidator();
		this.partnerDto = new PartnerDto();
	}


	@Override
	public void session() throws Exception {
		 boolean session = true;
	        while (session) {
	            session = menu();
	        }
	}
	
	private boolean menu() {
        try {
            System.out.println(MENU);
            String option = Utils.getReader().nextLine();
            return options(option);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            for(StackTraceElement st : e.getStackTrace()) {
            	System.out.println(st.toString());
            }
            return true;
        }
    }
	
	private boolean options(String option)throws Exception {
		switch(option) {
		case "1":{
		}
		case "2":{
		}
		case "3":{
		}
		case "4":{
			//increase funds 
		}
		case "5":{
			this.createGuest();
			return true;
		}
		}
		return true;
	}
	
	private void createGuest() throws Exception {
		System.out.println("Enter name's guest");
		String name = Utils.getReader().nextLine();
		personValidator.validName(name);
		System.out.println("Enter document's guest");
		Long document = personValidator.validDocument(Utils.getReader().nextLine());
		System.out.println("Enter cellphone number of guest");
		String cellPhoneNumber = Utils.getReader().nextLine();
		personValidator.cellphone(cellPhoneNumber);
		System.out.println("Enter an user name");
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
		userDto.setPersonIdDto(personDto);
		userDto.setUserNameDto(userName);
		userDto.setPasswordDto(password);
		userDto.setRolDto("guest");
		
		GuestDto guestDto = new GuestDto();
		guestDto.setInvitationStatusDto("inactive");
		guestDto.setPartnerId(partnerDto);
		guestDto.setUsarIdDto(userDto);
	
		this.service.createGuest(guestDto);
		System.out.print("The guest was succesfully created");;
	}
	

}
	