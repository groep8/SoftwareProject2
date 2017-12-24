package controller;

import java.io.IOException;

import database.TrainingDAO;
import database.TrainingDetailPersoneelDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;
import model.Main;
import model.Training;
import model.TrainingDetail;
import model.EmployeeOdata;
import model.Employee;

public class EmployeesController {
	
	private static int idemp;
	private static int idemp1;
	public static Stage second;

	private Main main;
	@FXML 
	private TableView<Employee> employees;
	 @FXML 
	private TableColumn<Employee,String> lastname;
	 @FXML 
	private TableColumn<Employee,Integer> id;
	 @FXML 
	private TableColumn<Employee,String> firstname;
	 @FXML
	 private TextField filterField;
	 

		@FXML 
		private TableView<Training> tableTraining;
		 @FXML 
		private TableColumn<Training,Integer> idTraining;
		 @FXML 
		private TableColumn<Training,String> trainingNaam;
	
	 
	 
	 
	@FXML
	private void goHome() throws IOException {
		main.mainView();
	}
	
	@FXML
	private void goTraining() throws IOException {
		main.TrainingView();
	}
	@FXML
	private void goEmployees() throws IOException {
		main.EmployeesView();
	}
	
	@FXML
	private void goStatistic() throws IOException {
		main.StatisticView();
	}
	@FXML
	private void goOptions() throws IOException {
		main.OptionView();
	}

	@FXML
	public void assign() throws IOException {
		Employee d=employees.getSelectionModel().getSelectedItem();
		Training t = tableTraining.getSelectionModel().getSelectedItem();
		
		if (d==null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fout");
			alert.setContentText("False ,employee not selected.");
			alert.setHeaderText(null);
			alert.showAndWait();
		}
		if(t==null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fout");
			alert.setContentText("False,training not selected.");
			alert.setHeaderText(null);
			alert.showAndWait();
		}
		if(t != null && d != null) {
			 TrainingDetail td= new TrainingDetail();
			 td.setTraining(t);
			 int id = d.getId();
			 td.setPersoneel(id);
			 System.out.println(td.getPersoneel()+ " "+ td.getTraining().getIdTraining());
			 TrainingDetailPersoneelDAO.saveTrainingDetail(td);
			 Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Toegevoegd");
				alert.setContentText(d.getFirstname()+" is added to the training "+ td.getTraining().getTrainingNaam());
				alert.setHeaderText(null);
				alert.showAndWait();
		}
	
	}
	
	@FXML
	public void addEmployeesToTraining() throws IOException {
		Employee d=employees.getSelectionModel().getSelectedItem();
		if (d==null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Fout");
			alert.setContentText("False, nothing selected.");
			alert.setHeaderText(null);
			alert.showAndWait();
		}
		else {
		this.setIdemp(d.getId());
		FXMLLoader f = new FXMLLoader(Main.class.getResource("/view/EmployeesToTrainingView.fxml"));
		BorderPane updateTraining= f.load();
		Stage s = new Stage();
		second=s;
		s.setResizable(false);
		s.setTitle("add employee to training");
		s.initModality(Modality.WINDOW_MODAL);
		Scene scene= new Scene(updateTraining);
		s.setScene(scene);
		EmployeestotrController etc = f.getController();
		etc.setLabel(d);
		s.showAndWait();
		}
	}
	private EmployeestotrController etc;
	
	private EmployeeAssignedController etc1;
	public void showAssignedEmployees() throws IOException {
		FXMLLoader f = new FXMLLoader(Main.class.getResource("/view/EmployeeAssigned.fxml"));
		BorderPane updateTraining= f.load();
		Stage s = new Stage();
		second=s;
		s.setResizable(false);
		s.setTitle("Watch employees assigned to a training");
		s.initModality(Modality.WINDOW_MODAL);
		Scene scene= new Scene(updateTraining);
		s.setScene(scene);
		EmployeeAssignedController etc1 = f.getController();
		s.showAndWait();
		
	}
	
	private EmployeeUnboundController etc2;
	
	public void showUnboundEmployees() throws IOException {
		FXMLLoader f = new FXMLLoader(Main.class.getResource("/view/EmployeeUnbound.fxml"));
		BorderPane updateTraining= f.load();
		Stage s = new Stage();
		second=s;
		s.setResizable(false);
		s.setTitle("Watch unassigned employees");
		s.initModality(Modality.WINDOW_MODAL);
		Scene scene= new Scene(updateTraining);
		s.setScene(scene);
		EmployeeUnboundController etc2 = f.getController();
		s.showAndWait();
		
	}
	
	
	
	@FXML
	public void initialize(){
		
		id.setCellValueFactory(new Callback<CellDataFeatures<Employee, Integer>, ObservableValue<Integer>>() {
			@Override
			public ObservableValue<Integer> call(CellDataFeatures<Employee, Integer> data) {
				return new SimpleIntegerProperty(data.getValue().getId()).asObject();
			}
		});
		
	
		
		
		lastname.setCellValueFactory(new Callback<CellDataFeatures<Employee, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Employee, String> data) {
				data.getValue();
				return new SimpleStringProperty(data.getValue().getLastName());
			}
		});
		
		firstname.setCellValueFactory(new Callback<CellDataFeatures<Employee, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Employee, String> data) {
				data.getValue();
				return new SimpleStringProperty(data.getValue().getFirstname());
			}
		});
		
	
		
		ObservableList<Employee> list = FXCollections.observableArrayList(EmployeeOdata.getAllEmployees());
		employees.setItems(list);
		
	//	employees.setItems(get);
		
		
	
		
		
		
		idTraining.setCellValueFactory(new Callback<CellDataFeatures<Training, Integer>, ObservableValue<Integer>>() {
			@Override
			public ObservableValue<Integer> call(CellDataFeatures<Training, Integer> data) {
				return new SimpleIntegerProperty(data.getValue().getIdTraining()).asObject();
			}
		});
		trainingNaam.setCellValueFactory(new Callback<CellDataFeatures<Training, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Training, String> data) {
				data.getValue();
				return new SimpleStringProperty(data.getValue().getTrainingNaam());
			}
		});
		
		
					
			ObservableList<Training> list2 = FXCollections.observableArrayList(TrainingDAO.getall2());
		//	tableTraining.setItems(list2);
			
			FilteredList<Training> filteredData = new FilteredList<>(list2, p -> true);
			filterField.textProperty().addListener((observable, oldValue, newValue) -> {
	            filteredData.setPredicate(td -> {
	                // If filter text is empty, display all persons.
	                if (newValue == null || newValue.isEmpty()) {
	                    return true;
	                }

	                String lowerCaseFilter = newValue.toLowerCase();

	                if (td.getTrainingNaam().toLowerCase().contains(lowerCaseFilter)) {
	                    return true; // Filter matches first name.
	                } 
	                return false; // Does not match.
	            });
	        });

	        // 3. Wrap the FilteredList in a SortedList. 
	        SortedList<Training> sortedData = new SortedList<>(filteredData);

	        // 4. Bind the SortedList comparator to the TableView comparator.
	        sortedData.comparatorProperty().bind(tableTraining.comparatorProperty());

	        // 5. Add sorted (and filtered) data to the table.
	        tableTraining.setItems(sortedData);
	    }
	
	
	
	

	public static int getIdemp() {
		return idemp;
	}

	public static void setIdemp(int idemp) {
		EmployeesController.idemp = idemp;
	}

	public static int getIdemp1() {
		return idemp1;
	}

	public static void setIdemp1(int idemp1) {
		EmployeesController.idemp1 = idemp1;
	}
	
	
	
	
	
	
}
