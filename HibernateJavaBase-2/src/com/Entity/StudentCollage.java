package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class StudentCollage {

	@Id
	@Column(name = "Studentid")
	private int sid;
	
	@Column(name = "name")
	private String sname;
	
	@Column(name = "StudentMark")
	private double smark;
	
	private String Dob;
	
	private String bloodgroup;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public double getSmark() {
		return smark;
	}

	public void setSmark(double smark) {
		this.smark = smark;
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	public String getBloodgroup() {
		return bloodgroup;
	}

	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", smark=" + smark + ", Dob=" + Dob + ", bloodgroup="
				+ bloodgroup + "]";
	}
	
	
	
}
