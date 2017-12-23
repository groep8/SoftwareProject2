package model;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Leerkracht generated by hbm2java
 */
@Entity
@Table(name = "Leerkracht", catalog = "SP2Team08")
public class Leerkracht implements java.io.Serializable {

	private Integer idLeerkracht;
	private String voornaam;
	private String familienaam;
	private Boolean archief;
	private Set<Training> trainings = new HashSet<Training>(0);

	public Leerkracht() {
	}

	public Leerkracht(String voornaam, String familienaam) {
		this.voornaam = voornaam;
		this.familienaam = familienaam;
	}

	public Leerkracht(String voornaam, String familienaam, Set<Training> trainings) {
		this.voornaam = voornaam;
		this.familienaam = familienaam;
		this.trainings = trainings;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idLeerkracht", unique = true, nullable = false)
	public Integer getIdLeerkracht() {
		return this.idLeerkracht;
	}

	public void setIdLeerkracht(Integer idLeerkracht) {
		this.idLeerkracht = idLeerkracht;
	}
	@Column(name = "voornaam", nullable = false, length = 30)
	public String getVoornaam() {
		return this.voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}

	@Column(name = "familienaam", nullable = false, length = 30)
	public String getFamilienaam() {
		return this.familienaam;
	}

	public void setFamilienaam(String familienaam) {
		this.familienaam = familienaam;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "leerkracht")
	public Set<Training> getTrainings() {
		return this.trainings;
	}

	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}
	
	@Transient
	public String getVolleNaam() {
		return voornaam + " " +  familienaam;
	}
	public Boolean getArchief() {
		return archief;
	}

	public void setArchief(Boolean archief) {
		this.archief = archief;
	}
}
