package club.dao.interfaces;

import club.dto.InvoiceDto;

public interface InvoiceDao {
    public void createInvoice (InvoiceDto invoiceDto) throws Exception;
}
