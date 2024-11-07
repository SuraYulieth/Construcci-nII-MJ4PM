package club.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import club.controller.request.CreationInvoiceRequest;
import club.controller.request.CreationUserRequest;
import club.controller.validator.PersonValidator;
import club.controller.validator.UserValidator;
import club.dto.GuestDto;
import club.dto.InvoiceDetailDto;
import club.dto.InvoiceDto;
import club.dto.PartnerDto;
import club.dto.PersonDto;
import club.dto.UserDto;
import club.service.interfaces.PartnerService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RestController
public class PartnerController implements InterfaceController{
	
	@Autowired
	private PersonValidator personValidator;
	@Autowired
	private UserValidator userValidator;
	private PartnerDto partnerDto;
	@Autowired
	private PartnerService service;
	private UserDto user;

	@Override
	public void session() throws Exception {
	}
	
	@PostMapping("/club/createGuest")
	private ResponseEntity createGuest (@RequestBody CreationUserRequest request) throws Exception {
		try{
			String name = request.getName();
			personValidator.validName(name);
			Long document = personValidator.validDocument(String.valueOf(request.getDocument()));
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
			userDto.setPersonnIdDto(personDto);
			userDto.setUserNameDto(userName);
			userDto.setPasswordDto(password);
			userDto.setRoleDto("guest");

			GuestDto guestDto = new GuestDto();
			guestDto.setStatusDto("inactive");
			guestDto.setPartnerId(partnerDto);
			guestDto.setUsarIdDto(userDto);
		
			this.service.createGuest(guestDto);
			return new ResponseEntity<>("The new guest was successfully created", HttpStatus.OK);
		}catch (Exception e){ 
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	//Solicitar consumo
	@PostMapping("/club/createInvoicePartner")
	private ResponseEntity createInvoicePartner(@RequestBody CreationInvoiceRequest request) throws Exception{
		try{
			double amount = request.getAmount();
			int item = request.getItem();
			String description = request.getDescription();

			InvoiceDto invoiceDto = new InvoiceDto();
			invoiceDto.setPartnerIdDto(user);
			invoiceDto.setCreationDateDto(new Date(System.currentTimeMillis()));
			invoiceDto.setStatusDto(true);
			invoiceDto.setAmountDto(amount);

			InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
			invoiceDetailDto.setInvoiceIdDto(invoiceDto);
			invoiceDetailDto.setItemDto(item);
			invoiceDetailDto.setDescriptionDto(description);
			invoiceDetailDto.setAmountDto(amount);

			this.service.createInvoicePartner(invoiceDto, invoiceDetailDto);
			
			return new ResponseEntity<>("The new invoice was successfully created", HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}


	//Activar invitado
	

}
	