package controller;

import java.io.IOException;

import database.TrainingDAO;
import database.TrainingDetailPersoneelDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import model.Employee;
import model.Main;
import model.Training;
import model.TrainingDetail;

public class EmployeestotrController {

	
	@FXML 
	 private TableView<TrainingDetail> tableViewTraining;
	 @FXML 
	 private TableColumn<TrainingDetail,Integer> trainingId;
	 @FXML 
	 private TableColumn<TrainingDetail,Integer> idEmployee;
	
	public void setLabel(Employee e) {
		myMes.setText("Employee: "+ e.getFirstname()+" "+ e.getLastName());
	}
	@FXML
	private Label myMes;
	 @FXML
	private ComboBox<Training> training;

	 @FXML
	 private void initialize() {
	 ObservableList<Training> traininglist = FXCollections.observableArrayList(TrainingDetailPersoneelDAO.getTraining());
	 training.setItems(traininglist);
	 
	 
	 Callback<ListView<Training>, ListCell<Training>> call1 = lv -> new ListCell<Training>() {

		    @Override
		    protected void updateItem(Training t, boolean empty) {
		        super.updateItem(t, empty);
		        setText(t == null ? "" : (t.getTrainingNaam()));
		    }

		};
		
		training.setCellFactory(call1);
		training.setButtonCell(call1.call(null));
		
		
		trainingId.setCellValueFactory(new Callback<CellDataFeatures<TrainingDetail, Integer>, ObservableValue<Integer>>() {
			@Override
			public ObservableValue<Integer> call(CellDataFeatures<TrainingDetail, Integer> data) {
				return new SimpleIntegerProperty(data.getValue().getTraining().getIdTraining()).asObject();
			}
		});
			
		idEmployee.setCellValueFactory(new Callback<CellDataFeatures<TrainingDetail, Integer>, ObservableValue<Integer>>() {
				@Override
				public ObservableValue<Integer> call(CellDataFeatures<TrainingDetail, Integer> data) {
					return new SimpleIntegerProperty(data.getValue().getPersoneel()).asObject();
				}
			});
		
					
			ObservableList<TrainingDetail> list = FXCollections.observableArrayList(TrainingDetailPersoneelDAO.getall());
			tableViewTraining.setItems(list);
		
		
	 }
	
	 public void button(){
		 Training t = training.getValue();
		 TrainingDetail td= new TrainingDetail();
		 td.setTraining(t);
		 EmployeesController ec = new EmployeesController();
		 int id = ec.getIdemp();
		 td.setPersoneel(id);
		 System.out.println(td.getPersoneel()+ " "+ td.getTraining().getIdTraining());
		 TrainingDetailPersoneelDAO.saveTrainingDetail(td);
		 Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation");
			alert.setContentText("Employee toegevoegd aan training");
			alert.setHeaderText(null);
			alert.showAndWait();
			ec.second.close();
		 
		 
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
			alert2.setContentText(td.getTraining().getTrainingNaam() + " voor " + td.getPersoneel() +" is deleted");
			alert2.showAndWait();
			TrainingDetailPersoneelDAO.deleteknop1(id1);
		
			
			
			}
		}


	 

}
