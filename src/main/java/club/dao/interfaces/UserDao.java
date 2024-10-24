package club.dao.interfaces;

import club.dto.UserDto;

public interface UserDao {
	public boolean existsByUserName (UserDto UserDto) throws Exception;
	public void createUser(UserDto UserDto) throws Exception;
	public UserDto findByUserName(UserDto userDto) throws Exception;
}
