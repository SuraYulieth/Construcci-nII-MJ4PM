package club.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import club.dao.interfaces.InvoiceDetailDao;
import club.dao.repository.InvoiceDetailsRepository;
import club.dto.InvoiceDetailDto;
import club.helpers.Helper;
import club.model.InvoiceDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Service
public class InvoiceDetailDaoImplementation implements InvoiceDetailDao{

    @Autowired
    private InvoiceDetailsRepository invoiceDetailRepository;

     @Override
    public void createInvoiceDetail (InvoiceDetailDto invoiceDetailDto) throws Exception {
        
        InvoiceDetail invoiceDetail = Helper.parse(invoiceDetailDto);
        invoiceDetailRepository.save(invoiceDetail);
    }

}
