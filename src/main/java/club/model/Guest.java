package club.model;

public class Guest {
	
	private Partner id;
	private User userId;
	private long registrationGuest;
	private String invitationStatus;
	
	public Guest() {
	}

	public Partner getId() {
		return id;
	}

	public void setId(Partner id) {
		this.id = id;
	}

	public User getUsarId() {
		return userId;
	}

	public void setUsarId(User usarId) {
		this.userId = usarId;
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
