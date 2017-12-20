package view;

import java.io.IOException;
import java.time.LocalDate;

import database.TrainingDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Callback;
import model.Leerkracht;
import model.Main;
import model.Training;
import model.TrainingDetail;

public class UpdateTraining {
	private TrainingController tc;
	
	
	private Main main;
	@FXML
	private Label myMes;

	public void setLabel(Training d) {
		myMes.setText("Training: "+d.getIdTraining() +" - "+ d.getTrainingNaam() + " - " + d.getAdres().getStraat()+"  "+ d.getAdres().getHuisnum()  + " - " + d.getBeginDatum());
	}
	@FXML
	private TextField nameField;
	
	public void changeName() throws IOException {
		String naam= nameField.getText();
		
		TrainingController test= new TrainingController();
		int id= test.getId();
		TrainingDAO.updateTrainingName(id,naam);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setContentText("Trainingnaam gewijzigt");
		alert.setHeaderText(null);
		alert.showAndWait();
		tc.secundaireStage.close();
		Main.TrainingView();
	}
	public void nameView() throws IOException {
		TrainingController tc= new TrainingController();
		tc.updateName();
	}
	public void leerkrachtView() throws IOException {
		TrainingController tc= new TrainingController();
		tc.updateLeerkracht();
	}
	public void AdresView() throws IOException {
		TrainingController tc= new TrainingController();
		tc.updateAdres();
	}
	public void DatumView() throws IOException {
		TrainingController tc= new TrainingController();
		tc.updateDatum();
	}
	public void DatumeindView() throws IOException {
		TrainingController tc= new TrainingController();
		tc.updateDatum2();
	}
	@FXML
	private DatePicker datumField;
	
	@FXML
	private DatePicker einddatumField;
	
	public void changeDatum() throws IOException {
		LocalDate datum = datumField.getValue();
		TrainingController test= new TrainingController();
		int id= test.getId();
		TrainingDAO.updateTrainingDatum(id, datum);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setContentText("Begin TrainingDatum gewijzigt");
		alert.setHeaderText(null);
		alert.showAndWait();
		tc.secundaireStage.close();
		Main.TrainingView();
	}
	public void changeEindDatum() throws IOException {
		LocalDate datum = einddatumField.getValue();
		TrainingController test= new TrainingController();
		int id= test.getId();
		TrainingDAO.updateEindeTrainingDatum(id, datum);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Confirmation");
		alert.setContentText("einde TrainingDatum gewijzigt");
		alert.setHeaderText(null);
		alert.showAndWait();
		tc.secundaireStage.close();
		Main.TrainingView();
	}
	
	
	
	 public void cancel() throws IOException {
			tc.secundaireStage.close();
		
		}
	
	 

}
