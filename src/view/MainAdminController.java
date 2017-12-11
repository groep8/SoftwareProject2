package view;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import model.Main;

public class MainAdminController {

    @FXML
    void goEmployees(ActionEvent event) throws IOException{
    	Main.EmployeesView();
    }

    @FXML
    void goHome(ActionEvent event) throws IOException{
    	Main.mainView();
    }

    @FXML
    void goOptions(ActionEvent event) throws IOException{
    	Main.OptionView();
    }

    @FXML
    void goStatistic(ActionEvent event) throws IOException{
    	Main.StatisticView();
    }

    @FXML
    void goTraining(ActionEvent event) throws IOException{
    	Main.TrainingView();
    }

}
