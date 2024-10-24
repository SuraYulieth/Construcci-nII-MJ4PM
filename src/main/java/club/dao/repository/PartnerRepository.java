package club.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import club.model.Partner;
import club.model.User;

public interface PartnerRepository extends JpaRepository<Partner, Long>{

    public Partner findPartnerByUserId(User idDto) throws Exception;

}
