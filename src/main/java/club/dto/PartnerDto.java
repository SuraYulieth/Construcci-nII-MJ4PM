package club.dto;

import java.sql.Date;

public class PartnerDto {

	private long idDto;
	private UserDto userIdDto;
	private double amountDto;
	private String typeDto;
	private Date creationDateDto;
	
	public PartnerDto() {}

	public long getIdDto() {
		return idDto;
	}

	public void setIdDto(long idDto) {
		this.idDto = idDto;
	}

	public UserDto getUserIdDto() {
		return userIdDto;
	}

	public void setUserIdDto(UserDto userIdDto) {
		this.userIdDto = userIdDto;
	}

	public double getAmountDto() {
		return amountDto;
	}

	public void setAmountDto(double amountDto) {
		this.amountDto = amountDto;
	}

	public String getTypeDto() {
		return typeDto;
	}

	public void setTypeDto(String typeDto) {
		this.typeDto = typeDto;
	}

	public Date getCreationDateDto() {
		return creationDateDto;
	}

	public void setCreationDateDto(Date creationDateDto) {
		this.creationDateDto = creationDateDto;
	}
	
	
}
