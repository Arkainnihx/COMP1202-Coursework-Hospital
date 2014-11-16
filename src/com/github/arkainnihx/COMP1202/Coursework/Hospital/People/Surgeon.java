package com.github.arkainnihx.COMP1202.Coursework.Hospital.People;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;

public class Surgeon extends Doctor {

	public Surgeon(char gender, int age, Health health) {
		super(gender, age, health);
	}
	
	public boolean treatPatient() {
		if (assignedPatient.getHealth().getIllness().getTreatedBy().equals(this.getClass())) {
			if (assignedPatient.getHealth().getIllness().getIdNum() == 4) {
				operate();
			}
			patientRecovery();
			return true;
		} else {
			return false;
		}
	}
	
	private void operate() {
		
	}

}
