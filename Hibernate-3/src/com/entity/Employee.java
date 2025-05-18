package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Table;
@Entity
@javax.persistence.Table(name="Exponent")
//@DynamicInsert(value = true)
@DynamicUpdate(value=true)
public class Employee {

	@Id
	@Column(name="Employee_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	
	@Column(name="Employee_Name")
	private String ename;

	@Column(name = "Employee_Dept")
	private String eDept;
	
	private double esalary;
	
	private String eaddress;
	
	private String DOB;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String geteDept() {
		return eDept;
	}

	public void seteDept(String eDept) {
		this.eDept = eDept;
	}

	public double getEsalary() {
		return esalary;
	}

	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eDept=" + eDept + ", esalary=" + esalary + ", eaddress="
				+ eaddress + ", DOB=" + DOB + "]";
	}
	
	
	
}
