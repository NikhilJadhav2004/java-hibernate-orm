package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPInfromation")
public class Employee {

@Id
@Column(name = "ID")
private int eid;
	
@Column(name = "Name")
	private String ename;
	
@Column(name = "Salary")
	private double esalry;

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

	public double getEsalry() {
		return esalry;
	}

	public void setEsalry(double esalry) {
		this.esalry = esalry;
	}

	@Override
	public String toString() {
		return "HibernateUtil [eid=" + eid + ", ename=" + ename + ", esalry=" + esalry + "]";
	}
	
	
}
