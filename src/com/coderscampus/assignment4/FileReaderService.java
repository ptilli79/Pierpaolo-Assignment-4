package com.coderscampus.assignment4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;


public class FileReaderService {
	//public Student[] students = new Student[100];
	BufferedReader fileReader = null;
	private int i=0;
	String line="";
	
	public Student[] createStudents(String workingDir) throws IOException{
		
		Student[] students = new Student[100];
		String[] arr;
		
		fileReader = new BufferedReader(new FileReader(workingDir));	
//		lnr = new LineNumberReader(fileReader);
		//line = "";
		i=0;
		String[] str_aux;
		System.out.println("Reading....");
		while (((line = fileReader.readLine()) != null)) {
			arr=line.split(",");
			if (i > 0) {
				//headerFile=line;
				str_aux = arr[2].split(" ");	
				students[i-1] = new Student(arr,str_aux[0]);
			}
			i++;
		}
		return students;
	}
	
	public String getHeader (String workingDir) throws IOException{
		fileReader = new BufferedReader(new FileReader(workingDir));	
		System.out.println("Extracting header....");
		if (((line = fileReader.readLine()) != null)) {
			return line;
		}	
		else {
			return null;
		}
	}
	
	
	

}
