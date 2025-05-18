package com.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int StudentId;
	
	private String StudentName;
	
	private String StudentAddress;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Subjects> listOfSubject=new ArrayList<Subjects>();

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getStudentAddress() {
		return StudentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		StudentAddress = studentAddress;
	}

	
	
	public List<Subjects> getListOfSubject() {
		return listOfSubject;
	}

	public void setListOfSubject(List<Subjects> listOfSubject) {
		this.listOfSubject = listOfSubject;
	}

	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", StudentName=" + StudentName + ", StudentAddress=" + StudentAddress
				+ ", listOfSubject=" + listOfSubject + "]";
	}

	
	
	
}
