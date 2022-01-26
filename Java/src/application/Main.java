// ************************************************************************************************************
// Main.java							Author: Jake Byford								Spring 2021
//
// CS 631850                        	Database Management Systems						ID: 31556607
// 
// Create a user database for New Jersey Institute of Technology
//
// ************************************************************************************************************
package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		try {
//		Say Stage stage in the start parameter was (Stage primaryStage), 
//		you could add a new stage object as shown directly below

//		Stage stage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
		Scene scene = new Scene(root);
//		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		Image icon = new Image("njit-logo.png");
		stage.getIcons().add(icon);
		stage.setTitle("NJIT University");
//		stage.setWidth(420);
//		stage.setHeight(420);
		
		
		
		stage.setScene(scene);
		stage.show();
		
		stage.setOnCloseRequest(event -> {
			event.consume();
			cancelButtonOnAction(stage);
			});
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cancelButtonOnAction(Stage stage)
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Login");
		alert.setHeaderText("You are about to cancel!");
		alert.setContentText("Are you sure you want to continue?");
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			stage.close();
		}
	}
}
