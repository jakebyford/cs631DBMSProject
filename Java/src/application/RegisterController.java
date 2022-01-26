// ************************************************************************************************************
// RegisterController.java							Author: Jake Byford								Spring 2021
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class RegisterController extends Controller implements Initializable {

	public Controller mainController;
	@FXML
    private TextField courseCodeTextField;

    @FXML
    private TextField courseTimeTextField;

    @FXML
    private TextField sectionNumTextField;

    @FXML
    private Button sectionSearchButton;

    @FXML
    private Button courseSearchButton;

    @FXML
    private Label courseMessageLabel;

    @FXML
    private Label sectionMessageLabel;
    
    @FXML
    private Label addSelectedRowLabel;
    
    @FXML
    private TableView<users> tableCourses;

    @FXML
    private TableColumn<users, String> colCourseCode;

    @FXML
    private TableColumn<users, String> colSectionCode;

    @FXML
    private TableColumn<users, String> colCourseName;

    @FXML
    private TableColumn<users, String> colTime;

    @FXML
    private TableColumn<users, String> colPlace;

    @FXML
    private TableColumn<users, String> colWeekdays;

    @FXML
    private TableColumn<users, String> colInstructor;
    
    @FXML
    private TableColumn<users, Integer> colCurrEnroll;

    @FXML
    private TableColumn<users, Integer> colMaxEnroll;
    
    @FXML
    private TableView<users> tableQueue;

    @FXML
    private TableColumn<users, String> colCourseCode1;

    @FXML
    private TableColumn<users, String> colSectionCode1;

    @FXML
    private TableColumn<users, String> colCourseName1;

    @FXML
    private TableColumn<users, String> colTime1;

    @FXML
    private TableColumn<users, String> colPlace1;

    @FXML
    private TableColumn<users, String> colWeekdays1;

    @FXML
    private TableColumn<users, String> colInstructor1;
    
    @FXML
    private TableColumn<users, Integer> colCurrEnroll1;

    @FXML
    private TableColumn<users, Integer> colMaxEnroll1;
    
    
    ObservableList<users> listM;
    ObservableList<users> listF = FXCollections.observableArrayList();
    static ObservableList<users> listQ = FXCollections.observableArrayList();
    
	public static String username ="";
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		updateTable();
	}
    
	public void courseButtonOnAction(ActionEvent event)
	{	
		if (courseCodeTextField.getText().isBlank() == false && courseTimeTextField.getText().isBlank() == false) {
			validateCourseSearch();
		} else {
			courseMessageLabel.setText("Please enter course code and time");
		}
	}
	
	public void sectionButtonOnAction(ActionEvent event)
	{	
		if (sectionNumTextField.getText().isBlank() == false) {
			validateSectionSearch();
		} else {
			sectionMessageLabel.setText("Please enter section number");
		}
	}
	
	public void searchAllButtonOnAction(ActionEvent event)
	{	
		updateTable();
	}

	public void validateCourseSearch() 
	{
		try {
			
			colCourseCode.setCellValueFactory(new PropertyValueFactory<users, String>("courseCode"));
			colSectionCode.setCellValueFactory(new PropertyValueFactory<users, String>("sectionCode"));
			colCourseName.setCellValueFactory(new PropertyValueFactory<users, String>("courseName"));
			colTime.setCellValueFactory(new PropertyValueFactory<users, String>("time"));
			colPlace.setCellValueFactory(new PropertyValueFactory<users, String>("place"));
			colWeekdays.setCellValueFactory(new PropertyValueFactory<users, String>("weekdays"));
			colInstructor.setCellValueFactory(new PropertyValueFactory<users, String>("instructor"));
			colCurrEnroll.setCellValueFactory(new PropertyValueFactory<users, Integer>("curr_enrolled"));
			colMaxEnroll.setCellValueFactory(new PropertyValueFactory<users, Integer>("max_enrolled"));
			
			listM = getCourseUsers();
			tableCourses.setItems(listM);
			
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}
	}
		public void validateSectionSearch() 
		{
			try {
				colCourseCode.setCellValueFactory(new PropertyValueFactory<users, String>("courseCode"));
				colSectionCode.setCellValueFactory(new PropertyValueFactory<users, String>("sectionCode"));
				colCourseName.setCellValueFactory(new PropertyValueFactory<users, String>("courseName"));
				colTime.setCellValueFactory(new PropertyValueFactory<users, String>("time"));
				colPlace.setCellValueFactory(new PropertyValueFactory<users, String>("place"));
				colWeekdays.setCellValueFactory(new PropertyValueFactory<users, String>("weekdays"));
				colInstructor.setCellValueFactory(new PropertyValueFactory<users, String>("instructor"));
				colCurrEnroll.setCellValueFactory(new PropertyValueFactory<users, Integer>("curr_enrolled"));
				colMaxEnroll.setCellValueFactory(new PropertyValueFactory<users, Integer>("max_enrolled"));
				
				listM = getSectionUsers();
				tableCourses.setItems(listM);
			
			} catch (Exception e) {
				e.printStackTrace();
				e.getCause();
			}
		}
		
		
		public ObservableList<users> getSectionUsers() 
		{
			DatabaseConnection connectNow = new DatabaseConnection();
			Connection connectDB = connectNow.getConnection();
			
			String sectionCode =  sectionNumTextField.getText();
			
			ObservableList<users> list = FXCollections.observableArrayList();
			try {
				PreparedStatement ps = connectDB.prepareStatement("SELECT * FROM fall WHERE section_code = ?");
				ps.setString(1,  sectionCode);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					list.add(new users(rs.getString("course_code"), 
									   rs.getString("section_code"), 
									    rs.getString("course_name"),
							                   rs.getString("time"),
						      			      rs.getString("place"),
					           			   rs.getString("weekdays"),
					           			   rs.getString("instructor"),
					           			   rs.getInt("curr_enrolled"),
					           			   rs.getInt("max_enrolled")));
				}
			}catch (Exception e) {
					e.printStackTrace();
				}
			
			
			return list;
		}
		
		public ObservableList<users> getCourseUsers() 
		{
			DatabaseConnection connectNow = new DatabaseConnection();
			Connection connectDB = connectNow.getConnection();
			
			String courseCode =  courseCodeTextField.getText();
			String courseTime =  courseTimeTextField.getText();
			
			ObservableList<users> list = FXCollections.observableArrayList();
			try {
				PreparedStatement ps = connectDB.prepareStatement("SELECT * FROM fall WHERE course_code = ? AND time = ?");
				ps.setString(1,  courseCode);
				ps.setString(2, courseTime);
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					list.add(new users(rs.getString("course_code"), 
									   rs.getString("section_code"), 
									    rs.getString("course_name"),
							                   rs.getString("time"),
						      			      rs.getString("place"),
					           			   rs.getString("weekdays"),
					           			   rs.getString("instructor"),
					           			   rs.getInt("curr_enrolled"),
					           			   rs.getInt("max_enrolled")));
				}
			}catch (Exception e) {
					e.printStackTrace();
				}
			
			
			return list;
		}
		
		public ObservableList<users> getSelectedRow() 
		{
			try {
			listF.add(new users(tableCourses.getSelectionModel().getSelectedItem().getCourseCode(),
					           tableCourses.getSelectionModel().getSelectedItem().getSectionCode(),
					           tableCourses.getSelectionModel().getSelectedItem().getCourseName(),
					           tableCourses.getSelectionModel().getSelectedItem().getTime(),
					           tableCourses.getSelectionModel().getSelectedItem().getPlace(),
					           tableCourses.getSelectionModel().getSelectedItem().getWeekdays(),
					           tableCourses.getSelectionModel().getSelectedItem().getInstructor(),
					           tableCourses.getSelectionModel().getSelectedItem().getCurr_enrolled(),
					           tableCourses.getSelectionModel().getSelectedItem().getMax_enrolled()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return listF;
		}
		
		@FXML
		private void addRowToQueue(ActionEvent event) 
		{
			colCourseCode1.setCellValueFactory(new PropertyValueFactory<users, String>("courseCode"));
			colSectionCode1.setCellValueFactory(new PropertyValueFactory<users, String>("sectionCode"));
			colCourseName1.setCellValueFactory(new PropertyValueFactory<users, String>("courseName"));
			colTime1.setCellValueFactory(new PropertyValueFactory<users, String>("time"));
			colPlace1.setCellValueFactory(new PropertyValueFactory<users, String>("place"));
			colWeekdays1.setCellValueFactory(new PropertyValueFactory<users, String>("weekdays"));
			colInstructor1.setCellValueFactory(new PropertyValueFactory<users, String>("instructor"));
			colCurrEnroll1.setCellValueFactory(new PropertyValueFactory<users, Integer>("curr_enrolled"));
			colMaxEnroll1.setCellValueFactory(new PropertyValueFactory<users, Integer>("max_enrolled"));
				
			tableQueue.setItems(getSelectedRow());
		}
		
		@FXML 
		private void deleteRowFromQueue(ActionEvent event)
		{
			tableQueue.getItems().removeAll(tableQueue.getSelectionModel().getSelectedItem());
		}
		
		public static ObservableList<students> getRegisteredClasses() 
		{
			DatabaseConnection connectNow = new DatabaseConnection();
			Connection connectDB = connectNow.getConnection();
			
			String uname = String.valueOf(username);
			
			ObservableList<students> list = FXCollections.observableArrayList();
			try {
				PreparedStatement ps = connectDB.prepareStatement("SELECT DISTINCT R.user, R.fname, R.lname, R.course_code, R.section_code, R.course_name, R.instructor, F.curr_enrolled, F.max_enrolled "
																+ "FROM registered R, fall F "
																+ "WHERE R.user = " + "\'" + uname + "\'" + " AND R.course_code = F.course_code AND R.section_code = F.section_code;");
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					list.add(new students(rs.getString("user"), 
							rs.getString("fname"),
							rs.getString("lname"),
							rs.getString("course_code"),
							   rs.getString("section_code"), 
							    rs.getString("course_name"),
			           			   rs.getString("instructor"),
			           			   rs.getInt("curr_enrolled"),
			           			   rs.getInt("max_enrolled")));
				}
			}catch (Exception e) {
					e.printStackTrace();
				}
			
			
			return list;
		}
		
		
		public static ObservableList<sectionList> getSectionList() 
		{
			DatabaseConnection connectNow = new DatabaseConnection();
			Connection connectDB = connectNow.getConnection();
			
			String uname = String.valueOf(username);
//			String timeChoice = listF.get(0).time;
//			String weekdays = listF.get(0).weekdays;
			
			ObservableList<sectionList> list = FXCollections.observableArrayList();
			try {
				PreparedStatement ps = connectDB.prepareStatement("SELECT r.course_code, r.section_code, r.course_name, f.time, f.place, f.weekdays, r.instructor, r.user, r.fname, r.lname, m.major, m.year\r\n"
						+ "From fall f, registered r, member m\r\n"
						+ "WHERE f.course_code = r.course_code AND f.section_code = r.section_code AND m.user = r.user"
						+ " ORDER BY r.section_code, r.lname;");
				ResultSet rs = ps.executeQuery();
				
				while (rs.next()) {
					list.add(new sectionList(rs.getString("course_code"),
										   	 rs.getString("section_code"), 
										   	 rs.getString("course_name"),
										   	 rs.getString("time"),
										   	 rs.getString("place"),
										   	 rs.getString("weekdays"),
										   	 rs.getString("instructor"),
										   	 rs.getString("user"), 
											 rs.getString("fname"),
											 rs.getString("lname"),
											 rs.getString("major"),
											 rs.getString("year")
											 )
			           		);
				}
			}catch (Exception e) {
					e.printStackTrace();
				}
			
			
			return list;
		}
		
		
		
		public void submission(ActionEvent event) 
		{
			DatabaseConnection connectNow = new DatabaseConnection();
			Connection connectDB = connectNow.getConnection();
			
			String uname = String.valueOf(username);
			String courseChoice = listF.get(0).courseCode;
			String sectionChoice = listF.get(0).sectionCode;
			String courseNameChoice = listF.get(0).courseName;
			String timeChoice = listF.get(0).time;
			String instructorChoice = listF.get(0).instructor;
			
			try {
				ps = connectDB.prepareStatement("SELECT curr_enrolled, max_enrolled " //query to check to see if class is available for enrollment
						    + "FROM fall "
						    + "WHERE course_code = " + courseChoice+ " "
						    + "AND time = " + timeChoice + " OR section_code = " + sectionChoice);
			
				rs = ps.executeQuery();

				rs.next();

				int current, max;
				current = rs.getInt(1);
				max = rs.getInt(2);

				if(current == max)
				{
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Register");
					alert.setHeaderText("This class is full!");
					alert.setContentText("Please remove course " + courseChoice + " from your selection");
					alert.showAndWait();
				}
				else
				{
					String studentDuplicateCheck = "SELECT user, course_code " // query to analyze all student IDs registered for classes
												 + "FROM registered "
												 + "WHERE user = " + "\'" + uname + "\'";
					ResultSet rs = ps.executeQuery(studentDuplicateCheck);
					boolean registrationCheck = true;
					while (rs.next())
					{
						String tempUsername = rs.getString("user");
						String tempCourseCode = rs.getString("course_code");
						
						if(uname.equals(tempUsername) && courseChoice.equals(tempCourseCode)) // checks if student already registered for the class
						{
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Register");
							alert.setHeaderText("You already registered for this course!");
							alert.setContentText("Please remove course " + courseChoice + " from your selection");
							alert.showAndWait();
							registrationCheck = false;
							break;
						}
						else if(count() >= 4) // checks to see if student has already registered for the maximum of 5 classes
						{
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Register");
							alert.setHeaderText("You registered for the maximum amount of credits!");							
							alert.showAndWait();
							registrationCheck = false;
							break;
						}
					}
					if(registrationCheck == true)
					{
						PreparedStatement ps2 = connectDB.prepareStatement("SELECT fname, lname "
																		 + "FROM member "
																		 + "WHERE user = " + "\'" + uname + "\'");
						ResultSet rs1 = ps2.executeQuery();
						
						rs1.next();
						
						String fname = 	rs1.getString("fname"); 
						String lname =  rs1.getString("lname");
						
						
						PreparedStatement ps3 = connectDB.prepareStatement("INSERT INTO registered VALUES(?,?,?,?,?,?,?)"); // will add new row to REGISTER table
						
						ps3.setString(1,  uname);
						ps3.setString(2,  fname);
						ps3.setString(3,  lname);
						ps3.setString(4, courseChoice);
						ps3.setString(5, sectionChoice);
						ps3.setString(6, courseNameChoice);
						ps3.setString(7, instructorChoice);
						ps3.executeUpdate();
						
						int newEnrollment = current + 1;

						String updateEnrollment = "UPDATE fall " 								//query to update current enrollment of course
												+ "SET curr_enrolled = " + newEnrollment + " "
												+ "WHERE course_code = " + courseChoice + " AND section_code = " + sectionChoice + ";";

						ps.executeUpdate(updateEnrollment);
						try {
							switchToSubmissionPage(event);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		public void switchToSubmissionPage(ActionEvent event) throws IOException {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Submission.fxml"));
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
		private int count() 
		{
			DatabaseConnection connectNow = new DatabaseConnection();
			Connection connectDB = connectNow.getConnection();
			
			String uname = String.valueOf(username);
			
			String foundType = "";
			int endType = 0;
			
			PreparedStatement ps;
			try {
				ps = connectDB.prepareStatement("select count(course_code) from registered where user = ?");
				ps.setString(1, uname);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next())
				foundType = rs.getString("count(course_code)");
				endType = Integer.parseInt(foundType);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return endType;
		}
		
		
		public void updateTable() 
		{
			colCourseCode.setCellValueFactory(new PropertyValueFactory<users, String>("courseCode"));
			colSectionCode.setCellValueFactory(new PropertyValueFactory<users, String>("sectionCode"));
			colCourseName.setCellValueFactory(new PropertyValueFactory<users, String>("courseName"));
			colTime.setCellValueFactory(new PropertyValueFactory<users, String>("time"));
			colPlace.setCellValueFactory(new PropertyValueFactory<users, String>("place"));
			colWeekdays.setCellValueFactory(new PropertyValueFactory<users, String>("weekdays"));
			colInstructor.setCellValueFactory(new PropertyValueFactory<users, String>("instructor"));
			colCurrEnroll.setCellValueFactory(new PropertyValueFactory<users, Integer>("curr_enrolled"));
			colMaxEnroll.setCellValueFactory(new PropertyValueFactory<users, Integer>("max_enrolled"));
			
			listM = DatabaseConnection.getDataUsers();
			tableCourses.setItems(listM);
		}
}