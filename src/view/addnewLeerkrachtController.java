package view;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import database.TrainingDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Leerkracht;
import model.Main;
import model.Training;

public class addnewLeerkrachtController {
	
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField nameField2;
	
	
	public void saveLeerkracht() throws SQLException, IOException {
		
		String voornaam = nameField.getText();
		String familienaam =nameField2.getText();
		Leerkracht l = new Leerkracht();
		l.setVoornaam(voornaam);
		l.setFamilienaam(familienaam);
		
		
		if(TrainingDAO.saveLeerkracht(l)) {
		
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation");
			alert.setContentText("Leekracht aangemaakt");
			alert.setHeaderText(null);
			alert.showAndWait();
			Main.addDialogStage.close();
			Main.LeerkrachtView();
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
