package softwareproject;

public class Adres {
	
	private int idAdres;
	private String straat;
	private int huisnum;
	private int postcode;
	private String stad;
	private String land;
	
	public Adres(int idAdres, String straat, int huisnum, int postcode, String stad, String land) {
		super();
		this.idAdres = idAdres;
		this.straat = straat;
		this.huisnum = huisnum;
		this.postcode = postcode;
		this.stad = stad;
		this.land = land;
	}
	public int getIdAdres() {
		return idAdres;
	}
	public void setIdAdres(int idAdres) {
		this.idAdres = idAdres;
	}
	public String getStraat() {
		return straat;
	}
	public void setStraat(String straat) {
		this.straat = straat;
	}
	public int getHuisnum() {
		return huisnum;
	}
	public void setHuisnum(int huisnum) {
		this.huisnum = huisnum;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getStad() {
		return stad;
	}
	public void setStad(String stad) {
		this.stad = stad;
	}
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
}
