package club.helpers;

import club.dto.GuestDto;
import club.dto.PartnerDto;
import club.dto.PersonDto;
import club.dto.UserDto;
import club.model.Guest;
import club.model.Partner;
import club.model.Person;
import club.model.User;

public class Helper {

	public static PersonDto parse(Person person) {
		PersonDto personDto = new PersonDto();
		personDto.setIdDto(person.getId());
		personDto.setNameDto(person.getName());
		personDto.setIdentificationCardDto(person.getIdentificationCard());
		personDto.setCellPhoneNumberDto(person.getCellPhoneNumber());
		return personDto;
	}
	
	public static Person parse(PersonDto personDto) {
		Person person = new Person();
		person.setId(personDto.getIdDto());
		person.setIdentificationCard(personDto.getIdentificationCardDto());
		person.setCellPhoneNumber(personDto.getCellPhoneNumberDto());
		person.setName(personDto.getNameDto());
		return person;
	}
	
	public static UserDto parse(User user) {
		UserDto userDto = new UserDto();
		userDto.setIdDto(user.getId());
		userDto.setPasswordDto(user.getPassword());
		userDto.setPersonIdDto(parse(user.getPersonId()));
		userDto.setRolDto(user.getRol());
		userDto.setUserNameDto(user.getUserName());
		return userDto;
	}
	
	public static User parse(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getIdDto());
		user.setPassword(userDto.getPasswordDto());
		user.setPersonId(parse(userDto.getPersonIdDto()));
		user.setRol(userDto.getRolDto());
		user.setUserName(userDto.getUserNameDto());
		return user;
	}
	
	public static Partner parse(PartnerDto partnerDto) {
		Partner partner = new Partner();
		partner.setAfiliationDate(partnerDto.getAfiliationDateDto());
		partner.setAvaibleFunds(partnerDto.getAvaibleFundsDto());
		partner.setId(partnerDto.getIdDto());
		partner.setSuscriptionType(partnerDto.getSuscriptionTypeDto());
		partner.setUserId(parse(partnerDto.getUserIdDto()));
		return partner;
	}
	
	public static PartnerDto parse(Partner partner) {
		PartnerDto partnerDto = new PartnerDto();
		partnerDto.setAfiliationDateDto(partner.getAfiliationDate());
		partnerDto.setAvaibleFundsDto(partner.getAvaibleFunds());
		partnerDto.setIdDto(partner.getId());
		partnerDto.setSuscriptionTypeDto(partner.getSuscriptionType());
		partnerDto.setUserIdDto(parse(partner.getUserId()));
		return partnerDto;
	}
	
	public static Guest parse(GuestDto guestDto) {
		Guest guest = new Guest();
		guest.setId(parse(guestDto.getIdDto()));
		guest.setInvitationStatus(guestDto.getInvitationStatusDto());;
		guest.setRegistrationGuest(guestDto.getRegistrationGuestDto());;
		guest.setUsarId(parse(guestDto.getUsarIdDto()));
		return guest;
	}
	
	public static GuestDto parse(Guest guest) {
		GuestDto guestDto = new GuestDto();
		guestDto.setIdDto(parse(guest.getId()));
		guestDto.setInvitationStatusDto(guest.getInvitationStatus());
		guestDto.setRegistrationGuestDto(guest.getRegistrationGuest());
		guestDto.setUsarIdDto(parse(guest.getUsarId()));
		return guestDto;
	}
	
}
