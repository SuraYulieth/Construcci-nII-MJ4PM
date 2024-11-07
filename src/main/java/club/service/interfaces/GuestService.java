package club.service.interfaces;

import club.dto.InvoiceDetailDto;
import club.dto.InvoiceDto;

public interface GuestService {
    public void createInvoice(InvoiceDto invoice, InvoiceDetailDto invoiceDetail) throws Exception;
}
