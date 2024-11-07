package club.helpers;

import club.dto.GuestDto;
import club.dto.InvoiceDetailDto;
import club.dto.InvoiceDto;
import club.dto.PartnerDto;
import club.dto.PersonDto;
import club.dto.UserDto;
import club.model.Guest;
import club.model.Invoice;
import club.model.Partner;
import club.model.Person;
import club.model.User;
import club.model.InvoiceDetail;

public class Helper {

	public static PersonDto parse(Person person) {
		PersonDto personDto = new PersonDto();
		personDto.setIdDto(person.getId());
		personDto.setNameDto(person.getName());
		personDto.setDocumentDto(person.getDocument());
		personDto.setCellPhoneDto(person.getCellPhone());
		return personDto;
	}

	public static Person parse(PersonDto personDto) {
		Person person = new Person();
		person.setId(personDto.getIdDto());
		person.setDocument(personDto.getDocumentDto());
		person.setCellPhone(personDto.getCellPhoneDto());
		person.setName(personDto.getNameDto());
		return person;
	}

	public static UserDto parse(User user) {
		UserDto userDto = new UserDto();
			userDto.setIdDto(user.getId());
		userDto.setPasswordDto(user.getPassword());
		if (user.getPersonnId() != null) {
			userDto.setPersonnIdDto(parse(user.getPersonnId()));
		}
		userDto.setRoleDto(user.getRole());
		userDto.setUserNameDto(user.getUserName());
		return userDto;
	}

	public static User parse(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getIdDto());
		user.setPassword(userDto.getPasswordDto());
		if (userDto.getPersonnIdDto() != null) {
			user.setPersonnId(parse(userDto.getPersonnIdDto()));
		}
		user.setRole(userDto.getRoleDto());
		user.setUserName(userDto.getUserNameDto());
		return user;
	}

	public static Partner parse(PartnerDto partnerDto) {
		Partner partner = new Partner();
		partner.setCreationDate(partnerDto.getCreationDateDto());
		partner.setAmount(partnerDto.getAmountDto());
		partner.setId(partnerDto.getIdDto());
		partner.setType(partnerDto.getTypeDto());
		partner.setUserId(parse(partnerDto.getUserIdDto()));
		return partner;
	}

	public static PartnerDto parse(Partner partner) {
		PartnerDto partnerDto = new PartnerDto();
		partnerDto.setCreationDateDto(partner.getCreationDate());
		partnerDto.setAmountDto(partner.getAmount());
		partnerDto.setIdDto(partner.getId());
		partnerDto.setTypeDto(partner.getType());
		partnerDto.setUserIdDto(parse(partner.getUserId()));
		return partnerDto;
	}

	public static Guest parse(GuestDto guestDto) {
		Guest guest = new Guest();
		guest.setUserId(parse(guestDto.getUsarIdDto()));
		guest.setPartnerId(parse(guestDto.getPartnerId()));
		guest.setStatus(guestDto.getStatusDto());
		guest.setId(guestDto.getId());
		return guest;
	}

	public static GuestDto parse(Guest guest) {
		GuestDto guestDto = new GuestDto();
		guestDto.setId(guest.getId());
		guestDto.setStatusDto(guest.getStatus());
		guestDto.setPartnerId(parse(guest.getPartnerId()));
		guestDto.setUsarIdDto(parse(guest.getUserId()));
		return guestDto;
	}

	public static Invoice parse(InvoiceDto invoicetDto) {
		Invoice invoice = new Invoice();
		invoice.setAmount(invoicetDto.getAmountDto());
		invoice.setBillId(invoicetDto.getBillIdDto());
		invoice.setCreationDate(invoicetDto.getCreationDateDto());
		invoice.setPartnerId(parse(invoicetDto.getPartnerIdDto()));
		invoice.setPersonId(invoicetDto.getPersonIdDto());
		invoice.setStatus(invoicetDto.getStatusDto());
		return invoice;
	}

	public static InvoiceDto parse(Invoice invoice) {
		InvoiceDto invoiceDto = new InvoiceDto();
		invoiceDto.setAmountDto(invoice.getAmount());
		invoiceDto.setBillIdDto(invoice.getBillId());
		invoiceDto.setCreationDateDto(invoice.getCreationDate());
		invoiceDto.setPersonIdDto(invoice.getPersonId());
		invoiceDto.setPartnerIdDto(parse(invoice.getPartnerId()));
		invoiceDto.setStatusDto(invoice.getStatus());
		return invoiceDto;
	}

	public static InvoiceDetail parse(InvoiceDetailDto invoiceDetailtDto) {
		InvoiceDetail invoiceDetail = new InvoiceDetail();
		invoiceDetail.setId(invoiceDetailtDto.getIdDto());
		invoiceDetail.setInvoiceId(parse(invoiceDetailtDto.getInvoiceIdDto()));
		invoiceDetail.setAmount(invoiceDetailtDto.getAmountDto());
		invoiceDetail.setItem(invoiceDetailtDto.getItemDto());
		invoiceDetail.setDescription(invoiceDetailtDto.getDescriptionDto());
		return invoiceDetail;
	}

	public static InvoiceDetailDto parse(InvoiceDetail invoiceDetail) {
		InvoiceDetailDto invoiceDetailDto = new InvoiceDetailDto();
		invoiceDetailDto.setIdDto(invoiceDetail.getId());
		invoiceDetailDto.setInvoiceIdDto(parse(invoiceDetail.getInvoiceId()));
		invoiceDetailDto.setAmountDto(invoiceDetail.getAmount());
		invoiceDetailDto.setItemDto(invoiceDetail.getItem());
		invoiceDetailDto.setDescriptionDto(invoiceDetail.getDescription());
		return invoiceDetailDto;
	}

}
