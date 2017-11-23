package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Training")
public class Training {
	@Id
	@Column(name="idTraining")
	private int idTraining;

	@Column(name="trainingNaam")
	private String trainingNaam;

	@Column(name="idLeerkracht")
	private int idLeerkracht;

	@Column(name="idAdres")
	private int idAdres;

	public Training() {
	
	}

	public Training(String trainingNaam, int idLeerkracht, int idAdres) {
		super();
		this.trainingNaam = trainingNaam;
		this.idLeerkracht = idLeerkracht;
		this.idAdres = idAdres;
	}

	public int getIdTraining() {
		return idTraining;
	}

	public void setIdTraining(int idTraining) {
		this.idTraining = idTraining;
	}

	public String getTrainingNaam() {
		return trainingNaam;
	}

	public void setTrainingNaam(String trainingNaam) {
		this.trainingNaam = trainingNaam;
	}

	public int getIdLeerkracht() {
		return idLeerkracht;
	}

	public void setIdLeerkracht(int idLeerkracht) {
		this.idLeerkracht = idLeerkracht;
	}

	public int getIdAdres() {
		return idAdres;
	}

	public void setIdAdres(int idAdres) {
		this.idAdres = idAdres;
	}

	@Override
	public String toString() {
		return "Training [idTraining=" + idTraining + ", trainingNaam=" + trainingNaam + ", idLeerkracht="
				+ idLeerkracht + ", idAdres=" + idAdres + "]";
	}
	
}
