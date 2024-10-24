package club.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;

import club.controller.validator.UserValidator;
import club.dto.UserDto;
import club.service.interfaces.LoginService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Controller
public class LoginController implements InterfaceController{
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private LoginService service;
	private static final String MENU= ("MENU \n 1. Login \n 2. Stop execution");
	private Map<String,InterfaceController> roles;

	@Autowired
	public LoginController(AdminController adminController, GuestController guestController, PartnerController partnerController) {
		this.roles = new HashMap<String,InterfaceController>();
		roles.put("admin", adminController);
		roles.put("guest", guestController);
		roles.put("partner", partnerController);	
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
			System.out.print(MENU);
			String option = Utils.getReader().nextLine();
			return options(option);
		} catch (
		Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}
	
	private boolean options(String option) throws Exception {
		switch (option) {
		case "1": {
			this.login();
			return true;
		}
		case "2": {
			System.out.println("Program stops");
			return false;
		}
		default: {
			System.out.println("Please enter a valid option");
			return true;
		}
		}
	}
	
	private void login()throws Exception {
		System.out.println("ingrese el usuario");
		String userName= Utils.getReader().nextLine();
		userValidator.validUserName(userName);
		System.out.println("ingrese la contraseña");
		String password= Utils.getReader().nextLine();
		userValidator.validPassword(password);
		UserDto userDto = new UserDto();
		userDto.setPasswordDto(password);
		userDto.setUserNameDto(userName);
		this.service.login(userDto);
		
		if(roles.get(userDto.getRoleDto())==null) {
			throw new Exception ("Invalid role");
		}
		roles.get(userDto.getRoleDto()).session();
	}	
	
	
}
