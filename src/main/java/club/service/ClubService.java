package club.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Service
public class ClubService implements AdminService, LoginService, PartnerService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private PersonDao personDao;
	@Autowired
	private PartnerDao partnerDao;
	@Autowired
	private GuestDao guestDao;	

	public static UserDto user;

	@Override
	public void login(UserDto userDto) throws Exception {
		UserDto validateDto = userDao.findByUserName(userDto);
		if (validateDto == null) {
			throw new Exception ("The user does not exist");
		}
		if (!userDto.getPasswordDto().equals(validateDto.getPasswordDto())) {
			throw new Exception("User name or password incorrect");
		}
		userDto.setRoleDto(validateDto.getRoleDto());
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
		guestDto.setUsarIdDto(userDao.findByUserName(guestDto.getUsarIdDto()));
		PartnerDto partnerDto = partnerDao.findPartnerByUserId(user);
		guestDto.setPartnerId(partnerDto);
		this.guestDao.createGuest(guestDto);
	}
	
	@Override
	public void createPartner(PartnerDto partnerDto) throws Exception {
		this.createUser(partnerDto.getUserIdDto());	
		partnerDto.setUserIdDto(userDao.findByUserName(partnerDto.getUserIdDto()));
		this.partnerDao.createPartner(partnerDto);	
	}
	
	private void createUser(UserDto userDto) throws Exception{
		this.createPerson(userDto.getPersonnIdDto());
		PersonDto personDto = personDao.findByDocument(userDto.getPersonnIdDto());
		userDto.setPersonnIdDto(personDto);
		if(this.userDao.existsByUserName(userDto)) {
			this.personDao.deletePerson(userDto.getPersonnIdDto());
			throw new Exception("This user exists");
		}
		try {
			this.userDao.createUser(userDto);
		} catch(SQLException e) {
			this.personDao.deletePerson(userDto.getPersonnIdDto());
		}
	}
	
	private void createPerson(PersonDto personDto) throws Exception {
		if (this.personDao.existsByDocument(personDto)) {
			throw new Exception("The user with this id exists");
		}
		this.personDao.createPerson(personDto);
	}

}
