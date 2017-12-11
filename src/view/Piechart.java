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
import model.Chartdata;
import model.Main;

public class Piechart {
	@FXML
	private TextField argu;
	
	@FXML
	private TextField table;
	
	@FXML
	public TextField archive;
	
	public void generatePie() throws SQLException, IOException {
		
		String arg = argu.getText();
		String tabel = table.getText();
		String archiveString = archive.getText();
		Main.Piechart(arg,archiveString,tabel);
		
	}
	
	 public void cancel() {
		
			Main.addDialogStage.close();
	 }

	public Piechart() {
		// TODO Auto-generated constructor stub
	}

}
