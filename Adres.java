package logic;

import java.sql.SQLException;

public class Adres {
private String gemeente;
private String land;
private int nummer;
private int postcode;
private String straat;
public Adres(String gemeente, String land,int nummer, int postcode, String straat) {
	super();
	this.nummer=nummer;
	this.gemeente = gemeente;
	this.land = land;
	this.postcode = postcode;
	this.straat = straat;
}
public Adres(){
	
}
@Override
public String toString() {
	return "Adres [gemeente=" + gemeente + ", land=" + land + ", nummer=" + nummer + ", postcode=" + postcode
			+ ", straat=" + straat + "]";
}
public int getNummer() {
	return nummer;
}
public void setNummer(int nummer) {
	this.nummer = nummer;
}
public String getGemeente() {
	return gemeente;
}
public void setGemeente(String gemeente) {
	this.gemeente = gemeente;
}
public String getLand() {
	return land;
}
public void setLand(String land) {
	this.land = land;
}
public int getPostcode() {
	return postcode;
}
public void setPostcode(int postcode) {
	this.postcode = postcode;
}
public String getStraat() {
	return straat;
}
public void setStraat(String straat) {
	this.straat = straat;
}

public static void main(String[]args) throws SQLException {
	try {
		Adres a1=new Adres("test", "België", 16, 1070, "test");
		System.out.println(a1.toString());
		AdresDAO.insert(a1);
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
