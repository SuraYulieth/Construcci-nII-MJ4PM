package club.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import club.dao.interfaces.InvoiceDao;
import club.dao.repository.InvoiceRepository;
import club.dto.InvoiceDto;
import club.helpers.Helper;
import club.model.Invoice;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Service
public class InvoiceImplementation implements InvoiceDao{
    
    @Autowired
    public InvoiceRepository invoiceRepository;

    @Override
    public void createInvoice(InvoiceDto invoiceDto) throws Exception {
        Invoice invoice = Helper.parse(invoiceDto);
        invoiceRepository.save(invoice);
    }
    

}
