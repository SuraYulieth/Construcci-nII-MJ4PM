package club.dto;


public class InvoiceDetailDto {

	private long idDto; 
	private InvoiceDto invoiceIdDto;
	private int itemDto;
	private String descriptionDto;
	private double amountDto;
	
	public InvoiceDetailDto(){}

	public long getIdDto() {
		return idDto;
	}

	public void setIdDto(long idDto) {
		this.idDto = idDto;
	}

	public InvoiceDto getInvoiceIdDto() {
		return invoiceIdDto;
	}

	public void setInvoiceIdDto(InvoiceDto invoiceIdDto) {
		this.invoiceIdDto = invoiceIdDto;
	}

	public int getItemDto() {
		return itemDto;
	}

	public void setItemDto(int itemDto) {
		this.itemDto = itemDto;
	}

	public String getDescriptionDto() {
		return descriptionDto;
	}

	public void setDescriptionDto(String descriptionDto) {
		this.descriptionDto = descriptionDto;
	}

	public double getAmountDto() {
		return amountDto;
	}

	public void setAmountDto(double amountDto) {
		this.amountDto = amountDto;
	}

	
	
}
