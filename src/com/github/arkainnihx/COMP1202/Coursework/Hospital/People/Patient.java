package com.github.arkainnihx.COMP1202.Coursework.Hospital.People;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Admin.PatientContainer;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.HealthState;

public class Patient extends Person {
	private boolean inTheatre = false;
	private PatientContainer myBed = null;

	public Patient(char gender, int age, Health health) {
		super(gender, age, health);
	}

	public boolean isInTheatre() {
		return inTheatre;
	}

	public void setInTheatre(boolean inTheatre) {
		this.inTheatre = inTheatre;
	}

	public void setMyBed(PatientContainer myBed) {
		this.myBed = myBed;
	}

	public boolean beTreated(Doctor doctor) {
		if (isTreatableBy(doctor)) {
			health.setHealthState(HealthState.RECOVERING);
			health.setIllness(null);
			health.setRecoveryTime();
			return true;
		} else
			return false;
	}
	
	public boolean requiresTreatment() {
		return (health.getHealthState().equals(HealthState.ILL));
	}

	public boolean requiresTheatre() {
		return health.getIllness().requiresTheatre();
	}

	public boolean isTreatableBy(Doctor doctor) {
		return health.getIllness().isTreatableBy(doctor);
	}

	@Override
	public boolean aDayPasses() {
		if (health.getRecoveryTime() >= 0 && health.decRecoveryTime()) {
			myBed.discharge();
			myBed = null;
			return true;
		}
		return false;
	}

}