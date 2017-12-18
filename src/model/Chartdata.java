package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Adres", catalog = "SP2Team08")
public class Chartdata {
	
	String attnaam;
	int aantal;
	

	public Chartdata() {
		// TODO Auto-generated constructor stub
	}


	public String getAttnaam() {
		return attnaam;
	}


	public void setAttnaam(String attnaam) {
		this.attnaam = attnaam;
	}


	public int getAantal() {
		return aantal;
	}


	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

}
