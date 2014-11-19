package com.github.arkainnihx.COMP1202.Coursework.Hospital.People;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.HealthState;

public class Patient extends Person {

	public Patient(char gender, int age, Health health) {
		super(gender, age, health);
	}
	
	public boolean beTreated(Class<? extends Doctor> doctor) {
		if (health.getIllness().isTreatable(doctor)) {
			health.setHealthState(HealthState.RECOVERING);
			health.setRecoveryTime();
			return true;
		} else
			return false;
	}
	
	@Override
	public boolean aDayPasses() {
		
		return false;
	}

}