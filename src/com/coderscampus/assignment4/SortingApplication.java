package com.coderscampus.assignment4;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
//import java.io.LineNumberReader;
import java.util.Arrays;
//import java.util.Comparator;


// refactor import com.coderscampus.assignment4.User;

public class SortingApplication {

	public static void main (String[] args) throws IOException{
		//Program variables:
		//BufferedReader fileReader = null;
		Student[] students = new Student[100]; //100 students in csv file, one per row (+ header row)
		FileWriterService createFile = new FileWriterService();
		FileReaderService csvReader = new FileReaderService() ;
		String workingDir = System.getProperty("user.dir");
		String workingDir1=workingDir;
		

			workingDir=workingDir+"/data/student-master-list.csv";

			System.out.println("File full path: "+workingDir+"+\nOpening file reader....");
			students=csvReader.createStudents(workingDir);
			
			Arrays.sort(students);			
			//workingDir1 = System.getProperty("user.dir");
			
			createFile.writeFiles(workingDir1,students,csvReader.getHeader(workingDir));
			
			System.out.println("Output files directory --> "+workingDir+"/output/");

		}

	}

