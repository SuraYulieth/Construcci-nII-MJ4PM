package club.dto;

public class UserDto {

	private long idDto;
	private String userNameDto;
	private String passwordDto;
	private String rolDto;
	private PersonDto personIdDto;
	
	public UserDto() {}

	public long getIdDto() {
		return idDto;
	}

	public void setIdDto(long idDto) {
		this.idDto = idDto;
	}

	public String getUserNameDto() {
		return userNameDto;
	}

	public void setUserNameDto(String userNameDto) {
		this.userNameDto = userNameDto;
	}

	public String getPasswordDto() {
		return passwordDto;
	}

	public void setPasswordDto(String passwordDto) {
		this.passwordDto = passwordDto;
	}

	public String getRolDto() {
		return rolDto;
	}

	public void setRolDto(String rolDto) {
		this.rolDto = rolDto;
	}

	public PersonDto getPersonIdDto() {
		return personIdDto;
	}

	public void setPersonIdDto(PersonDto personIdDto) {
		this.personIdDto = personIdDto;
	}
	
	
}
