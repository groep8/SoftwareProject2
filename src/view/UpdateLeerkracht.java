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
import model.Leerkracht;
import model.Main;

public class UpdateLeerkracht {
	
	 @FXML
	 private ComboBox<Leerkracht> leerkracht;
	 
	 private TrainingController tc;
	 
	 @FXML
	 private void initialize() {
	 ObservableList<Leerkracht> leerkrachtlist = FXCollections.observableArrayList(TrainingDAO.getLeerkracht());
	 leerkracht.setItems(leerkrachtlist);
	 
	 Callback<ListView<Leerkracht>, ListCell<Leerkracht>> call1 = lv -> new ListCell<Leerkracht>() {

		    @Override
		    protected void updateItem(Leerkracht l, boolean empty) {
		        super.updateItem(l, empty);
		        setText(l == null ? "" : (l.getVolleNaam()));
		    }

		};
		
		leerkracht.setCellFactory(call1);
		leerkracht.setButtonCell(call1.call(null));
	 }
	 
	 public void changeLeerkracht() throws IOException {
		 Leerkracht l = leerkracht.getValue();
			
			TrainingController test= new TrainingController();
			int id= test.getId();
			TrainingDAO.updateTrainingLeerkracht(id, l);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation");
			alert.setContentText("Trainingnaam gewijzigt");
			alert.setHeaderText(null);
			alert.showAndWait();
			tc.secundaireStage.close();
			Main.TrainingView();
		}
	 
	 public void cancel() throws IOException {
			tc.secundaireStage.close();
		
		}

}
