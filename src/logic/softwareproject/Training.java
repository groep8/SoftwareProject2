package softwareproject;

import java.util.Date;

public class Training {
	
	private Leerkracht idLeerkracht;
	private int idTraining;
	private String naamTraining;
	private String startDate;
	private String endDate;
	private Adres idPlaats;
	private Personeel idPersoneel;
	
	public Training(int idTraining,String naamTraining,Leerkracht idLeerkracht, String startDate, String endDate,
			Adres idPlaats, Personeel idPersoneel) {
		super();
		this.idTraining = idTraining;
		this.naamTraining = naamTraining;
		this.idLeerkracht = idLeerkracht;
		this.startDate = startDate;
		this.endDate = endDate;
		this.idPlaats = idPlaats;
		this.setIdPersoneel(idPersoneel);
	}

	public String getNaamTraining() {
		return naamTraining;
	}
	
	public void setNaamTraining(String naamTraining) {
		this.naamTraining = naamTraining;
	}
	public String getStartdate() {
		return startDate;
	}
	public void setStartdate(String startdate) {
		this.startDate = startdate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Leerkracht getIdLeerkracht() {
		return idLeerkracht;
	}

	public void setIdLeerkracht(Leerkracht idLeerkracht) {
		this.idLeerkracht = idLeerkracht;
	}

	public Adres getIdPlaats() {
		return idPlaats;
	}

	public void setIdPlaats(Adres idPlaats) {
		this.idPlaats = idPlaats;
	}

	public int getIdTraining() {
		return idTraining;
	}

	public void setIdTraining(int idTraining) {
		this.idTraining = idTraining;
	}

	public Personeel getIdPersoneel() {
		return idPersoneel;
	}

	public void setIdPersoneel(Personeel idPersoneel) {
		this.idPersoneel = idPersoneel;
	}

	
}