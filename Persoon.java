package logic;

import java.util.Date;

public class Persoon {
	private String achternaam;
	private String voornaam;
	private int age;
	private Date birthDate;
	
	public Persoon(String achternaam2, String voornaam2, Date geboorteDatum, int age2) {
		// TODO Auto-generated constructor stub
	}
	public Persoon() {
		// TODO Auto-generated constructor stub
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
