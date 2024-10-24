package club.dto;

public class GuestDto {
	private long id;
	private PartnerDto partnerId;
	private UserDto usarIdDto;
	private String statusDto;
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

	public String getStatusDto() {
		return statusDto;
	}
	public void setStatusDto(String statusDto) {
		this.statusDto = statusDto;
	}
	
	
}
