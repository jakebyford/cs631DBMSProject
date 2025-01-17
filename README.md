# Student Class Registration

## ![](images/demo.gif)

Here is a quick video of our projects output.

Copy and paste the link below into your internet browser.

https://www.youtube.com/watch?v=qu9vDTJts4Q&t=316s

---

## Introduction

New College is a new college in Newark and is in need of a New College Application Interface Program that will consist of existing databases. Our program was written using JavaFX and SQL. The program interface will consist of the following:

## System Requirements

- Java 8 or higher
- Java IDE (specifically for Java Web Development)
- MySQL

Additions made are as followed:

- JavaFX SDK version 11 or higher
  - JavaFX jar files
  - Scenebuilder
- MySQL-Connector-Java-8 jar file

## The Relational/Logical Database Design

Our program database is broken down into the following tables: Student, Staff, Faculty, Department, Facilities, Course, Section, and Register. These tables were created in response to what New College required for an application program interface.

Each table had appropriate columns added to store information. The Register table (with the StudentID, CourseID, and Section ID columns) was created in order to
insert/delete/edit/reference between the Student, Course, and Section tables.

---

## ![](images/er-diagram.png)

## ![](images/relational-schema.png)

## Application Design Process

Our program interface was broken down into two key components (that was also broken down between our personal programming goals towards this project): A user-friendly GUI program and logistical query/programming with JavaFX and SQL.

### 1. GUI Design

- Login screen
  - Username _aka_ _StudentID_
    1. Primary Key
  - Password
- Student Access screen
  - Selection options
    1. Course & Time
    2. Section
  - Program determines if space is available within selected course and section
  - Students are limited to one course per year, per semester
  - Each course is limited to a maximum capacity of student enrollment.
- Faculty Access screen
  - Course list will generate the following:
    1. Course Code
    2. Section Code
    3. Time
    4. Place
    5. Weekday
    6. Instructor
    7. List of Students (alphabetically) by:
       - Student ID
       - Last Name
       - First Name
       - Major
       - Year

### 2. JavaFX/SQL

- **Application Development Requirement 2.1**: Student Registration
- **Application Development Requirement 2.2**: Class List Generation

---

## ![](images/application-workflow-diagram.png)

## Major Design Decisions

We collectively decided to use the programming language JavaFX to incorporate the information stored in the SQL databases. The JavaFX language will not only allow us to access/edit the SQL database information, but this programming language will also allow us to create a user-friendly GUI program to do so.

## Design Difficulties

1. **JavaFX**
   - Creating an ObservableList method of a ‘user’ Object, which executes a SQL statement and returns a list. Furthermore taking that ObservableList and setting cell values in JavaFX TableView.
2. **JDBC-MySQL Connectivity**
   - In order to facilitate a connection between JavaFX and a SQL database, a JDBC driver needed to be installed on our device.

## Assumptions

1. **Assumed Attributes**
   - The Weekday attribute of Section will have letters associated with the specific day of the week:
     - M - Monday
     - T - Tuesday
     - W - Wednesday
     - TH - Thursday
     - F - Friday
   - The Address attribute of Student, Staff, and Faculty will include Street, City, State, and Zip Code.
   - The RoomNum attribute for Section will be taken from the RoomNum attribute from the Facilities table.
2. **Assumed Constraints**
   - Teaching Assistants (TA) are considered full-time if they work a maximum of 20 hours a week and they are considered part-time if they work a maximum of 12 hours a week.
   - Students may only register for a maximum of 4 courses.
   - Every section is taught by one faculty member.
   - Faculty members can teach multiple sections of a course or sections of a different course.

## Appendix

Based on the analysis and observation of the specifications mentioned within the report, the following are used:

1. **Entities**
   - Student
   - Staff
   - Faculty
   - Department
   - Facilities
   - Course
   - Section
   - Register
2. **Relationship Types**
   - Assigned (Department → Faculty)
   - Colleagues with (Faculty → Staff)
   - Offers (Department → Course)
   - Teaches (Faculty → Section)
   - Register (Student → Course)
   - With (Course → Section)
   - Hires (Staff → Student)
   - Located in (Section → Facilities)
3. **Attributes/Instances**
   - Student
     - StudentID (Key Attribute)
     - SSN
     - Address
     - High School
     - Major
     - Year
   - Staff
     - Name (Key Attribute)
     - SSN
     - Address
     - Salary
   - Faculty
     - Name (Key Attribute)
     - SSN
     - Address
     - Salary
     - Rank
     - Course Load
     - DeptID
   - Department
     - DeptID (Key Attribute)
     - DeptName
     - Location
     - Budget
   - Facilities
     - BuildingCode (Key
     - RoomNum (Key Attribute)
     - AVEquip
     - Capacity
   - Course
     - CourseID (Key Attribute)
     - CourseName
     - CourseCredit
     - TA
     - DeptID
   - Section
     - CourseID (Key Attribute)
     - SectionID
     - RoomNum
     - Weekday
     - Time
     - MaxEnrollment
     - CurrentEnrollment
     - Name (Faculty Instructor Name)
   - Register
     - StudentID
     - CourseID
     - SectionID
