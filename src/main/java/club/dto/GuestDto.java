package club.dto;

public class GuestDto {
	
	private PartnerDto idDto;
	private UserDto usarIdDto;
	private long registrationGuestDto;
	private String invitationStatusDto;
	
	public GuestDto() {
	}

	public PartnerDto getIdDto() {
		return idDto;
	}

	public void setIdDto(PartnerDto idDto) {
		this.idDto = idDto;
	}

	public UserDto getUsarIdDto() {
		return usarIdDto;
	}

	public void setUsarIdDto(UserDto usarIdDto) {
		this.usarIdDto = usarIdDto;
	}

	public long getRegistrationGuestDto() {
		return registrationGuestDto;
	}

	public void setRegistrationGuestDto(long registrationGuestDto) {
		this.registrationGuestDto = registrationGuestDto;
	}

	public String getInvitationStatusDto() {
		return invitationStatusDto;
	}

	public void setInvitationStatusDto(String invitationStatusDto) {
		this.invitationStatusDto = invitationStatusDto;
	}
	
	
}
