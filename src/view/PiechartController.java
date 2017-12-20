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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Main;

public class PiechartController {
	@FXML
	private TextField argu;
	
	@FXML
	private TextField table;
	
	@FXML
	private TextField gearchiveerd;
	
	
	public void generatePie() throws SQLException, IOException {
		
		String arg = argu.getText();
		String tabel = table.getText();
		String a = gearchiveerd.getText();
		
		Main.Piechart(arg,a, tabel);
		
	}
	
	 public void cancel() {
		
			Main.addDialogStage.close();
	 }

	public PiechartController() {
		// TODO Auto-generated constructor stub
	}

}
