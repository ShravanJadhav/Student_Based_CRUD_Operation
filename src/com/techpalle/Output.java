package com.techpalle;

import java.util.ArrayList;

public class Output {

	public static void main(String[] args) {
		 Student s = new Student();
		 
		 //creating table student table in dataBase
		 s.creating();
		 
		 //inserting values in student table
		 s.inserting("Shravan", "Java", "shravan@");
		 s.inserting("Jadhav", "Python", "jadhav@");
		 s.inserting("Rutu", "J2EE", "rutu@");
		 s.inserting("SPJ", "HTML", "spj@");
		 
		 //update the values in student table with sno is given
		 s.update(1, "Shravan@gmail", "JavaFull");
		 
		 //deleting the values from student table with sno is given
		s.delete(4);
		 
		 //getting all data from student table with the help of collection framework
		 ArrayList<StudentData> ans = s.reading();
			for(StudentData i : ans) {
				System.out.println(i.getSno());
				System.out.println(i.getSname());
				System.out.println(i.getSub());
				System.out.println(i.getEmail());	
				
				System.out.println("**********************************");
			}
		 
		 //getting all data from student without collection
		 s.read();	
		 

	}

}
