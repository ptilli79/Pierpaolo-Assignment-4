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
		String headerFile=null; //variable to save header of file "*.csv"
		FileReaderService csvReader = new FileReaderService() ;
		
//		try { 
			//File f = new File(dataPath(""), "/image1.jpg");
			String workingDir = System.getProperty("user.dir");
			workingDir=workingDir+"/data/student-master-list.csv";
			//fileReader = new BufferedReader(new FileReader("C:/Users/pierp/OneDrive/Documentos/MyRepository/PreloadBuild/Output/assignment3-data.txt"));
//			String line = "";

			System.out.println("File full path: "+workingDir+"+\nOpening file reader....");
			headerFile="Student ID,	Student Name,	Course,	Grade";
			students=csvReader.createStudents(workingDir);
			
			Arrays.sort(students);			
			workingDir = System.getProperty("user.dir");
			
			createFile.writeFiles(workingDir,students,headerFile);
			
			System.out.println("Output files directory --> "+workingDir+"/output/");

		}

	}

