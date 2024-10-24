package club.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import club.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    public boolean existsByDocument(long document)throws Exception;
    public Person findByDocument(long documentDto)throws Exception;

}
