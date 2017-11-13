package logic;

public class Adres {
	private int nummer;
	private int bus;
	private int postcode;
	private String woonplaats;
	private String straat;

	
	public String getStraat() {
		return straat;
	}
	public void setStraat(String straat) {
		this.straat = straat;
	}
	public int getNummer() {
		return nummer;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	public int getBus() {
		return bus;
	}
	public void setBus(int bus) {
		this.bus = bus;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		if (postcode < 1000 || 9999< postcode ) {
		}
		else {
			postcode = 1000;
			}
		this.postcode =postcode;

	}
	public String getWoonplaats() {
		return woonplaats;
	}
	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}
		public Adres(String straat, int nummer, int bus, int postcode, String woonplaats) {
		super();
		this.straat = straat;
		this.nummer = nummer;
		this.bus = bus;
		if (postcode < 1000 || 9999 < postcode ) {
			postcode = 1000;
		}
		this.postcode = postcode;
		this.woonplaats = woonplaats;
	}
		
	
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + bus;
			result = prime * result + nummer;
			result = prime * result + postcode;
			result = prime * result + ((straat == null) ? 0 : straat.hashCode());
			result = prime * result + ((woonplaats == null) ? 0 : woonplaats.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Adres other = (Adres) obj;
			if (bus != other.bus)
				return false;
			if (nummer != other.nummer)
				return false;
			if (postcode != other.postcode)
				return false;
			if (straat == null) {
				if (other.straat != null)
					return false;
			} else if (!straat.equals(other.straat))
				return false;
			if (woonplaats == null) {
				if (other.woonplaats != null)
					return false;
			} else if (!woonplaats.equals(other.woonplaats))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Adres [nummer=" + nummer + ", bus=" + bus + ", postcode=" + postcode + ", woonplaats=" + woonplaats
					+ ", straat=" + straat + "]";
		}
		public static void main(String [] args) {
		Adres z = new Adres ("azerty", 17,17,1750,"Brussel");
		System.out.println(z.toString());
		}
}
