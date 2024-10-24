package club.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import club.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long>{
    
}
