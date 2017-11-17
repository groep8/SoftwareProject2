

public class Personeel {
	private int idPersoneel;
	private String voornaam;
	private String familienaam;
	private int idAdres;
	private String afdeling;
	private String functie;
	private Boolean fire;
	
	public Personeel(String voornaam, String familienaam, int idAdres, String afdeling, String functie,
			Boolean fire) {
		super();
		//this.idPersoneel = idPersoneel;
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.idAdres = idAdres;
		this.afdeling = afdeling;
		this.functie = functie;
		this.fire = fire;
	}
	

	public int getIdPersoneel() {
		return idPersoneel;
	}
	public void setIdPersoneel(int idPersoneel) {
		this.idPersoneel = idPersoneel;
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
	public int getIdAdres() {
		return idAdres;
	}
	public void setIdAdres(int idAdres) {
		this.idAdres = idAdres;
	}
	public String getAfdeling() {
		return afdeling;
	}
	public void setAfdeling(String afdeling) {
		this.afdeling = afdeling;
	}
	public String getFunctie() {
		return functie;
	}
	public void setFunctie(String functie) {
		this.functie = functie;
	}
	
	public Boolean getFire() {
		return fire;
	}


	public void setFire(Boolean fire) {
		this.fire = fire;
	}
	

}
