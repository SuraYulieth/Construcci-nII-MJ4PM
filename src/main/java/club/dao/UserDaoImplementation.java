package club.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import club.config.MYSQLConnection;
import club.dao.interfaces.UserDao;
import club.dto.PersonDto;
import club.dto.UserDto;
import club.model.User;
import club.model.Person;
import club.helpers.Helper;

public class UserDaoImplementation implements UserDao{

	@Override
	public UserDto findByUserName(UserDto userDto) throws Exception {
		String query = "SELECT ID,USERNAME,PASSWORD,ROLE,PERSONNID FROM USER WHERE USERNAME = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setString(1, userDto.getUserNameDto());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			User user = new User();
			user.setId(resulSet.getLong("ID"));
			user.setUserName(resulSet.getString("USERNAME"));
			user.setPassword(resulSet.getString("PASSWORD"));
			user.setRol(resulSet.getString("ROLE"));
			Person person = new Person();
			person.setIdentificationCard(resulSet.getLong("PERSONNID"));
			user.setPersonId(person);
			resulSet.close();
			preparedStatement.close();
			return Helper.parse(user);
		}
		resulSet.close();
		preparedStatement.close();
		return null;

	}

	@Override
	public boolean existsByUserName(UserDto userDto) throws Exception {
		String query = "SELECT 1 FROM USER WHERE USERNAME = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setString(1, userDto.getUserNameDto());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean exists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return exists;
	}

	@Override
	public void createUser(UserDto userDto) throws Exception {
		User user = Helper.parse(userDto);
		String query = "INSERT INTO USER (USERNAME,PASSWORD,PERSONNID,ROLE) VALUES (?,?,?,?)";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setString(1, user.getUserName());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setLong(3, user.getPersonId().getId());
		preparedStatement.setString(4, user.getRol());
		preparedStatement.execute();
		preparedStatement.close();
	}
	
	
	public UserDto findById(UserDto userDto) throws Exception {
		String query = "SELECT ID,PERSONNID,USERNAME,PASSWORD,ROLE FROM USER WHERE ID = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, userDto.getIdDto());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			User user = new User();
			user.setId(resulSet.getLong("ID"));
			user.setUserName(resulSet.getString("USERNAME"));
			Person person = new Person();
			person.setIdentificationCard(resulSet.getLong("PERSONNID"));
			user.setPersonId(person);
			user.setRol(resulSet.getString("ROLE"));
			user.setPassword(resulSet.getString("PASSWORD"));
			resulSet.close();
			preparedStatement.close();
			return Helper.parse(user);
		}
		resulSet.close();
		preparedStatement.close();
		return null;
	}
	
	
	

}
