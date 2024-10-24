package club.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import club.dao.interfaces.UserDao;
import club.dao.repository.UserRepository;
import club.dto.UserDto;
import club.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import club.helpers.Helper;

@Getter
@Setter
@NoArgsConstructor
@Service
public class UserDaoImplementation implements UserDao{
	@Autowired
	public UserRepository userRepository;

	@Override
	public UserDto findByUserName(UserDto userDto) throws Exception {
		User user = userRepository.findByUserName(userDto.getUserNameDto());
		return Helper.parse(user);

	}

	@Override
	public boolean existsByUserName(UserDto userDto) throws Exception {
		return userRepository.existsByUserName(userDto.getUserNameDto());
	}

	@Override
	public void createUser(UserDto userDto) throws Exception {
		User user = Helper.parse(userDto);
		userRepository.save(user);
	}
	

}
