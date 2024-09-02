package club.model;

public class Person {
	
	private long id;
	private long identificationCard;
	private String name;
	private String cellPhoneNumber;
	
	public Person() {	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdentificationCard() {
		return identificationCard;
	}

	public void setIdentificationCard(long identificationCard) {
		this.identificationCard = identificationCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}
	


}
