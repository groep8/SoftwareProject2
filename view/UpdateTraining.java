package view;

import java.io.IOException;

import database.TrainingDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Main;
import model.TrainingDetail;

public class UpdateTraining {
	private TrainingController tc;
	
	
	private Main main;
	@FXML
	private Label myMes;
	
	
	


	public void setLabel(TrainingDetail td) {
		myMes.setText("Training: "+td.getTraining().getIdTraining() +" - "+ td.getTraining().getTrainingNaam());
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
	
	public void cancel() {
		tc.secundaireStage.close();
	
 }
	

}
