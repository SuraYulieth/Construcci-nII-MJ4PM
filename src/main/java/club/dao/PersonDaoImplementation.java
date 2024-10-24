package club.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import club.dao.interfaces.PersonDao;
import club.dao.repository.PersonRepository;
import club.dto.PersonDto;
import club.helpers.Helper;
import club.model.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Service
public class PersonDaoImplementation implements PersonDao{
	@Autowired
	public PersonRepository personRepository;

	@Override
	public boolean existsByDocument(PersonDto personDto) throws Exception {
		return personRepository.existsByDocument(personDto.getDocumentDto());
	}

	@Override
	public void createPerson(PersonDto personDto) throws Exception {
		Person person = Helper.parse(personDto);
		personRepository.save(person);
	}

	@Override
	public void deletePerson(PersonDto personDto) throws Exception {
		Person person = Helper.parse(personDto);
		personRepository.delete(person);
	}

	@Override
	public PersonDto findByDocument(PersonDto personDto) throws Exception {
		Person person = personRepository.findByDocument(personDto.getDocumentDto());
		return Helper.parse(person);
	}
	
	
	
}
