package model;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import database.StatisticDAO;
import database.TrainingDAO;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application{
	private static Stage primaryStage;
	public static Stage addDialogStage;
	public static Stage addDialogStage2;
	public static SessionFactory factory;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("Groep 8 Application");
		Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);


	}

	public static void mainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/MainView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void TrainingView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/TrainingView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void EmployeesView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/EmployeesView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void StatisticView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/StatisticView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void OptionView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/OptionsView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void PiechartView() throws IOException {	
		BorderPane addNewPie= FXMLLoader.load(Main.class.getResource("/view/Piechart.fxml"));
		addDialogStage= new Stage();
		addDialogStage.setResizable(false);
		addDialogStage.setTitle("Generate Piechart");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene= new Scene(addNewPie);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();
	}

	public static void LinechartView() throws IOException {
		BorderPane addNewLine= FXMLLoader.load(Main.class.getResource("/view/Linechart.fxml"));
		addDialogStage= new Stage();
		addDialogStage.setResizable(false);
		addDialogStage.setTitle("Generate Linechart");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene= new Scene(addNewLine);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();

	}

	public static void BarchartView() throws IOException {
		BorderPane addNewLine= FXMLLoader.load(Main.class.getResource("/view/Barchart.fxml"));
		addDialogStage= new Stage();
		addDialogStage.setResizable(false);
		addDialogStage.setTitle("Generate Barchart");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene= new Scene(addNewLine);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void Barchart(String arg, String a, String tabel, String ja, String verg) throws IOException {
		List <Object[]> geta = null;
		geta = StatisticDAO.getBarData(arg, a,tabel, ja);
		if (geta != null) {
			final CategoryAxis xAxis = new CategoryAxis();
			final NumberAxis yAxis = new NumberAxis();
			xAxis.setLabel(arg);
			final BarChart<String,Number> barChart = new BarChart<String,Number>(xAxis,yAxis);
			XYChart.Series series1 = new XYChart.Series();
			series1.setName(ja);
			for(Object[] obj : geta){
				String attnaam = String.valueOf(obj[0]);
				String aantal = String.valueOf(obj[1]);
				int foo = Integer.parseInt(aantal);
				series1.getData().add(new XYChart.Data(attnaam, foo));
			}	
			Scene scene = new Scene(barChart);
			barChart.getData().add(series1);
			if (!(verg.equals("nee"))) {
				XYChart.Series series2 = new XYChart.Series();
				series2.setName(verg);
				geta = StatisticDAO.getLineData(arg, a,tabel, verg);
				for(Object[] obj : geta){
					String attnaam = String.valueOf(obj[0]);
					String aantal = String.valueOf(obj[1]);
					int foo = Integer.parseInt(aantal);
					series2.getData().add(new XYChart.Data(attnaam, foo));
				}
				barChart.getData().add(series2);
			}
			addDialogStage2= new Stage();
			addDialogStage2.setResizable(false);
			addDialogStage2.setTitle("Barchart");
			addDialogStage2.initModality(Modality.WINDOW_MODAL);
			addDialogStage2.initOwner(primaryStage);
			addDialogStage2.setScene(scene);
			addDialogStage2.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation");
			alert.setContentText("Error, er is geen data die correspondeert aand wat u heeft geselecteerd");
			alert.setHeaderText(null);
			alert.showAndWait();
		}
	}

	@SuppressWarnings("unchecked")
	public static void Piechart(String arg, String archiveString, String tabel) throws IOException {
		Scene scene = new Scene(new Group());
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		if (tabel.equals("Employee")) {
			List <String[]> za = Odataselect.odatasel(arg);
			for (int i = 0;i < za.size();i++) {
				String naam = null;
				naam = String.valueOf(za.get(i));
				Data e = new PieChart.Data(naam,1);
				pieChartData.add(e);
//				if (i%2 == 0) {
//					naam = String.valueOf(za.get(i));
//				} else {
//					String foo = String.valueOf(za.get(i));
//					int aant = Integer.parseInt(foo);
//					Data e = new PieChart.Data(naam,i);
//					pieChartData.add(e);
//				}
			}
		} else {	
			List <Object[]> geta = null;
			geta = StatisticDAO.getPieData(arg, archiveString,tabel);
			for(Object[] obj : geta){
				String attnaam = String.valueOf(obj[0]);
				String aantal = String.valueOf(obj[1]);
				int foo = Integer.parseInt(aantal);
				Data e = new PieChart.Data(attnaam,foo);
				pieChartData.add(e);
			}
		}
		PieChart chart = new PieChart(pieChartData);
		((Group) scene.getRoot()).getChildren().add(chart);
		addDialogStage2= new Stage();
		addDialogStage2.setResizable(false);
		addDialogStage2.setTitle("Piechart");
		addDialogStage2.initModality(Modality.WINDOW_MODAL);
		addDialogStage2.initOwner(primaryStage);
		addDialogStage2.setScene(scene);
		addDialogStage2.showAndWait();


	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void Linechart(String arg, String a, String tabel, String ja, String verg) throws IOException {
		List <Object[]> geta = null;
		geta = StatisticDAO.getLineData(arg, a,tabel, ja);
		if (geta != null) {
			final CategoryAxis xAxis = new CategoryAxis();
			final NumberAxis yAxis = new NumberAxis();
			xAxis.setLabel(arg);
			final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
			XYChart.Series series1 = new XYChart.Series();
			series1.setName(ja);
			for(Object[] obj : geta){
				String attnaam = String.valueOf(obj[0]);
				String aantal = String.valueOf(obj[1]);
				int foo = Integer.parseInt(aantal);
				series1.getData().add(new XYChart.Data(attnaam, foo));
			}
			lineChart.getData().add(series1);
			if (!(verg.equals("nee"))) {
				XYChart.Series series2 = new XYChart.Series();
				series2.setName(verg);
				geta = StatisticDAO.getLineData(arg, a,tabel, verg);
				for(Object[] obj : geta){
					String attnaam = String.valueOf(obj[0]);
					String aantal = String.valueOf(obj[1]);
					int foo = Integer.parseInt(aantal);
					series2.getData().add(new XYChart.Data(attnaam, foo));
				}
				lineChart.getData().add(series2);
			}
			Scene scene = new Scene(lineChart);
			addDialogStage2= new Stage();
			addDialogStage2.setResizable(false);
			addDialogStage2.setTitle("Linechart");
			addDialogStage2.initModality(Modality.WINDOW_MODAL);
			addDialogStage2.initOwner(primaryStage);
			addDialogStage2.setScene(scene);
			addDialogStage2.showAndWait();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Confirmation");
			alert.setContentText("Error, er is geen data die correspondeert aand wat u heeft geselecteerd");
			alert.setHeaderText(null);
			alert.showAndWait();
		}
	}

	public static void showAddStage() throws IOException {

		BorderPane addNewtraining= FXMLLoader.load(Main.class.getResource("/view/addNewTraining.fxml"));
		addDialogStage= new Stage();
		addDialogStage.setResizable(false);
		addDialogStage.setTitle("Add New Training");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene= new Scene(addNewtraining);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();
	}

	public static void showUpdateStageName() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/UpdateName.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void BookView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/BookView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void DeleteView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/DeleteTrainingView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void LeerkrachtView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/LeerkrachtView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void AdresView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/AdresView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void addLeerkrachtView() throws IOException {

		BorderPane addNewtraining= FXMLLoader.load(Main.class.getResource("/view/addNewLeerkrachtView.fxml"));
		addDialogStage= new Stage();
		addDialogStage.setResizable(false);
		addDialogStage.setTitle("Add New Trainer");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene= new Scene(addNewtraining);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();
	}

	public static void DeleteLeerkrachtView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/Leerkrachtdelete.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		factory = new Configuration()
				.configure()
				.addAnnotatedClass(Training.class)
				.addAnnotatedClass(TrainingDetail.class)
				.addAnnotatedClass(Adres.class)
				.addAnnotatedClass(Leerkracht.class)
				.addAnnotatedClass(Personeel.class)
				.addAnnotatedClass(Login.class)
				.buildSessionFactory();
		launch(args);
		factory.close();
	}








}