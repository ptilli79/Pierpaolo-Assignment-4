package com.coderscampus.assignment4;
import java.io.BufferedWriter;
//import java.io.FileWriter;
import java.io.IOException;

public class FileCreator {	
	public void writeFiles(BufferedWriter[] writer, Student[] students, String headerFile) throws IOException {
		writer[0].write(headerFile+"\n");
		writer[1].write(headerFile+"\n");
		writer[2].write(headerFile+"\n");
		
		for (Student student : students) {
			//System.out.println(student.getStudentName()+ "/"+student.getStudentCourse()+ "/"+student.getStudentGrade());
			//System.out.println(student.getStudentGeneralCourse());
			if (student.getStudentGeneralCourse().equals("APMTH")) {
			writer[0].write(student.getStudentId()+","+student.getStudentName()+","+student.getStudentCourse()+","+student.getStudentGrade()+"\n");	
		
		}
		else if (student.getStudentGeneralCourse().equals("COMPSCI")) {
			writer[1].write(student.getStudentId()+","+student.getStudentName()+","+student.getStudentCourse()+","+student.getStudentGrade()+"\n");	
		}
		else {
			writer[2].write(student.getStudentId()+","+student.getStudentName()+","+student.getStudentCourse()+","+student.getStudentGrade()+"\n");
			
		}
		
		}
		
	}
	
	
	

	
}


