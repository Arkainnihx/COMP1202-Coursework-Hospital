package com.github.arkainnihx.COMP1202.Coursework.Hospital.People;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.HealthState;

public class Patient extends Person {
	private boolean inTheatre = false;

	public Patient(char gender, int age, Health health) {
		super(gender, age, health);
	}

	public boolean isInTheatre() {
		return inTheatre;
	}

	public void setInTheatre(boolean inTheatre) {
		this.inTheatre = inTheatre;
	}

	public boolean beTreated(Doctor doctor) {
		if (health.getIllness().isTreatableBy(doctor)) {
			health.setHealthState(HealthState.RECOVERING);
			health.setRecoveryTime();
			return true;
		} else
			return false;
	}

	public boolean requiresTheatre() {
		return health.getIllness().requiresTheatre();
	}

	public boolean isTreatableBy(Doctor doctor) {
		return health.getIllness().isTreatableBy(doctor);
	}

	@Override
	public boolean aDayPasses() {

		return false;
	}

}