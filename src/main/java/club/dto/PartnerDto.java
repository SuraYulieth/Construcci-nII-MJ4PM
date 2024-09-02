package club.dto;

import java.sql.Date;

import club.model.User;

public class PartnerDto {

	private long idDto;
	private UserDto userIdDto;
	private double avaibleFundsDto;
	private String suscriptionTypeDto;
	private Date afiliationDateDto;
	
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

	public double getAvaibleFundsDto() {
		return avaibleFundsDto;
	}

	public void setAvaibleFundsDto(double avaibleFundsDto) {
		this.avaibleFundsDto = avaibleFundsDto;
	}

	public String getSuscriptionTypeDto() {
		return suscriptionTypeDto;
	}

	public void setSuscriptionTypeDto(String suscriptionTypeDto) {
		this.suscriptionTypeDto = suscriptionTypeDto;
	}

	public Date getAfiliationDateDto() {
		return afiliationDateDto;
	}

	public void setAfiliationDateDto(Date afiliationDateDto) {
		this.afiliationDateDto = afiliationDateDto;
	}
	
	
}
