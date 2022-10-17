package com.coderscampus.assignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Arrays;
//import java.util.Comparator;


// refactor import com.coderscampus.assignment4.User;

public class SortingApplication {

	public static void main (String[] args) throws IOException{
		//Program variables:
		int i = 0;  //auxiliary counter for while loop
		String[] arr; //auxiliary array for manipulating class Student attributes: studendID, studentName, studentGrade, studentCourse
		BufferedReader fileReader = null;
		Student[] students = new Student[100];
		LineNumberReader lnr  = null; //file line counter, as to determine the size of user array
		BufferedWriter[] writer = new BufferedWriter[3];
		FileCreator createFile = new FileCreator();
		String headerFile=null; //variable to save header of file "*.csv"
		
		try { 
			//File f = new File(dataPath(""), "/image1.jpg");
			String workingDir = System.getProperty("user.dir");
			workingDir=workingDir+"/data/student-master-list.csv";
			//fileReader = new BufferedReader(new FileReader("C:/Users/pierp/OneDrive/Documentos/MyRepository/PreloadBuild/Output/assignment3-data.txt"));
			String line = "";

			System.out.println("File full path: "+workingDir+"+\nOpening file reader and lnr couter.");
			fileReader = new BufferedReader(new FileReader(workingDir));	
			lnr = new LineNumberReader(fileReader);
			line = "";
			i=0;
			String[] str_aux;
			System.out.println("Reading....");
			while (((line = fileReader.readLine()) != null)) {
				arr=line.split(",");
				if (i == 0) {
					headerFile=line;	
				}
				else {
				str_aux = arr[2].split(" ");	
				students[i-1] = new Student(arr,str_aux[0]);
				}
				i++;
			}
			Arrays.sort(students);			
			workingDir = System.getProperty("user.dir");
			
			try {
			writer[0] = new BufferedWriter(new FileWriter(workingDir+"/output/course1.csv"));
			writer[1] = new BufferedWriter(new FileWriter(workingDir+"/output/course2.csv"));
			writer[2] = new BufferedWriter(new FileWriter(workingDir+"/output/course3.csv"));
			System.out.println("Writing files....");
			createFile.writeFiles(writer,students,headerFile);
			
			} 
			finally {
			System.out.println("Closing files....");
			if (writer[0] != null) writer[0].close();
			if (writer[1] != null) writer[1].close();
			if (writer[2] != null) writer[2].close();
			System.out.println("Output files directory --> "+workingDir+"/output/");
			}	
		}
		finally {
			//System.out.println("Closing file reader and lnr couter");
			lnr.close();
			fileReader.close();
			
			
		}

	}
}
