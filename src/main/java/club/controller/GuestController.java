package club.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import club.controller.request.CreationInvoiceRequest;
import club.controller.validator.InvoiceDetailValidator;
import club.dto.GuestDto;
import club.dto.InvoiceDetailDto;
import club.dto.InvoiceDto;
import club.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import club.service.interfaces.GuestService;

@Getter
@Setter
@NoArgsConstructor
@RestController
public class GuestController implements InterfaceController{

	@Autowired
	private InvoiceDetailValidator invoiceDetailValidator;
	@Autowired
	private GuestService service;

	@Override
	public void session() throws Exception {	
	}
	private UserDto user;
	private GuestDto guest;
	
	@PostMapping("/club/createInvoice")
	private ResponseEntity createInvoice(@RequestBody CreationInvoiceRequest request) throws Exception{
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

			this.service.createInvoice(invoiceDto, invoiceDetailDto);
			
			return new ResponseEntity<>("The new invoice was successfully created", HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
}
