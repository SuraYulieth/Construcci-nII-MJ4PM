package club.dto;

public class PersonDto {

	private long idDto;
	private long documentDto;
	private String nameDto;
	private String cellPhoneDto;
	
	public PersonDto() {	
	}

	public long getIdDto() {
		return idDto;
	}

	public void setIdDto(long idDto) {
		this.idDto = idDto;
	}

	public long getDocumentDto() {
		return documentDto;
	}

	public void setDocumentDto(long documentDto) {
		this.documentDto = documentDto;
	}

	public String getNameDto() {
		return nameDto;
	}

	public void setNameDto(String nameDto) {
		this.nameDto = nameDto;
	}

	public String getCellPhoneDto() {
		return cellPhoneDto;
	}

	public void setCellPhoneDto(String cellPhoneDto) {
		this.cellPhoneDto = cellPhoneDto;
	}
	
	
}
