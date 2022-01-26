// ************************************************************************************************************
// Users.java							Author: Jake Byford								Spring 2021
//
// CS 631850                        	Database Management Systems						ID: 31556607
// 
// Create a user database for New Jersey Institute of Technology
//
// ************************************************************************************************************

package application;

public class users {
	
	String courseCode, sectionCode, time;
	String courseName, place, weekdays, instructor;
	Integer curr_enrolled, max_enrolled;
	
	public users(String courseCode, 
				 String sectionCode, 
				 String courseName, 
				 String time, 
				 String place, 
				 String weekdays,
				 String instructor,
				 Integer curr_enrolled,
				 Integer max_enrolled) {
		super();
		this.courseCode = courseCode;
		this.sectionCode = sectionCode;
		this.courseName = courseName;
		this.time = time;
		this.place = place;
		this.weekdays = weekdays;
		this.instructor = instructor;
		this.curr_enrolled = curr_enrolled;
		this.max_enrolled = max_enrolled;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getSectionCode() {
		return sectionCode;
	}
	public void setSectionCode(String sectionCode) {
		this.sectionCode = sectionCode;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	public String getWeekdays() {
		return weekdays;
	}
	public void setWeekdays(String weekdays) {
		this.weekdays = weekdays;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public Integer getCurr_enrolled() {
		return curr_enrolled;
	}

	public void setCurr_enrolled(Integer curr_enrolled) {
		this.curr_enrolled = curr_enrolled;
	}

	public Integer getMax_enrolled() {
		return max_enrolled;
	}

	public void setMax_enrolled(Integer max_enrolled) {
		this.max_enrolled = max_enrolled;
	}
	
	
}
