package com.coderscampus.assignment4;

public class Student implements Comparable<Student>{
	
	//import java.io.Serializable;
		private String studentName;
		private String studentCourse;
		private String studentGeneralCourse;
		private String studentId;
		private Integer studentGrade;
		//private String[] str; //auxiliary variable for "studentGeneralCourse" calculation
		
		// getters and setters for the above instance variables
		
		public Student (String[] studentInfo, String studentGeneralCourse) {
		
			this.studentId = studentInfo[0];
			this.studentName = studentInfo[1];
			this.studentCourse = studentInfo[2];
			this.studentGrade = Integer.parseInt(studentInfo[3]);
			this.studentGeneralCourse=studentGeneralCourse;
			
		}
		
		public String getStudentName() {
			return studentName;
		}
		
		public void setStudentName(String studentName) {
			this.studentName = studentName;
		}

		public String getStudentCourse() {
			return studentCourse;
		}
		
		public void setStudentCourse(String studentCourse) {
			this.studentCourse = studentCourse;
		}
		
		public String getStudentGeneralCourse() {
			return studentGeneralCourse;
		}
		
		public void setStudentGeneralCourse(String studentGeneralCourse) {
			this.studentGeneralCourse = studentGeneralCourse;
		}
		
		public String getStudentId() {
			return studentId;
		}
		public void setStudentId(String studentId) {
			this.studentId = studentId;
		}
		
		public Integer getStudentGrade() {
			return studentGrade;
		}
		public void setStudentGrade(Integer studentGrade) {
			this.studentGrade = studentGrade;
		}
		
		@Override
		public int compareTo(Student that) {
			if (this.studentGeneralCourse.compareTo(that.studentGeneralCourse) == 0) {
				if	(this.studentGrade.compareTo(that.studentGrade) == 0) {
					return this.studentName.compareTo(that.studentName);
				
				}
				else {
					return that.studentGrade.compareTo(this.studentGrade); // this will sort names in asc order
				}
			}
			else {
					return this.studentGeneralCourse.compareTo(that.studentGeneralCourse); // this will sort height in desc order
			}
		}		
	}



