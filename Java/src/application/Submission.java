// ************************************************************************************************************
// Submission.java						Author: Jake Byford								Spring 2021
//
// CS 631850                        	Database Management Systems						ID: 31556607
// 
// Create a user database for New Jersey Institute of Technology
//
// ************************************************************************************************************
package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Submission extends Controller implements Initializable{

    public static String fname;

	@FXML
    private TableView<students> tableSubmission;
    
    @FXML
    private TableColumn<students, String> colUser;

    @FXML
    private TableColumn<students, String> colFname;

    @FXML
    private TableColumn<students, String> colLname;

    @FXML
    private TableColumn<students, String> colCourseCode2;

    @FXML
    private TableColumn<students, String> colSectionCode2;

    @FXML
    private TableColumn<students, String> colCourseName2;

    @FXML
    private TableColumn<students, String> colInstructor2;
    
    @FXML
    private Label classScheduleLabel;

    @FXML
    private Label nameLabel;
    
    @FXML
    private TableView<sectionList> sectionRoster;

    @FXML
    private TableColumn<sectionList, String> rosterColCC;

    @FXML
    private TableColumn<sectionList, String> rosterColSC;

    @FXML
    private TableColumn<sectionList, String> rosterColCN;

    @FXML
    private TableColumn<sectionList, String> rosterColTime;

    @FXML
    private TableColumn<sectionList, String> rosterColPlace;

    @FXML
    private TableColumn<sectionList, String> rosterColWeekdays;

    @FXML
    private TableColumn<sectionList, String> rosterColInstructor;

    @FXML
    private TableColumn<sectionList, String> rosterColUser;

    @FXML
    private TableColumn<sectionList, String> rosterColFname;

    @FXML
    private TableColumn<sectionList, String> rosterColLname;

    @FXML
    private TableColumn<sectionList, String> rosterColMajor;

    @FXML
    private TableColumn<sectionList, String> rosterColYear;
	
    ObservableList<students> listQ = FXCollections.observableArrayList();
    ObservableList<sectionList> listS = FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		updateTable();
		rosterTable();
	}
	
	public void updateTable() 
	{
		colUser.setCellValueFactory(new PropertyValueFactory<students, String>("user"));
		colFname.setCellValueFactory(new PropertyValueFactory<students, String>("fname"));
		colLname.setCellValueFactory(new PropertyValueFactory<students, String>("lname"));
		colCourseCode2.setCellValueFactory(new PropertyValueFactory<students, String>("course_code"));
		colSectionCode2.setCellValueFactory(new PropertyValueFactory<students, String>("section_code"));
		colCourseName2.setCellValueFactory(new PropertyValueFactory<students, String>("course_name"));
		colInstructor2.setCellValueFactory(new PropertyValueFactory<students, String>("instructor"));
		
		listQ = RegisterController.getRegisteredClasses();
		tableSubmission.setItems(listQ);
		nameLabel.setText(fname + "\'s");
	}
	
	public void rosterTable() 
	{
		rosterColCC.setCellValueFactory(new PropertyValueFactory<sectionList, String>("course_code"));
		rosterColSC.setCellValueFactory(new PropertyValueFactory<sectionList, String>("section_code"));
		rosterColCN.setCellValueFactory(new PropertyValueFactory<sectionList, String>("course_name"));
		rosterColTime.setCellValueFactory(new PropertyValueFactory<sectionList, String>("time"));
		rosterColPlace.setCellValueFactory(new PropertyValueFactory<sectionList, String>("place"));
		rosterColWeekdays.setCellValueFactory(new PropertyValueFactory<sectionList, String>("weekdays"));
		rosterColInstructor.setCellValueFactory(new PropertyValueFactory<sectionList, String>("instructor"));
		rosterColUser.setCellValueFactory(new PropertyValueFactory<sectionList, String>("user"));
		rosterColFname.setCellValueFactory(new PropertyValueFactory<sectionList, String>("fname"));
		rosterColLname.setCellValueFactory(new PropertyValueFactory<sectionList, String>("lname"));
		rosterColMajor.setCellValueFactory(new PropertyValueFactory<sectionList, String>("major"));
		rosterColYear.setCellValueFactory(new PropertyValueFactory<sectionList, String>("year"));
		
		listS = RegisterController.getSectionList();
		sectionRoster.setItems(listS);
	}
	
	public void switchToRegistrationPage(ActionEvent event) throws IOException {
	try {
		Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
		Stage submissionStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);

		
		Image icon = new Image("njit-logo.png");
		submissionStage.getIcons().add(icon); 
		submissionStage.setTitle("NJIT University");

		
		submissionStage.setScene(scene);
		submissionStage.show();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
//	public static void main(String[] args) {
//
//			DatabaseConnection connectNow = new DatabaseConnection();
//			Connection connectDB = connectNow.getConnection();
//			
//			String foundType = "";
//			int endType = 0;
//			
//			PreparedStatement ps;
//			try {
//				ps = connectDB.prepareStatement("select count(section_code) from fall where section_code = ?");
//				ps.setString(1, tableQueue.getItems().get(0).sectionCode);
//				ResultSet rs = ps.executeQuery();
//				
//				if(rs.next())
//				foundType = rs.getString("count(section_code)");
//				endType = Integer.parseInt(foundType);
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
//	
//	private int currentEnrollment() {
//		
//		return 0;
//	}
//	
//	private void spaceAvailable() {
//		try {
//			
//			PreparedStatement ps = connectDB.prepareStatement("SELECT fname, lname "
//															+ "FROM `member` "
//															+ "WHERE user = " + uname);
//			ResultSet rs = ps.executeQuery();
//			
//			int currEnrolled = rs.getInt("curr_enroll");
//			int maxEnrolled = rs.getInt("max_enroll");
//			
//		if(currEnrolled >= maxEnrolled) {
//			Alert alert = new Alert(AlertType.CONFIRMATION);
//			alert.setTitle("Login");
//			alert.setHeaderText("You are about to cancel!");
//			alert.setContentText("Are you sure you want to continue?");
//			
//			alert.showAndWait();
//		}
//		else {
//			currEnrolled += 1;
//			registerStudent();
//		}
//	}
//	
//	private void registerStudent() {
//			if(studnetNumClasses < 5) {
//				System.out.print("You signed up for the maximum amount of credits. Please remove a class.");
//			}
//			else if ()
//				
//			else {
//				ps = connectDB.prepareStatement("insert into member (fname, "
//																   + "lname, "
//																   + "values (Jake, Byford)");
////				ps.setString(1, tableQueue.getItems().get(0).sectionCode);
//				ResultSet rs = ps.executeQuery();
//				
//				
//				currentEnrollment += 1;
//				this.studentNumClasses += 1
//			}
//		}
//		
////		SELECT user, fname, lname, course_code, section_code, instructor FROM `member` NATURAL JOIN fall;
//	}
//	
//	
//	
//	String uname = Controller.usernameField.getText();
//	String password = passwordField.getText();
//	
//	try {
//		PreparedStatement ps = connectDB.prepareStatement("SELECT * FROM member WHERE user = ? AND password = ?");
//		ps.setString(1,  uname);
//		ps.setString(2, password);
//		ResultSet rs = ps.executeQuery();
//		
//			if (rs.next()) {
//				loginMessageLabel.setText("Congratulations!");
//				
//			}
//			else {
//				loginMessageLabel.setText("Invalid login. Please try again");
//			}
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//		e.getCause();
//	}
//	
//	
//	
//	
//	public static ObservableList<users> getStudentsData() 
//	{
//		DatabaseConnection connectNow = new DatabaseConnection();
//		Connection connectDB = connectNow.getConnection();
//		
//		String uname = usernameField.getText();
////		SELECT user, fname, lname, course_code, section_code, course_name, instructor FROM `member` NATURAL JOIN fall WHERE user = 'Student1';
//		
//		ObservableList<students> list = FXCollections.observableArrayList();
//		try {
//			PreparedStatement ps = connectDB.prepareStatement("SELECT user, fname, lname, course_code, section_code, course_name, instructor "
//															+ "FROM `member` "
//															+ "NATURAL JOIN fall "
//															+ "WHERE user = " + uname);
//			ResultSet rs = ps.executeQuery();
//			
//			while (rs.next()) {
//				list.add(new users(rs.getString("user"), 
//								   rs.getString("fname"), 
//								   rs.getString("lname"),
//						           rs.getString("course_code"),
//					      		   rs.getString("section_code"),
//					      		   rs.getString("course_name"),
//				           		   rs.getString("instructor")));
//			}
//		}catch (Exception e) {
//				e.printStackTrace();
//			}
//		
//		
//		return list;
//	}
//	
//	public ObservableList<students> getSelectedRow() 
//	{
//		String uname = usernameField.getText();
//		try {
//			
//			PreparedStatement ps = connectDB.prepareStatement("SELECT fname, lname "
//															+ "FROM `member` "
//															+ "WHERE user = " + uname);
//			ResultSet rs = ps.executeQuery();
//			
//			String fname = 	rs.getString("fname"); 
//			String lname =  rs.getString("lname");
//			
//			
//			listF.add(new students(uname,
//					           fname,
//					           lname,
//					           tableSubmission.getSelectionModel().getSelectedItem().getCourseCode(),
//					           tableQueue.getSelectionModel().getSelectedItem().getSectionCode(),
//					           tableQueue.getSelectionModel().getSelectedItem().getCourseName(),
//					           tableQueue.getSelectionModel().getSelectedItem().getInstructor(),
//					           tableQueue.getSelectionModel().getSelectedItem().getCurrEnrolled(),
//					           tableQueue.getSelectionModel().getSelectedItem().getMaxEnrolled()));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		return listF;
//	}

