/**********************************************
Workshop #11
Course: JAC444
Last Name: Sheng
First Name: Xuewei
ID:061745121
Section: NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature Xuewei Sheng
Date: Dec 11, 2021
**********************************************/
package jac444_ws11;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentInfo {
	private static Connection conn;	
	public static void main(String[] args){		
	   try {
		conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\sheng\\eclipse-workspace\\JAC444_WS11\\src\\JACStudents");
		 //string has to start with "jdbc", "sqlite"is the data type, 
		 //after that is the address of the program, the last part is the name of db	
		//make sure to close the resources manually or using try block, it is a good practice
		//if manually, close them in order: statement first and then the connection				
		
		//createTables();
		//deleteTables();
		displayStudent();
		displayExercises();
		displayLogs();
		updateLogs();
		System.out.print("After program runs, ");
		displayLogs();
		
		conn.close();		
	   } catch (SQLException e) {
		e.printStackTrace();
	   }
	}
	
	private static void createTables() throws SQLException{
		Statement creatTables = conn.createStatement();
		//create JACStudents table and insert the data
		creatTables.execute("create table if not exists JACStudents ("
				+ "username varchar(50) not null, "
				+ "password varchar(50) not null, "
				+ "fullname varchar(200) not null, "
				+ "instructorEmail varchar(100) not null, "
				+ "constraint pkJACStudent primary key (username));");
		creatTables.execute("insert into JACStudents (username, password, fullname, instructorEmail)"
				+ "values ('abc', 'p1', 'Kyle Wright', 'a@senecacollege.ca')");
		creatTables.execute("insert into JACStudents (username, password, fullname, instructorEmail)"
				+ "values ('cde', 'p2', 'Yao Mi', 'c@senecacollege.ca')");
		creatTables.execute("insert into JACStudents (username, password, fullname, instructorEmail)"
				+ "values ('wbc', 'p3', 'Jack Jill', 'a@senecacollege.ca')");
		
		//create AssignedExercises table and insert data
		creatTables.execute("create table if not exists AssignedExercises ("
				+ "instructorEmail varchar(100),"
				+ "exerciseName varchar(100),"
				+ "maxscore double default 10,"
				+ "constraint pkCustomExercise primary key (instructorEmail, exerciseName))");
		creatTables.execute("insert into AssignedExercises (instructorEmail, exerciseName, maxscore)"
				+ "values ('a@senecacollege.ca', 'e1', 10)");
		creatTables.execute("insert into AssignedExercises (instructorEmail, exerciseName, maxscore)"
				+ "values ('a@senecacollege.ca', 'e2', 10)");
		creatTables.execute("insert into AssignedExercises (instructorEmail, exerciseName, maxscore)"
				+ "values ('c@senecacollege.ca', 'e1', 4)");
		creatTables.execute("insert into AssignedExercises (instructorEmail, exerciseName, maxscore)"
				+ "values ('c@senecacollege.ca', 'e4', 20)");
		
		//create JACLogs table and insert data
		creatTables.execute("create table if not exists JACLogs ("
				+ "username varchar(50),"
				+ "exerciseName varchar(100),"
				+ "score double default null,"
				+ "submitted bit default 0,"
				+ "constraint pkLog primary key (username, exerciseName));");
				
		creatTables.execute("insert into JACLogs (username, exerciseName, score, submitted)"
				+ "values ('abc', 'e1', 9, '1')");
		creatTables.execute("insert into JACLogs (username, exerciseName, score, submitted)"
				+ "values ('wbc', 'e2', 7, '1')");
		
		//close statement
		creatTables.close();
		
	}
	
	private static void displayStudent() throws SQLException {
		Statement studentsStatment = conn.createStatement();
		studentsStatment.execute("select * from JACStudents");
		ResultSet studentSet = studentsStatment.getResultSet();
		System.out.println("JACStudents");
		System.out.println("===============================================================");
		System.out.printf("%-15s%-15s%-15s%-20s", 
				"username", "password", "fullname", "instructorEmail");
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		if(!studentSet.isBeforeFirst())
		{
			System.out.println("No student data");
		}
		while(studentSet.next())
		{
			System.out.printf("%-15s%-15s%-15s%-20s", 
					studentSet.getString(1), 
					studentSet.getString(2), 
					studentSet.getString(3), 
					studentSet.getString(4));
			System.out.println();
		}
		System.out.println("===============================================================");
		System.out.println();
		studentSet.close();
		studentsStatment.close();
	}
	
	private static void displayExercises() throws SQLException {
		Statement exercisesStatment = conn.createStatement();
		exercisesStatment.execute("select * from AssignedExercises");
		ResultSet exerciseSet = exercisesStatment.getResultSet();
		System.out.println("AssignedExercises");
		System.out.println("===============================================================");
		System.out.printf("%-25s%-18s%-15s", "instructorEmail", "exersiseName", "maxScore");
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		if(!exerciseSet.isBeforeFirst())
		{
			System.out.println("No exercise data");
		}
		while(exerciseSet.next())
		{
			System.out.printf("%-25s%-18s%-15.0f", 
					exerciseSet.getString(1), 
					exerciseSet.getString(2), 
					exerciseSet.getDouble(3));
			System.out.println();
		}
		System.out.println("===============================================================");
		System.out.println();
		exerciseSet.close();
		exercisesStatment.close();
	}
	
	private static void displayLogs() throws SQLException {
		Statement logsStatment = conn.createStatement();
		logsStatment.execute("select * from JACLogs");
		ResultSet logSet = logsStatment.getResultSet();
		System.out.println("JACLogs");
		System.out.println("===============================================================");
		System.out.printf("%-20s%-18s%-15s%-20s", "username", "exersiseName", "score", "submitted");
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		if(!logSet.isBeforeFirst())
		{
			System.out.println("No JAC log data");
		}
		while(logSet.next())
		{
			System.out.printf("%-20s%-18s%-15.0f%-20s", 
					logSet.getString(1), 
					logSet.getString(2), 
					logSet.getDouble(3),
					logSet.getString(4));
			System.out.println();
		}
		System.out.println("===============================================================");
		System.out.println();
		logSet.close();
		logsStatment.close();
	}
	
	private static void updateLogs() throws SQLException {
		Statement exercisesStatment = conn.createStatement();
		Statement studentsStatement = conn.createStatement();
		Statement logStatement = conn.createStatement();
		Statement insertLogRecord = conn.createStatement();
		ResultSet exerciseSet = exercisesStatment.executeQuery("select * from AssignedExercises");
		
		
		String insEmailEx;
		String exName;
		String userName;
		String insEmailSt;
		while(exerciseSet.next())
		{
			insEmailEx = exerciseSet.getString(1);
			exName = exerciseSet.getString(2);
			//double maxScore = exerciseSet.getDouble(3);
			ResultSet studentSet = studentsStatement.executeQuery("select * from JACStudents");
			while(studentSet.next()) 
			{
				userName = studentSet.getString(1);
				insEmailSt = studentSet.getString(4);
				if(insEmailSt.equals(insEmailEx))
				{
					Boolean isExist = false;
					ResultSet logSet = logStatement.executeQuery("select * from JACLogs");
					while(logSet.next())
					{
						if(logSet.getString(1).equals(userName)  && logSet.getString(2).equals(exName))
						{
							isExist = true;
						}
					}
					
					if(!isExist)
					{
						String sqlCommand = "insert into JACLogs (username, exerciseName, score, submitted) values ('" 
								+ userName + "','" +  exName + "', 0, '0')";
						insertLogRecord.execute(sqlCommand);
					}	
					logSet.close();
				}
			}
			studentSet.close();
		}
		exerciseSet.close();
		exercisesStatment.close();
		studentsStatement.close();
		logStatement.close();
		insertLogRecord.close();
		
	}
	
	private static void deleteTables() throws SQLException {
		Statement deleteStatement = conn.createStatement();
		deleteStatement.execute("delete from JACStudents");
		deleteStatement.execute("delete from AssignedExercises");
		deleteStatement.execute("delete from JACLogs");
		deleteStatement.close();
	}
}

