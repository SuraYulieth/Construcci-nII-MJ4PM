package club.dto;

public class PersonDto {

	private long idDto;
	private long identificationCardDto;
	private String nameDto;
	private String cellPhoneNumberDto;
	
	public PersonDto() {	
	}

	public long getIdDto() {
		return idDto;
	}

	public void setIdDto(long idDto) {
		this.idDto = idDto;
	}

	public long getIdentificationCardDto() {
		return identificationCardDto;
	}

	public void setIdentificationCardDto(long identificationCardDto) {
		this.identificationCardDto = identificationCardDto;
	}

	public String getNameDto() {
		return nameDto;
	}

	public void setNameDto(String nameDto) {
		this.nameDto = nameDto;
	}

	public String getCellPhoneNumberDto() {
		return cellPhoneNumberDto;
	}

	public void setCellPhoneNumberDto(String cellPhoneNumberDto) {
		this.cellPhoneNumberDto = cellPhoneNumberDto;
	}
	
	
}
