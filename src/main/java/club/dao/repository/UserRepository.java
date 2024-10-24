package club.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import club.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

    public User findByUserName(String userName)throws Exception;
    public boolean existsByUserName(String userNameDto)throws Exception;

}
