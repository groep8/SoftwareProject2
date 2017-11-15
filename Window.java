package logic;

import javafx.application.Application;
import javafx.geometry.Insets;
//import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
//import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Window extends Application {
	Stage WindowStage;
	Scene WindowScene;
	
	@Override
	public void start(Stage primeStage) throws Exception {
		WindowStage = primeStage;
		WindowStage.setTitle("Graphs");
		Label graph1 = new Label();
		graph1.setText("Graph:");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		GridPane.setConstraints(graph1, 4, 4);
		grid.getChildren().addAll(graph1);
		WindowScene = new Scene(grid, 800, 600);
		WindowStage.setScene(WindowScene);
		
		WindowStage.setOnCloseRequest(e -> {
			e.consume();
			close();
		});
		WindowStage.show();
		
	}
	private void close() {
		Boolean sureExit = ConfirmBox.display("Exit", "Are you sure you want to exit the program?");
		if(sureExit == true) {
			WindowStage.close();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}

}
