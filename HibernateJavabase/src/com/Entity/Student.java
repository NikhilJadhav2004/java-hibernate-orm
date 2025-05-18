package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="StudentInfo")
public class Student {

	@Id
	@Column(name="StudentId")
	private int sid;
	
	@Column(name="StudentName")
	private String sname;
	
	@Column(name="StudentAddress")
	private String sAddress;
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
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	@Override
	public String toString() {
		return "Test [sid=" + sid + ", sname=" + sname + ", sAddress=" + sAddress + "]";
	}
	
	
	
}
