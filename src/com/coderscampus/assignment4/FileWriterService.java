package com.coderscampus.assignment4;
import java.io.BufferedWriter;
import java.io.FileWriter;
//import java.io.FileWriter;
import java.io.IOException;

public class FileWriterService {
	private BufferedWriter[] writer = new BufferedWriter[3]; //= new BufferedWriter[3];
	
	public void writeFiles(String workingDir, Student[] students, String headerFile) throws IOException {
		
		try {
		System.out.println("Writing files....");
		writer[0] = new BufferedWriter(new FileWriter(workingDir+"/output/course1.csv"));
		writer[1] = new BufferedWriter(new FileWriter(workingDir+"/output/course2.csv"));
		writer[2] = new BufferedWriter(new FileWriter(workingDir+"/output/course3.csv"));
		
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
	finally {
		System.out.println("Closing files....");
		if (writer[0] != null) writer[0].close();
		if (writer[1] != null) writer[1].close();
		if (writer[2] != null) writer[2].close();
			
			
		}
	}
	
	
	

	
}


