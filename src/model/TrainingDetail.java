package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TrainingDetail generated by hbm2java
 */
@Entity
@Table(name = "TrainingDetail", catalog = "SP2Team08")
public class TrainingDetail implements java.io.Serializable {

	private Integer idTrainingDetail;
	private int personeel;
	private Training training;
	@Column(name="archief",columnDefinition = "BIT DEFAULT 1",nullable = false) 
	//@org.hibernate.annotations.Type(type = "yes_no")
	private Boolean archief = false;
	public TrainingDetail() {
	}

	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idTrainingDetail", unique = true, nullable = false)
	public Integer getIdTrainingDetail() {
		return this.idTrainingDetail;
	}

	public void setIdTrainingDetail(Integer idTrainingDetail) {
		this.idTrainingDetail = idTrainingDetail;
	}

	@Column(name = "idEmployee", nullable = false)
	public int getPersoneel() {
		return this.personeel;
	}

	public void setPersoneel(int personeel) {
		this.personeel = personeel;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "idTraining", nullable = false)
	public Training getTraining() {
		return this.training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	@Column(name="archief",columnDefinition = "BIT DEFAULT 1",nullable = false)
	//@org.hibernate.annotations.Type(type = "yes_no")
	public Boolean getArchief() {
		return archief;
	}


	public void setArchief(Boolean archief) {
		this.archief = archief;
	}


}
