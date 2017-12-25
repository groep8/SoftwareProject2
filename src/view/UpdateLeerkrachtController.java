package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Leerkracht;
import model.Training;

public class UpdateLeerkrachtController {
	
	@FXML
	private Label lab;

	public void setLabel(Leerkracht d) {
		lab.setText("Trainer: "+ d.getVolleNaam());
	}

}
