package logic;

import java.util.Date;

public class Personeel extends Persoon{
	Boolean acquiredCertif;
	int id;
	//welke lib hebt ge hiervoor nodig?
	//Img profilePic; 
	String title;
	
	public Personeel(Boolean acquiredCertif, int id, String title, String achternaam, String voornaam, Date geboorteDatum, int age ) {
		super(achternaam, voornaam, geboorteDatum, age);
		this.acquiredCertif = acquiredCertif;
		this.id = id;
		this.title = title;
	}

	public Personeel() {
	super();
		// TODO Auto-generated constructor stub
	}

	public Boolean getAcquiredCertif() {
		return acquiredCertif;
	}

	public void setAcquiredCertif(Boolean acquiredCertif) {
		this.acquiredCertif = acquiredCertif;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}

