package club.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import club.model.Guest;
import club.model.User;

public interface GuestRepository extends JpaRepository<Guest, Long>{

    public Guest findGuestByUserId(User userDto) throws Exception;

}
