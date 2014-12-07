package com.github.arkainnihx.COMP1202.Coursework.Hospital.People;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;

public class Surgeon extends Doctor {

	public Surgeon(char gender, int age, Health health) {
		super(gender, age, health);
	}

	@Override
	public boolean treatPatient() {
		if (assignedPatient.requiresTheatre()) {
			return operate();
		}
		return super.treatPatient();
	}

	protected boolean operate() {
		if (assignedPatient.isInTheatre())
			
			return internalTreat();
		else
			return false;
	}
	
}