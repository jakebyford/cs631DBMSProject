# Student Class Registration

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
- MySQL-Connector-Java-8 jar file .

## ![](images/er-diagram.png)

![](images/relational-schema.png)

## The Relational/Logical Database Design

Our program database is broken down into the following tables: Student, Staff, Faculty, Department, Facilities, Course, Section, and Register. These tables were created in response to what New College required for an application program interface.

Each table had appropriate columns added to store information. The Register table (with the StudentID, CourseID, and Section ID columns) was created in order to
insert/delete/edit/reference between the Student, Course, and Section tables.

## Application Design Process

Our program interface was broken down into two key components (that was also broken down between our personal programming goals towards this project): A user-friendly GUI program and logistical query/programming with JavaFX and SQL.

### 1. GUI Design

    - a. Login screen
        -i. Username *aka* *StudentID*
                1. Primary Key
        -ii. Password
    - b. Student Access screen
