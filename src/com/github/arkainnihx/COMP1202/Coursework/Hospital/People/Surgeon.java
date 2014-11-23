package com.github.arkainnihx.COMP1202.Coursework.Hospital.People;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;

public class Surgeon extends Doctor {

	public Surgeon(char gender, int age, Health health) {
		super(gender, age, health);
	}
	
	public boolean treatPatient() {
		if (operate()) {
			return true;
		} else if (super.treatPatient()) {
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean operate() {
		int[] idArray = {4};
		return internalTreat(idArray);
	}
	
}
