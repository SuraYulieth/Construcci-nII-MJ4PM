package club.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import club.config.MYSQLConnection;
import club.dao.interfaces.PersonDao;
import club.dto.PersonDto;
import club.helpers.Helper;
import club.model.Person;

public class PersonDaoImplementation implements PersonDao{

	@Override
	public boolean existsByDocument(PersonDto personDto) throws Exception {
		String query = "SELECT 1 FROM PERSON WHERE DOCUMENT = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, personDto.getIdentificationCardDto());
		ResultSet resulSet = preparedStatement.executeQuery();
		boolean exists = resulSet.next();
		resulSet.close();
		preparedStatement.close();
		return exists;
	}

	@Override
	public void createPerson(PersonDto personDto) throws Exception {
		Person person = Helper.parse(personDto);
		String query = "INSERT INTO PERSON(NAME,DOCUMENT,CELLPHONE) VALUES (?,?,?) ";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setString(1, person.getName());
		preparedStatement.setLong(2,person.getIdentificationCard());
		preparedStatement.setString(3, person.getCellPhoneNumber());
		preparedStatement.execute();
		preparedStatement.close();
	}

	@Override
	public void deletePerson(PersonDto personDto) throws Exception {
		Person person = Helper.parse(personDto);
		String query = "DELETE FROM PERSON WHERE ID = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1,person.getId());
		preparedStatement.execute();
		preparedStatement.close();
	}

	@Override
	public PersonDto findByDocument(PersonDto personDto) throws Exception {
		String query = "SELECT ID,DOCUMENT,NAME,CELLPHONE FROM PERSON WHERE DOCUMENT = ?";
		PreparedStatement preparedStatement = MYSQLConnection.getConnection().prepareStatement(query);
		preparedStatement.setLong(1, personDto.getIdentificationCardDto());
		ResultSet resulSet = preparedStatement.executeQuery();
		if (resulSet.next()) {
			Person person = new Person();
			person.setId(resulSet.getLong("ID"));
			person.setName(resulSet.getString("NAME"));
			person.setIdentificationCard(resulSet.getLong("DOCUMENT"));
			person.setCellPhoneNumber(resulSet.getString("CELLPHONE"));
			resulSet.close();
			preparedStatement.close();
			return Helper.parse(person);
		}
		resulSet.close();
		preparedStatement.close();
		return null;
	}
	
	
	
}
