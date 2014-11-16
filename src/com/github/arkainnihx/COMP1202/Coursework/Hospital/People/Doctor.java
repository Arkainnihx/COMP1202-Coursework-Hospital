package com.github.arkainnihx.COMP1202.Coursework.Hospital.People;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.HealthState;

public class Doctor extends Person {
	private int specialism = 0;
	protected Patient assignedPatient;

	public Doctor(char gender, int age, Health health) {
		super(gender, age, health);
		if (this.getClass().equals(Doctor.class)) {
			specialism = 1;
		} else if (this.getClass().equals(Surgeon.class)) {
			specialism = 2;
		} else if (this.getClass().equals(LimbSurgeon.class)) {
			specialism = 3;
		} else if (this.getClass().equals(OrganSurgeon.class)) {
			specialism = 4;
		}
	}
	
	public int getSpecialism() {
		return specialism;
	}
	
	public void assignPatient(Patient patient) {
		assignedPatient = patient;
	}
	
	public boolean treatPatient() {
		if (assignedPatient.getHealth().getIllness().getTreatedBy().equals(this.getClass())) {
			patientRecovery();
			return true;
		} else {
			return false;
		}
	}
	
	public void patientRecovery() {
		assignedPatient.getHealth().setHealthState(HealthState.RECOVERING);
		assignedPatient.getHealth().setRecoveryTime(assignedPatient.getHealth().generateRecoveryTime());
	}
	
	public boolean aDayPasses() {
		// TODO Auto-generated method stubs
		return false;
	}

}
