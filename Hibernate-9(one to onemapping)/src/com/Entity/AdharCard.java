package com.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdharCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adharid;
	
	private String adharNo;

	public int getAdharid() {
		return adharid;
	}

	public void setAdharid(int adharid) {
		this.adharid = adharid;
	}

	public String getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}

	@Override
	public String toString() {
		return "AdharCard [adharid=" + adharid + ", adharNo=" + adharNo + "]";
	}
	
	
}
