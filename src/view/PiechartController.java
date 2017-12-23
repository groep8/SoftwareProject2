package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import database.StatisticDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Main;

public class PiechartController {
	
	@FXML
	private ComboBox<String> argu;

	@FXML
	private ComboBox<String> table;


	@FXML
	private ComboBox<String> gearchiveerd;

	@FXML
	private void initialize() {
		gearchiveerd.getItems().setAll("nee", "ja", "alles");
		table.getItems().setAll("Adres","Employee","Leerkracht","Training","TrainingDetail");
		table.setOnAction((e) ->{
			if (!(table.getSelectionModel().getSelectedItem().equals("Employee"))) {
			ObservableList<String> adreslist = FXCollections.observableArrayList(StatisticDAO.getTable(table.getSelectionModel().getSelectedItem()));
			argu.setItems(adreslist);
			}else {
				argu.getItems().setAll("EmployeeID","LastName","FirstName","Title","TitleOfCourtesy","BirthDate","HireDate");
			}
			});
			
	}

	public void generatePie() throws SQLException, IOException {
		
		String arg = argu.getSelectionModel().getSelectedItem();
		String tabel = table.getSelectionModel().getSelectedItem();
		String a = gearchiveerd.getSelectionModel().getSelectedItem();
		if (a.equals("nee")){
			a = "!=";
		}
		else if (a.equals("ja")) {
			a = "=";
		}
		else {
			a = "<=";
		}
		Main.Piechart(arg,a, tabel);
		
	}
	
	 public void cancel() {
		
			Main.addDialogStage.close();
	 }

	public PiechartController() {
		// TODO Auto-generated constructor stub
	}

}
