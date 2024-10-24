package club.dto;

public class UserDto {

	private long idDto;
	private String userNameDto;
	private String passwordDto;
	private String roleDto;
	private PersonDto personnIdDto;
	
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

	public String getRoleDto() {
		return roleDto;
	}

	public void setRoleDto(String roleDto) {
		this.roleDto = roleDto;
	}

	public PersonDto getPersonnIdDto() {
		return personnIdDto;
	}

	public void setPersonnIdDto(PersonDto personnIdDto) {
		this.personnIdDto = personnIdDto;
	}
	
	
}
