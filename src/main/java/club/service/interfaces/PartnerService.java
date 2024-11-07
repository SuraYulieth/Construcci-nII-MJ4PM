package club.service.interfaces;

import club.dto.GuestDto;
import club.dto.InvoiceDetailDto;
import club.dto.InvoiceDto;

public interface PartnerService {
	public void createGuest(GuestDto GuestDto) throws Exception;
	public void createInvoicePartner(InvoiceDto invoiceDto, InvoiceDetailDto invoiceDetailDto) throws Exception;
}

