package softwareproject;

public class Leerkracht {
	
	private int Idleerkracht;
	public Leerkracht(int idleerkracht, String voornaam, String familienaam, Adres idAdres) {
		
		this.Idleerkracht = idleerkracht;
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.idAdres = idAdres;
	}
	private String voornaam;
	private String familienaam;
	private Adres idAdres;
	
	public int getIdleerkracht() {
		return Idleerkracht;
	}
	public void setIdleerkracht(int idleerkracht) {
		Idleerkracht = idleerkracht;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public String getFamilienaam() {
		return familienaam;
	}
	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}
	public Adres getIdAdres() {
		return idAdres;
	}
	public void setIdAdres(Adres idAdres) {
		this.idAdres = idAdres;
	}

}
