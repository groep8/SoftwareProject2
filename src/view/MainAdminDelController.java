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
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;
import model.Login;
import model.Main;

public class MainAdminDelController {

    @FXML
    private TableView<Login> tableView2;

    @FXML
    private TableColumn<Login, Integer> idLogin;

    @FXML
    private TableColumn<Login, String> username;

    @FXML
    private TableColumn<Login, String> password;

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
				 ObservableList<Login> list = FXCollections.observableArrayList(LoginDAO.getAllArch());
				 tableView2.setItems(list);
		}

    @FXML
    void goAdmin(ActionEvent event) throws IOException {
    }

    @FXML
    void goBack(ActionEvent event) throws IOException {
    	Main.MainAdminView();
    }

    @FXML
    void goEmployees(ActionEvent event) throws IOException {
    	Main.EmployeesView();
    }

    @FXML
    void goHome(ActionEvent event) throws IOException {
    	Main.mainView();
    }

    @FXML
    void goStatistic(ActionEvent event) throws IOException {
    	Main.StatisticView();
    }

    @FXML
    void goTraining(ActionEvent event) throws IOException {
    	Main.TrainingView();
    }



    @FXML
    void undelUser(ActionEvent event) throws IOException {
    	Login l = tableView2.getSelectionModel().getSelectedItem();
    	if(l == null)
    		LoginController.alert("ERROR: Nothing selected", "No user has been selected.", AlertType.ERROR);
    	else {
    		LoginDAO.undelUser(l.getIdLogin());
    		Main.MainAdminView();
    	}
    }

}
