package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subjects {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int SubId;
	
	private String SubName;

	public int getSubId() {
		return SubId;
	}

	public void setSubId(int subId) {
		SubId = subId;
	}

	public String getSubName() {
		return SubName;
	}

	public void setSubName(String subName) {
		SubName = subName;
	}

	@Override
	public String toString() {
		return "Subjects [SubId=" + SubId + ", SubName=" + SubName + "]";
	}
	
	
}
