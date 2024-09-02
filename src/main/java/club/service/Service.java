package club.service;

import java.sql.SQLException;

import club.controller.Utils;
import club.dao.GuestDaoImplementation;
import club.dao.PartnerDaoImplementation;
import club.dao.PersonDaoImplementation;
import club.dao.UserDaoImplementation;
import club.dao.interfaces.GuestDao;
import club.dao.interfaces.PartnerDao;
import club.dao.interfaces.PersonDao;
import club.dao.interfaces.UserDao;
import club.dto.GuestDto;
import club.dto.PartnerDto;
import club.dto.PersonDto;
import club.dto.UserDto;
import club.service.interfaces.AdminService;
import club.service.interfaces.LoginService;
import club.service.interfaces.PartnerService;

public class Service implements AdminService, LoginService, PartnerService {
	
	private UserDao userDao;
	private PersonDao personDao;
	private PartnerDao partnerDao;
	private GuestDao guestDao;
	private PartnerDto partnerDto;
	
	public static UserDto user;

	public Service() {
		this.userDao = new UserDaoImplementation();
		this.personDao = new PersonDaoImplementation();
		this.partnerDao = new PartnerDaoImplementation();
		this.guestDao = new GuestDaoImplementation();
	}

	@Override
	public void login(UserDto userDto) throws Exception {
		UserDto validateDto = userDao.findByUserName(userDto);
		if (validateDto == null) {
			throw new Exception ("The user does not exist");
		}
		if (!userDto.getPasswordDto().equals(validateDto.getPasswordDto())) {
			throw new Exception("User name or password incorrect");
		}
		userDto.setRolDto(validateDto.getRolDto());
		user = validateDto;
	}

	@Override
	public void logout() {
		user = null;
		System.out.print("Sesion closed");
	}

	@Override
	public void createGuest(GuestDto guestDto) throws Exception {
		this.createUser(guestDto.getUsarIdDto());
		guestDto.setIdDto(guestDto.getIdDto());
		guestDto.setUsarIdDto(userDao.findByUserName(guestDto.getUsarIdDto()));
		this.guestDao.createGuest(guestDto);
	}
	
	@Override
	public void createPartner(PartnerDto partnerDto) throws Exception {
		this.createUser(partnerDto.getUserIdDto());	
		partnerDto.setUserIdDto(userDao.findByUserName(partnerDto.getUserIdDto()));
		this.partnerDao.createPartner(partnerDto);	
	}
	
	private void createUser(UserDto userDto) throws Exception{
		this.createPerson(userDto.getPersonIdDto());
		PersonDto personDto = personDao.findByDocument(userDto.getPersonIdDto());
		userDto.setPersonIdDto(personDto);
		if(this.userDao.existsByUserName(userDto)) {
			this.personDao.deletePerson(userDto.getPersonIdDto());
			throw new Exception("This user exists");
		}
		try {
			this.userDao.createUser(userDto);
		} catch(SQLException e) {
			this.personDao.deletePerson(userDto.getPersonIdDto());
		}
	}
	
	private void createPerson(PersonDto personDto) throws Exception {
		if (this.personDao.existsByDocument(personDto)) {
			throw new Exception("The user with this id exists");
		}
		this.personDao.createPerson(personDto);
	}

}
