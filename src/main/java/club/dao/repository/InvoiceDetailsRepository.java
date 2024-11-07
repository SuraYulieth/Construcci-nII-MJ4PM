package club.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import club.model.InvoiceDetail;

public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetail, Long>{

}
