// ************************************************************************************************************
// students.java						Author: Jake Byford								Spring 2021
//
// CS 631850                        	Database Management Systems						ID: 31556607
// 
// Create a user database for New Jersey Institute of Technology
//
// ************************************************************************************************************
package application;

public class students {

	String user, fname, lname, course_code, section_code, course_name, instructor;
	int currEnrolled, maxEnrolled;
	
	public students(String user, String fname, String lname, String course_code, String section_code,
			String course_name, String instructor, int currEnrolled, int maxEnrolled) {
		super();
		this.user = user;
		this.fname = fname;
		this.lname = lname;
		this.course_code = course_code;
		this.section_code = section_code;
		this.course_name = course_name;
		this.instructor = instructor;
		this.currEnrolled = currEnrolled;
		this.maxEnrolled = maxEnrolled;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	public String getSection_code() {
		return section_code;
	}

	public void setSection_code(String section_code) {
		this.section_code = section_code;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public int getCurrEnrolled() {
		return currEnrolled;
	}

	public void setCurrEnrolled(int currEnrolled) {
		this.currEnrolled = currEnrolled;
	}

	public int getMaxEnrolled() {
		return maxEnrolled;
	}

	public void setMaxEnrolled(int maxEnrolled) {
		this.maxEnrolled = maxEnrolled;
	}

	
	
}
