package UA_exercises_and_test;
//UA Test 18/07/2019

import java.util.Arrays;

public class Student {
	private long id;
	private String Sname;
	private Course [] course;
	private int numCourses;

	public Student (long id, String Sname, Course[] course, int numCourses) {
		this.id = id;
		this.Sname = Sname;
		this.numCourses = numCourses;
		this.course = new Course[10];		
	}
	
	public Student (Student other) {
		this(other.id, other.Sname, other.course, other.numCourses);
	}

	public boolean addCourse (Course c) { // getting the object Course
		if (course.length >= 10)
			return false;	
		course[numCourses] = new Course(c);
		numCourses++; // widing the places of the array
		return true;
	}

	@SuppressWarnings("unused")
	public boolean setGrade(int grade, int numCourse) {
		if(grade<0 || grade>100) return false;
		for (int i = 0; i<numCourse; i++) {
			if (course[i].getNumber() == numCourse) 
				course[i].setGrade(grade);
			return true;
		}
		return false;
	}

	public Course[]	getCourse() {
		return course;
	}
	public void setCourse(Course[] course) {
		this.course = course;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public int getNumCourses() {
		return numCourses;
	}
	public void setNumCourses(int numCourses) {
		this.numCourses = numCourses;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", Sname=" + Sname + ", course=" + Arrays.toString(course) + ", numCourses="
				+ numCourses + "]";
	}
}
