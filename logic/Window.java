package logic;

import java.awt.event.MouseEvent;
import java.util.function.LongToDoubleFunction;

import javax.swing.plaf.synth.SynthSeparatorUI;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
//import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
//import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Window extends Application {
	private Stage WindowStage;
	private Scene WindowScene;
	private Login log;
	
	@Override
	public void start(Stage primeStage) throws Exception {
		WindowStage = primeStage;
		WindowStage.setTitle("Login to the program.");
		log = new Login();
		//create "Enter username"
		Label name = new Label();
		name.setText("Username:");
		
		TextField userName = new TextField();
		//create "Enter pass"
		Label pass = new Label();
		pass.setText("Password:");
		PasswordField userPass = new PasswordField();
		userPass.setPromptText("Enter your password");
		//create log in button to accept creditentials
		Button loginB = new Button("Log in");
		
		//adding grid
		GridPane grid = new GridPane();
		//setting grid up/		
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		//putting putting elements inside the grid (position!)
		GridPane.setConstraints(name, 4, 4);
     	GridPane.setConstraints(userName, 5, 4);
		GridPane.setConstraints(pass,4 ,5);
		GridPane.setConstraints(userPass, 5,5);
		GridPane.setConstraints(loginB, 5,6);
		//add actual elements to the grid 
		grid.getChildren().addAll(name, userName, pass, userPass, loginB);
		WindowScene = new Scene(grid, 800, 600);
		WindowStage.setScene(WindowScene);
		
		WindowStage.setOnCloseRequest(e -> {
			e.consume();
			close();
		});
		loginB.setOnAction(e -> {

			log.setPassword(userPass.getText());
			log.setUsername(userName.getText());
			DAOFactory df = DAOFactory.getInstance();
			LoginDAOimpl daoLog = df.getLoginDAO();
			Login temp = daoLog.getLogin(log.getUsername());
			
			//Quick fix
			Label logL = new Label("Ingegeven door user: " + log.toString());
			Label logTempL = new Label("Info van de database: " + temp.toString());
			GridPane.setConstraints(logL, 7,7);
			GridPane.setConstraints(logTempL, 7,8);
			grid.getChildren().addAll(logL, logTempL);
			//System.out.println(log.toString());
			//System.out.println(temp.toString());
			//SLimmer sql eerst opvragen van users sjonas
		});
		
		WindowStage.show();
		
	}
	private void close() {
		boolean sureExit = ConfirmBox.display("Exit", "Are you sure you want to exit the program?");
		if(sureExit == true) {
			WindowStage.close();
		}
	}
	public static void main(String[] args) {
		launch(args);
		
	}

	
}