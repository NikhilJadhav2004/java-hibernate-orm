package com.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ShivajiCollage")
public class Studant {

	@Id
	private int RollNO;
	
	@Column(name="StudantName")
	private String Name;
	
	@Column(name ="LastName")
	private String sirName;
	
	@Column(name="birthDate")
	private String DOB;

	public int getRollNO() {
		return RollNO;
	}

	public void setRollNO(int rollNO) {
		RollNO = rollNO;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSirName() {
		return sirName;
	}

	public void setSirName(String sirName) {
		this.sirName = sirName;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	@Override
	public String toString() {
		return "Studant [RollNO=" + RollNO + ", Name=" + Name + ", sirName=" + sirName + ", DOB=" + DOB + "]";
	}
	
	
}
