package club.dao.interfaces;

import club.dto.GuestDto;

public interface GuestDao {
	public void createGuest (GuestDto guestDto) throws Exception;
}
