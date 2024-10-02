package club.model;

public class Guest {
	private long id;
	private Partner partnerId;
	private User userId;
	private long registrationGuest;
	private String invitationStatus;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Partner getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(Partner partnerId) {
		this.partnerId = partnerId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public long getRegistrationGuest() {
		return registrationGuest;
	}
	public void setRegistrationGuest(long registrationGuest) {
		this.registrationGuest = registrationGuest;
	}
	public String getInvitationStatus() {
		return invitationStatus;
	}
	public void setInvitationStatus(String invitationStatus) {
		this.invitationStatus = invitationStatus;
	}
	
	
	
	
}
