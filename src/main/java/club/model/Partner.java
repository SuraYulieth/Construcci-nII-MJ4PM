package club.model;

import java.sql.Date;

public class Partner {
	
	private long id;
	private User userId;
	private double avaibleFunds;
	private String suscriptionType;
	private Date afiliationDate;
	
	public Partner() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public double getAvaibleFunds() {
		return avaibleFunds;
	}
	public void setAvaibleFunds(double avaibleFunds) {
		this.avaibleFunds = avaibleFunds;
	}
	public String getSuscriptionType() {
		return suscriptionType;
	}
	public void setSuscriptionType(String suscriptionType) {
		this.suscriptionType = suscriptionType;
	}
	public Date getAfiliationDate() {
		return afiliationDate;
	}
	public void setAfiliationDate(Date afiliationDate) {
		this.afiliationDate = afiliationDate;
	}

	
	
}
