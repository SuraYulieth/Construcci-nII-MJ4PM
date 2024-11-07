package club.dto;

import java.sql.Date;

public class InvoiceDto {

	private long billIdDto;
	private long personIdDto;
	private UserDto partnerIdDto;
	private Date creationDateDto;
	private double amountDto;
	private boolean statusDto;
	
	public InvoiceDto() {}

	public long getBillIdDto() {
		return billIdDto;
	}

	public void setBillIdDto(long billIdDto) {
		this.billIdDto = billIdDto;
	}

	public long getPersonIdDto() {
		return personIdDto;
	}

	public void setPersonIdDto(long personIdDto) {
		this.personIdDto = personIdDto;
	}

	public UserDto getPartnerIdDto() {
		return partnerIdDto;
	}

	public void setPartnerIdDto(UserDto partnerIdDto) {
		this.partnerIdDto = partnerIdDto;
	}

	public Date getCreationDateDto() {
		return creationDateDto;
	}

	public void setCreationDateDto(Date creationDateDto) {
		this.creationDateDto = creationDateDto;
	}

	public double getAmountDto() {
		return amountDto;
	}

	public void setAmountDto(double amountDto) {
		this.amountDto = amountDto;
	}

	public boolean getStatusDto() {
		return statusDto;
	}

	public void setStatusDto(boolean statusDto) {
		this.statusDto = statusDto;
	}	
	
}
