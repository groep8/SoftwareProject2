package view;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import database.TrainingDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Adres;
import model.Main;
import model.Training;
import model.TrainingDetail;

public class addNewTrainingController {
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField adresField;
	
	@FXML
	private TextField leerkrachtField;
	
	@FXML
	private DatePicker datumField;
	
	@FXML
	private TextField personeelField;
	
	public void saveTraining() throws SQLException, IOException {
		
		
		String naam = nameField.getText();
		String adresString = adresField.getText();
		int adres =Integer.parseInt(adresString);
		String leerkrachtstring = leerkrachtField.getText();
		int leerkracht =Integer.parseInt(leerkrachtstring);
		LocalDate datum = datumField.getValue();
		String personeelstring = personeelField.getText();
		int personeel =Integer.parseInt(personeelstring);
		
		
		Training training = new Training();
		training.setTrainingNaam(naam);
		training.setDatum(datum);
		training.setStatus("WAITING");
		training.setArchief(false);

		
		TrainingDetail trainingd = new TrainingDetail();
		trainingd.setPersoneel(personeel);
		trainingd.setTraining(training);
		
		if(TrainingDAO.saveTraining(trainingd, adres, leerkracht)) {
		
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation");
			alert.setContentText("Training aangemaakt");
			alert.setHeaderText(null);
			alert.showAndWait();
			Main.addDialogStage.close();
			Main.TrainingView();
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation");
			alert.setContentText("Training niet aangemaakt, foutieve invoer");
			alert.setHeaderText(null);
			alert.showAndWait();
			Main.addDialogStage.close();
		}
	
	}
	 public void cancel() {

			
			Main.addDialogStage.close();
	 }
	 

}
