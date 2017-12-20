package view;

import java.io.IOException;

import database.TrainingDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Callback;
import model.Adres;
import model.Main;

public class UpdateAdres {
	@FXML
	 private ComboBox<Adres> adres;
	 
	 private TrainingController tc;
	 
	 @FXML
	 private void initialize() {
	 ObservableList<Adres> adreslist = FXCollections.observableArrayList(TrainingDAO.getadres());
	 adres.setItems(adreslist);
	 
	 Callback<ListView<Adres>, ListCell<Adres>> call1 = lv -> new ListCell<Adres>() {

		    @Override
		    protected void updateItem(Adres a, boolean empty) {
		        super.updateItem(a, empty);
		        setText(a == null ? "" : (a.getVolleAdres()));
		    }

		};
		
		adres.setCellFactory(call1);
		adres.setButtonCell(call1.call(null));
	 }
	 
	 public void changeAdres() throws IOException {
		 	Adres a = adres.getValue();
			TrainingController test= new TrainingController();
			int id= test.getId();
			TrainingDAO.updateTrainingAdres(id, a);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation");
			alert.setContentText("TrainingAdres gewijzigt");
			alert.setHeaderText(null);
			alert.showAndWait();
			tc.secundaireStage.close();
			Main.TrainingView();
		}
	 
	 public void cancel() throws IOException {
			tc.secundaireStage.close();
		
		}

}
