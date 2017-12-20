package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Training;

public class GoogleMapsController {
	@FXML
	public ImageView image;
	@FXML
	private Label l;
	
	public void setLabel(Training d) {
		l.setText("Adres: "+ d.getAdres().getStraat()+"  "+ d.getAdres().getHuisnum()  + " , "+d.getAdres().getPostcode()+" , "+ d.getAdres().getStad()+" , "+d.getAdres().getLand());
	}
	
	
	/*public void Button() {
		String search = text.getText();
		int width =(int) image.getFitWidth();
		int height =(int) image.getFitHeight();
		Image view = new Image("https://maps.googleapis.com/maps/api/staticmap?"
				+ "&center=" + search
				+ "&size=" + width + "x" + height
				+ "&markers=color:red%7Clabel:A%7C" + search
				+ "&key=AIzaSyAFZfKqbxm-h9xreg-qGcu9K4jlGWPyfcI");

		image.setImage(view);
	
	}*/
	public void initialize() {
		TrainingController t= new TrainingController();
		String search = t.getStr();
		int width =(int) image.getFitWidth();
		int height =(int) image.getFitHeight();
		Image view = new Image("https://maps.googleapis.com/maps/api/staticmap?"
				+ "&center=" + search
				+ "&size=" + width + "x" + height
				+ "&markers=color:red%7Clabel:A%7C" + search
				+ "&key=AIzaSyAFZfKqbxm-h9xreg-qGcu9K4jlGWPyfcI");

		image.setImage(view);
		//String adres="Europe";
		//int width =(int) image.getFitWidth();
		//int height =(int) image.getFitHeight();
		
		/*Image view = new Image("https://maps.googleapis.com/maps/api/staticmap?"
				+ "&center=" + adres*/
				//+ "&size=" + width + "x" + height
				/*+ "&markers=color:red%7Clabel:A%7C" + query*/
				//+ "&key=AIzaSyAFZfKqbxm-h9xreg-qGcu9K4jlGWPyfcI");
	
		//image.setImage(view);
	}

}
