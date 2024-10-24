package club.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.dao.interfaces.GuestDao;
import club.dao.repository.GuestRepository;
import club.dto.GuestDto;
import club.helpers.Helper;
import club.model.Guest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Service
public class GuestDaoImplementation implements GuestDao{
	@Autowired
	public GuestRepository guestRepository;

	@Override
	public void createGuest(GuestDto guestDto) throws Exception {
		Guest guest = Helper.parse(guestDto);
		guestRepository.save(guest);
	}

}
