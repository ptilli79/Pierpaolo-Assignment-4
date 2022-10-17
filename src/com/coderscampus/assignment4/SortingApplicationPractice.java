package com.coderscampus.assignment4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.Comparator;


// refactor import com.coderscampus.assignment4.User;

public class SortingApplicationPractice {

	public static void main (String[] args) throws IOException{
		String[] names = new String[4];
		//int line_counter=0; //auxiliary line counter
		int i = 0; 
		
		
		String[] arr; //= new String[3]; //User attributes array: Username, Password and Name
		BufferedReader fileReader1 = null;
		Pig[] pigs = new Pig[4];
		Student[] students = new Student[100];
		LineNumberReader lnr  = null; //file line counter, as to determine the size of user array
		BufferedWriter[] writer = new BufferedWriter[3];
		FileCreator createFile = new FileCreator();
		
		try { 
			//File f = new File(dataPath(""), "/image1.jpg");
			String workingDir1 = System.getProperty("user.dir");
			String workingDir2 = workingDir1;
			//System.out.println(workingDir);
			workingDir1=workingDir1+"/data/pigs.txt";
			workingDir2=workingDir2+"/data/student-master-list.csv";
			//fileReader = new BufferedReader(new FileReader("C:/Users/pierp/OneDrive/Documentos/MyRepository/PreloadBuild/Output/assignment3-data.txt"));
			fileReader1 = new BufferedReader(new FileReader(workingDir1));	
			lnr = new LineNumberReader(fileReader1);
			String line = "";
			while (((line = fileReader1.readLine()) != null)) {
				arr=line.split(",");
				pigs[i] = new Pig(arr[0],arr[1]);
				//for (String arg : arr) {
				//System.out.println(arg);
				//}
				i++;
				//System.out.println("Line "+ i+": "+line);
			}
			for (Pig arg : pigs) {
				if(arg != null) {
					System.out.println(arg.getPigName());
				}
			}
			Arrays.sort(pigs);
			System.out.println("----");
			for (Pig pig : pigs) {
				System.out.println(pig.getPigName());
			}
			
			String headerFile=null;
			fileReader1 = new BufferedReader(new FileReader(workingDir2));	
			lnr = new LineNumberReader(fileReader1);
			line = "";
			i=0;
			String[] str_aux;
			
			while (((line = fileReader1.readLine()) != null)) {
				arr=line.split(",");
				if (i == 0) {
					headerFile=line;	
				}
				else {
				str_aux = arr[2].split(" ");	
				students[i-1] = new Student(arr,str_aux[0]);
				//for (String arg : arr) {
				//System.out.println(arg);
				//}
				}
				i++;
				System.out.println("Line "+ i+": "+line);
			
			}
			System.out.println("----");
			System.out.println(headerFile);
			for (Student student : students) {
				if(student != null) {
					System.out.println(student.getStudentName());
				}
			}
			
			System.out.println("----");
			System.out.println(headerFile);
			Arrays.sort(students);
			for (Student student : students) {
				System.out.println(student.getStudentName()+ "/"+student.getStudentCourse()+ "/"+student.getStudentGrade());
			}			
			
			workingDir1 = System.getProperty("user.dir");
			try {
			writer[0] = new BufferedWriter(new FileWriter(workingDir1+"/output/course1.csv"));
			writer[1] = new BufferedWriter(new FileWriter(workingDir1+"/output/course2.csv"));
			writer[2] = new BufferedWriter(new FileWriter(workingDir1+"/output/course3.csv"));
			createFile.writeFiles(writer,students,headerFile);
			
		} finally {
			if (writer[0] != null) writer[0].close();
			if (writer[1] != null) writer[1].close();
			if (writer[2] != null) writer[2].close();
		}
			
		}
		finally {
			//System.out.println("Closing file reader and lnr couter");
			lnr.close();
			fileReader1.close();
		}
		//		BufferedWriter writer = null;
		
//		try {
//			writer = new BufferedWriter(new FileWriter("data.txt"));
//			writer.write("This is a test string that will be output into a file.\n");
//			writer.write("Is this line of text on a new line?");
//		} finally {
//			if (writer != null) writer.close();
//		}
		
		names[0] = "Josh Allen";
		names[1] = "Trevor Page";
		names[2] = "Elon Musk";
		names[3] = "Jordan Bellfast";
		System.out.println("----");
		System.out.println("Pre-sorting");
		for (String name : names) {
			System.out.println(name);
		}
		System.out.println("----");
		Arrays.sort(names);
		System.out.println("Post-sorting");
		for (String name : names) {
			System.out.println(name);
		}
		
		Person[] people = new Person[5];
		
		people[0] = new Person("Josh Allen", 72);
		people[1] = new Person("Trevor Page", 70);
		people[2] = new Person("Elon Musk", 74);
		people[3] = new Person("Jordan Bellfast", 71);
		people[4] = new Person("Jane Doe", 70);
		
		Arrays.sort(people);
		System.out.println("----");
		for (Person person : people) {
			System.out.println(person.getName());
		}
		
		System.out.println("----");
		Arrays.sort(people, new PersonHeightComparator());
		
		for (Person person : people) {
			System.out.println(person.getName() + " is " + person.getHeight() + " inches tall.");
		}
		
		System.out.println("----");
		Arrays.sort(people, new Comparator<Person>() {
			@Override
			public int compare(Person person1, Person person2) {
				return person2.getHeight().compareTo(person1.getHeight());
			}
		});
		
		for (Person person : people) {
			System.out.println(person.getName() + " is " + person.getHeight() + " inches tall.");
		}
	}

}
