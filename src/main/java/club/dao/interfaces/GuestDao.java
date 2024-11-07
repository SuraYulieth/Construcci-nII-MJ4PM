package club.dao.interfaces;

import club.dto.GuestDto;
import club.dto.UserDto;

public interface GuestDao {
	public void createGuest (GuestDto guestDto) throws Exception;
	public GuestDto findGuestByUserId(UserDto userDto) throws Exception;
}
