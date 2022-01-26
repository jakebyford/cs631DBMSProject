// ************************************************************************************************************
// Controller.java							Author: Jake Byford								Spring 2021
//
// CS 631850                        	Database Management Systems						ID: 31556607
// 
// Create a user database for New Jersey Institute of Technology
//
// ************************************************************************************************************
package application;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import java.util.*;

public class Controller {

	
	@FXML
    private Button loginButton;

    @FXML
	private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button cancelButton;

    @FXML
    private Label loginMessageLabel;
    

    
	
	public void loginButtonOnAction(ActionEvent event)
	{	
		if (usernameField.getText().isBlank() == false && passwordField.getText().isBlank() == false) {
			validateLogin();
//			Stage stage = (Stage) cancelButton.getScene().getWindow();
//			stage.close();
			createRegisterSearch();
		} else {
			loginMessageLabel.setText("Please enter username and password");
		}
	}
	
	
	public void cancelButtonOnAction(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Login");
		alert.setHeaderText("You are about to cancel!");
		alert.setContentText("Are you sure you want to continue?");
		
		if (alert.showAndWait().get() == ButtonType.OK) {
			Stage stage = (Stage) cancelButton.getScene().getWindow();
			stage.close();
		}
	}
	
	public void validateLogin() {
		DatabaseConnection connectNow = new DatabaseConnection();
		Connection connectDB = connectNow.getConnection();
			
		String uname = usernameField.getText();
		String password = passwordField.getText();
		
		try {
			PreparedStatement ps = connectDB.prepareStatement("SELECT * FROM member WHERE user = ? AND password = ?");
			ps.setString(1,  uname);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			
				if (rs.next()) {
					RegisterController.username = uname;
					
					String fname = rs.getString("fname");
					Submission.fname = fname;
					
					loginMessageLabel.setText("Congratulations!");
					
				}
				else {
					loginMessageLabel.setText("Invalid login. Please try again");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
	
	public void createRegisterSearch() {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
			Stage registerStage = new Stage();
			Scene scene = new Scene(root);
			
			Image icon = new Image("njit-logo.png");
			registerStage.getIcons().add(icon);
			registerStage.setTitle("NJIT University");

			
			registerStage.setScene(scene);
			registerStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
	
	
//	public ObservableList<String> getUsername() 
//	{
//		DatabaseConnection connectNow = new DatabaseConnection();
//		Connection connectDB = connectNow.getConnection();
//		
//		ObservableList<String> list = FXCollections.observableArrayList();
//		try {
//			PreparedStatement ps = connectDB.prepareStatement("select user from member where user = " + usernameField.getText());
//			ResultSet rs = ps.executeQuery();
//			
//			while (rs.next()) {
//				list.add(rs.getString("user"));
//			}
//		}catch (Exception e) {
//				e.printStackTrace();
//			}
//		
//		return list;
//		}
//	}


