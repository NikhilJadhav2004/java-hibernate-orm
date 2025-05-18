package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdharCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int AdharId;
	
	private String AdharNumber;

	public int getAdharId() {
		return AdharId;
	}

	public void setAdharId(int adharId) {
		AdharId = adharId;
	}

	public String getAdharNumber() {
		return AdharNumber;
	}

	public void setAdharNumber(String adharNumber) {
		AdharNumber = adharNumber;
	}

	@Override
	public String toString() {
		return "AdharCard [AdharId=" + AdharId + ", AdharNumber=" + AdharNumber + "]";
	}
	
	
}
