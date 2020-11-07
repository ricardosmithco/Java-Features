package ioOperations;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class Serialization {

	public static void main(String[] args){
//		Set<Course> courses = new HashSet<>();
//		Course c1 = new Course(1,"java");
//		Course c2 = new Course(2, "python");
//		courses.add(c1);
//		courses.add(c2);
//		Student stu = new Student(11,"Ricardo Smith", courses);
		
		try {
//			FileOutputStream outFile = new FileOutputStream("StudentSerializedData.txt");
//			ObjectOutputStream objStream = new ObjectOutputStream(outFile);
//			objStream.writeObject(stu);
			FileInputStream inFile = new FileInputStream("StudentSerializedData.txt");
			ObjectInputStream objStream2 = new ObjectInputStream(inFile);
			System.out.println((Student)objStream2.readObject());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // added manual default serialVersionUID to allow modification of object after serialization.
	int studentID;
	String studentName;
	Set<Course> courses;
	int gpa;
	
	public int getGpa() {
		return gpa;
	}
	public void setGpa(int gpa) {
		this.gpa = gpa;
	}
	Student(){}
	Student(int studentID,String studentName,Set<Course> courses, int gpa){
		this.studentID = studentID;
		this.studentName = studentName;
		this.courses = courses;
		this.gpa = gpa;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courses == null) ? 0 : courses.hashCode());
		result = prime * result + gpa;
		result = prime * result + studentID;
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (courses == null) {
			if (other.courses != null)
				return false;
		} else if (!courses.equals(other.courses))
			return false;
		if (gpa != other.gpa)
			return false;
		if (studentID != other.studentID)
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", studentName=" + studentName + ", courses=" + courses + ", gpa="
				+ gpa + "]";
	}	
}

class Course implements Serializable{
	private int courseID;
	private String courseName;
	
	Course() {}
	Course(int courseID, String courseName) {
		this.courseID = courseID;
		this.courseName = courseName;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseID;
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseID != other.courseID)
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Course [courseID=" + courseID + ", courseName=" + courseName + "]";
	}	
}

/*
 * Assume that, after serializing a Student object into a file, 
 * you have modified the Student class structure by adding a new field. 
 * Now, what will happen if you try to deserialize the Candidate object from the file?
 * You will get java.io.InvalidClassException. The reason is, Java automatically 
 * assigns a unique version identifier called SerialVersionUID to every serializable class, 
 * based on the structure of the class. 
 * Since the updated class's version id does not match with the version id of the serialized object, 
 * an exception will be thrown during deserialization.
 * To solve the version mismatch problem, we can control the versioning by assigning a version id manually.
 */

/*
 * Suppose that we wanted to add a field to the Student object: 'String grade' that would be calculated 
 * based on the student's 'gpa'. Since grade will be derived from gpa, it need not be stored in the file.
 * in cases like this, we can declare these properties as transient, eg:
 *  private int studentID;
 *	private String studentName;
 *	private Set<Course> courses;
 *	private int gpa;
 *  private transient String grade;
 *  
 *  the grade attribute since it is defined as transient will not be serialized. 
 */

/*
 * Some notes regarding Serializable:
 * - If a class implements Serializable, all its subclasses will also become Serializable.
 * - If a Serializable class has a reference to another class, all these classes must implement Serializable.
 * 	 NotSerializableException will be thrown during runtime, otherwise.
 * - If a static data member exists in a class, it is not serialized because static is part of the class and not its objects.
 * - In the case of an array/collection, all the elements of the array/collection should be Serializable. 
 *   If any object is not Serializable, serialization will fail.
 */
