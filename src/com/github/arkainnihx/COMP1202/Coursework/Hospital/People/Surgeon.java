package com.github.arkainnihx.COMP1202.Coursework.Hospital.People;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;

public class Surgeon extends Doctor {
	
	private int theatreIndex = 0;

	public Surgeon(char gender, int age, Health health) {
		super(gender, age, health);
	}

	public int getTheatreIndex() {
		return theatreIndex;
	}

	public void setTheatreIndex(int theatreIndex) {
		this.theatreIndex = theatreIndex;
	}

	@Override
	public boolean treatPatient() {
		if (assignedPatient.requiresTheatre()) {
			// TODO Start here
		}
		if (operate())
			return true;
		else if (super.treatPatient())
			return true;
		else
			return false;
	}

	protected boolean operate() {
		if (assignedPatient.isInTheatre())
			return internalTreat();
		else
			return false;
	}
}
