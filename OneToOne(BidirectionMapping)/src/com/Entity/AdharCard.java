package com.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AdharCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int AdharId;
	
	private String AdharNumber;

	@OneToOne(cascade = CascadeType.ALL)
	private Person person;

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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "AdharCard [AdharId=" + AdharId + ", AdharNumber=" + AdharNumber + "]";
	}
	
	
	
}
