package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

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
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application{
	private static Stage primaryStage;
	public static Stage addDialogStage;
	public static SessionFactory factory;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("Groep 8 App");
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
	
	public static void PiechartView() throws IOException {
		
		BorderPane addNewtraining= FXMLLoader.load(Main.class.getResource("/view/Piechart.fxml"));
		addDialogStage= new Stage();
		addDialogStage.setResizable(false);
		addDialogStage.setTitle("Add New Training");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		Scene scene= new Scene(addNewtraining);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();
	}
	
	public static void Piechart(String arg, String archiveString, String tabel) throws IOException {
		
		ArrayList<Chartdata> geta = StatisticDAO.getData(arg, archiveString, tabel);
		Scene scene = new Scene(new Group());
		ObservableList<Data> pieChartData = null;
		
		for (int i = 0;i < geta.size();i++) {
			pieChartData = FXCollections.observableArrayList(
	    		new Data(geta.get(i).getAttnaam(),geta.get(i).getAantal()));
			PieChart chart = new PieChart(pieChartData);
			((Group) scene.getRoot()).getChildren().add(chart);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}
	
	public static void OptionView() throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/view/OptionsView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
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
	
	public static void main(String[] args) {
		factory = new Configuration()
				.configure()
				.addAnnotatedClass(Training.class)
				.addAnnotatedClass(TrainingDetail.class)
				.addAnnotatedClass(Adres.class)
				.addAnnotatedClass(Leerkracht.class)
				.buildSessionFactory();
		launch(args);
		factory.close();
	}
	

}