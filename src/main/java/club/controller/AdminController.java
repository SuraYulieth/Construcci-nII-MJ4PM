package club.controller;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import club.controller.request.CreationUserRequest;
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
@RestController
public class AdminController implements InterfaceController{
	@Autowired
	private PersonValidator  personValidator;
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private AdminService service;
	//private static final String MENU = "MENU \n 1. Create a partner \n 2. Run promotion to VIP \n 3. Logout \n";
	
	@Override
	public void session() throws Exception{
	}

	@PostMapping("/club/createPartner")
	private ResponseEntity createPartner(@RequestBody CreationUserRequest request) throws Exception {
		try {
			String name = request.getName();
			personValidator.validName(name);
			Long document =  request.getDocument();
			personValidator.validDocument(String.valueOf(document));
			String cellPhoneNumber = request.getCellPhoneNumber();
			personValidator.cellphone(cellPhoneNumber);
			String userName = request.getUserName();
			userValidator.validUserName(userName);
			String password = request.getPassword();
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
			return new ResponseEntity<>("The new partner was successfully created", HttpStatus.OK);
		} catch (Exception e){ 
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
