package club.dto;

import java.sql.Date;

public class InvoiceDto {

	private String billIdDto;
	private String idMemberDto;
	private UserDto idUserDto;
	private Date generationDateDto;
	private double amountDto;
	private boolean statusDto;
	
	public InvoiceDto() {}

	public String getBillIdDto() {
		return billIdDto;
	}

	public void setBillIdDto(String billIdDto) {
		this.billIdDto = billIdDto;
	}

	public String getIdMemberDto() {
		return idMemberDto;
	}

	public void setIdMemberDto(String idMemberDto) {
		this.idMemberDto = idMemberDto;
	}

	public UserDto getIdUserDto() {
		return idUserDto;
	}

	public void setIdUserDto(UserDto idUserDto) {
		this.idUserDto = idUserDto;
	}

	public Date getGenerationDateDto() {
		return generationDateDto;
	}

	public void setGenerationDateDto(Date generationDateDto) {
		this.generationDateDto = generationDateDto;
	}

	public double getAmountDto() {
		return amountDto;
	}

	public void setAmountDto(double amountDto) {
		this.amountDto = amountDto;
	}

	public boolean isStatusDto() {
		return statusDto;
	}

	public void setStatusDto(boolean statusDto) {
		this.statusDto = statusDto;
	}
	
	
	
}
