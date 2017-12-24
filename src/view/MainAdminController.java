package view;

import java.io.IOException;

import database.LoginDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.util.Callback;
import model.Login;
import model.Main;
import model.Personeel;
import model.TrainingDetail;

public class MainAdminController {
	 @FXML 
	 private TableView<Login> tableView;
	 @FXML 
	 private TableColumn<Login, Integer> idLogin;
	 @FXML
	 private TableColumn<Login, Integer> personeel;
	 @FXML
	 private TableColumn<Login,String> username;
	 @FXML 
	 private TableColumn<Login, String>  password;
	 @FXML
	 private TableColumn<Login, String> isAdmin;
	 
	 @FXML
	 public void initialize() {
			 idLogin.setCellValueFactory(new Callback<CellDataFeatures<Login, Integer>, ObservableValue<Integer>>(){
					@Override
					public ObservableValue<Integer> call(CellDataFeatures<Login, Integer> data) {
						return new SimpleIntegerProperty(data.getValue().getIdLogin()).asObject();
					}
				 });
				 personeel.setCellValueFactory(new Callback<CellDataFeatures<Login,Integer>, ObservableValue<Integer>>(){
					@Override
					public ObservableValue<Integer> call(CellDataFeatures<Login, Integer> data) {
						return new SimpleIntegerProperty(data.getValue().getPersoneel().getIdPersoneel()).asObject();
					}	 
				 });
				 username.setCellValueFactory(new Callback<CellDataFeatures<Login, String>, ObservableValue<String>>(){
					@Override
					public ObservableValue<String> call(CellDataFeatures<Login, String> data) {
						return new SimpleStringProperty(data.getValue().getUsername());
					}
				 });
				 password.setCellValueFactory(new Callback<CellDataFeatures<Login,String>, ObservableValue<String>>(){
					@Override
					public ObservableValue<String> call(CellDataFeatures<Login, String> data) {
						return new SimpleStringProperty(data.getValue().getPassword());
					}	 
				 });
				 isAdmin.setCellValueFactory(new Callback<CellDataFeatures<Login,String>, ObservableValue<String>>(){
						@Override
						public ObservableValue<String> call(CellDataFeatures<Login, String> data) {
							return new SimpleStringProperty(data.getValue().stringAdmin());
						}	 
				 });
				 ObservableList<Login> list = FXCollections.observableArrayList(LoginDAO.getAll());
				 tableView.setItems(list);
		}

    @FXML
    private void goEmployees(ActionEvent event) throws IOException{
    	Main.EmployeesView();
    }

    @FXML
    private void goHome(ActionEvent event) throws IOException{
    	Main.mainView();
    }

//    @FXML
//    private void goOptions(ActionEvent event) throws IOException{
//    	Main.OptionView();
//    }

    @FXML
    private void goStatistic(ActionEvent event) throws IOException{
    	Main.StatisticView();
    }

    @FXML
    private void goTraining(ActionEvent event) throws IOException{
    	Main.TrainingView();
    }
    @FXML
	private void goAdmin(ActionEvent event) throws IOException {
    	if(Main.currentLogged.isAdmin()) {
			Main.MainAdminView();
		}
		else {
			LoginController.alert("ERROR: Can't load this information.", "You do not have sufficient privileges to load this information.", AlertType.ERROR);
		}
	}
    @FXML
    void showBackupPosView(ActionEvent event) throws IOException {
    	Main.showBackupPosView();
    }
//    @FXML
//    void modUser(ActionEvent event) throws IOException {
//    	Login l = tableView.getSelectionModel().getSelectedItem();
//    	if(l == null) {
//    		LoginController.alert("ERROR: Nothing selected", "No user has been selected.", AlertType.ERROR);
//    	}
//    	else {
//    		Main.goAddUser();
//    	}
//    }
    @FXML
    void addUser(ActionEvent event) throws IOException {
    	Main.goAddUser();
    }
}
