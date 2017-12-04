package logic;

public class Personeel {
	private int idPersoneel;
	private String voornaam;
	private String familienaam;
	private Adres idAdres;
	private String afdeling;
	private String functie;
	private String beginDatum;
	private String eindDatum;
	
	public Personeel(int idPersoneel, String voornaam, String familienaam, Adres idAdres, String afdeling, String functie,
			String beginDatum, String eindDatum) {
		super();
		this.idPersoneel = idPersoneel;
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.idAdres = idAdres;
		this.afdeling = afdeling;
		this.functie = functie;
		this.beginDatum = beginDatum;
		this.eindDatum = eindDatum;
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
	public Adres getIdAdres() {
		return idAdres;
	}
	public void setIdAdres(Adres idAdres) {
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
	public String getBeginDatum() {
		return beginDatum;
	}
	public void setBeginDatum(String beginDatum) {
		this.beginDatum = beginDatum;
	}
	public String getEindDatum() {
		return eindDatum;
	}
	public void setEindDatum(String eindDatum) {
		this.eindDatum = eindDatum;
	}
	

}
