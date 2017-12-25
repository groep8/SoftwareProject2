package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ChartData", catalog = "SP2Team08")
public class Chartdata implements java.io.Serializable {
	String attnaam;
	int aantal;
	

	public Chartdata() {
		// TODO Auto-generated constructor stub
	}

	@Column(name = "attnaam", nullable = false)
	public String getAttnaam() {
		return this.attnaam;
	}

	
	public void setAttnaam(String attnaam) {
		this.attnaam = attnaam;
	}

	@Column(name = "aantal", nullable = false)
	public int getAantal() {
		return this.aantal;
	}

	
	public void setAantal(int aantal) {
		this.aantal = aantal;
	}

}
