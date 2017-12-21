package controller;

import java.io.IOException;
import java.sql.SQLException;

import database.TrainingDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Adres;
import model.Main;

public class addnewAdresController {

	@FXML
	private TextField nameField;
	
	@FXML
	private TextField huisnummer;
	@FXML
	private TextField postcode;
	@FXML
	private TextField stad;
	@FXML
	private TextField land;
	
	
	public void saveAdres() throws SQLException, IOException {
		Adres a =new Adres();
		String straat = nameField.getText();
		String huisn =huisnummer.getText();
		int huis= Integer.parseInt(huisn);
		String postString = postcode.getText();
		int post= Integer.parseInt(postString);
		String stadstring= stad.getText();
		String landstring = land.getText();
		
		a.setStraat(straat);
		a.setHuisnum(huis);
		a.setPostcode(post);
		a.setStad(stadstring);
		a.setLand(landstring);
	
		
		
		if(TrainingDAO.saveAdres(a)) {
		
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation");
			alert.setContentText("Adres aangemaakt");
			alert.setHeaderText(null);
			alert.showAndWait();
			Main.addDialogStage.close();
			Main.AdresView();
		}
		else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation");
			alert.setContentText("Adres niet aangemaakt, foutieve invoer");
			alert.setHeaderText(null);
			alert.showAndWait();
			Main.addDialogStage.close();
		}
	
	}
	 public void cancel() {

			
			Main.addDialogStage.close();
	 }

}

