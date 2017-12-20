package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import controller.MainViewController;
import database.LoginDAO;
import database.TrainingDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import view.LoginController;

public class Main extends Application{
	public static Login currentLogged;
	private static Stage primaryStage;
	public static Stage addDialogStage;
	public static SessionFactory factory;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("Groep 8 App");
		Parent root = FXMLLoader.load(getClass().getResource("/view/Scenelogin.fxml"));
		Scene scene = new Scene(root);
		scene.setRoot(root);
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
	public static void MainAdminView() throws IOException {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/MainAdminView.fxml"));
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
	
	public static void showBackupPosView() throws IOException {
		BorderPane addNewtraining= FXMLLoader.load(Main.class.getResource("/view/DBBackUpView.fxml"));
		addDialogStage= new Stage();
		addDialogStage.setResizable(false);
		addDialogStage.setTitle("Backup Options");
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
				.addAnnotatedClass(Login.class)
				.addAnnotatedClass(Personeel.class)
				.buildSessionFactory();
		launch(args);
		factory.close();
	}
	

}