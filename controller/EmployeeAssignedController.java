package controller;

import java.io.IOException;

import database.TrainingDetailPersoneelDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;
import model.Main;
import model.Training;
import model.TrainingDetail;

public class EmployeeAssignedController {
	@FXML 
	 private TableView<TrainingDetail> tableViewTraining;
	 @FXML 
	 private TableColumn<TrainingDetail,Integer> trainingId;
	 @FXML 
	 private TableColumn<TrainingDetail,String> trainingNaam;
	 @FXML 
	 private TableColumn<TrainingDetail,Integer> idEmployee;
	 @FXML
	 private TextField filterField2;
	
	

	 @FXML
	 private void initialize() {

		trainingId.setCellValueFactory(new Callback<CellDataFeatures<TrainingDetail, Integer>, ObservableValue<Integer>>() {
			@Override
			public ObservableValue<Integer> call(CellDataFeatures<TrainingDetail, Integer> data) {
				return new SimpleIntegerProperty(data.getValue().getTraining().getIdTraining()).asObject();
			}
		});
		
		trainingNaam.setCellValueFactory(new Callback<CellDataFeatures<TrainingDetail, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<TrainingDetail, String> data) {
				data.getValue();
				return new SimpleStringProperty(data.getValue().getTraining().getTrainingNaam());
			}
		});
			
		idEmployee.setCellValueFactory(new Callback<CellDataFeatures<TrainingDetail, Integer>, ObservableValue<Integer>>() {
				@Override
				public ObservableValue<Integer> call(CellDataFeatures<TrainingDetail, Integer> data) {
					return new SimpleIntegerProperty(data.getValue().getPersoneel()).asObject();
				}
			});
		
					
			ObservableList<TrainingDetail> list = FXCollections.observableArrayList(TrainingDetailPersoneelDAO.getall());
			//tableViewTraining.setItems(list);
			FilteredList<TrainingDetail> filteredData = new FilteredList<>(list, p -> true);
			filterField2.textProperty().addListener((observable, oldValue, newValue) -> {
	            filteredData.setPredicate(td -> {
	                // If filter text is empty, display all persons.
	                if (newValue == null || newValue.isEmpty()) {
	                    return true;
	                }

	                String lowerCaseFilter = newValue.toLowerCase();

	                if (td.getTraining().getTrainingNaam().toLowerCase().contains(lowerCaseFilter)) {
	                    return true; // Filter matches first name.
	                } 
	                return false; // Does not match.
	            });
	        });

	        // 3. Wrap the FilteredList in a SortedList. 
	        SortedList<TrainingDetail> sortedData = new SortedList<>(filteredData);

	        // 4. Bind the SortedList comparator to the TableView comparator.
	        sortedData.comparatorProperty().bind(tableViewTraining.comparatorProperty());

	        // 5. Add sorted (and filtered) data to the table.
	        tableViewTraining.setItems(sortedData);
			
		
		
	 }
	 
	 private int id1;
		@FXML
			public void DeleteTraining() throws IOException {
				TrainingDetail td=tableViewTraining.getSelectionModel().getSelectedItem();
				if (td==null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Fout");
					alert.setContentText("Fout, Niets geselecteerd");
					alert.setHeaderText(null);
					alert.showAndWait();
				}
				else {
				this.id1=td.getIdTrainingDetail();
				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setHeaderText(null);
				alert2.setTitle("DELETE");
				alert2.setContentText(td.getTraining().getTrainingNaam() + " training for " + td.getPersoneel() +" is not more availaible.");
				alert2.showAndWait();
				TrainingDetailPersoneelDAO.deleteknop1(id1);
				
				
				
				}
		}
	 
	
}
