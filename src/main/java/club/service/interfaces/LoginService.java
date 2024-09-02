package club.service.interfaces;

import club.dto.UserDto;

public interface LoginService {
	public void login(UserDto  UserDto) throws Exception;
	public void logout();
}
