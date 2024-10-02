package club.dto;

public class GuestDto {
	private long id;
	private PartnerDto partnerId;
	private UserDto usarIdDto;
	private long registrationGuestDto;
	private String invitationStatusDto;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public PartnerDto getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(PartnerDto partnerId) {
		this.partnerId = partnerId;
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
