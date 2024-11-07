package club.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import club.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
    
}
