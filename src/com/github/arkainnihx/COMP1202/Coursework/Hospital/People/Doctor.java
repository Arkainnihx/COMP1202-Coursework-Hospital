package com.github.arkainnihx.COMP1202.Coursework.Hospital.People;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;

public class Doctor extends Person {
	protected int specialism = 0;
	protected Patient assignedPatient;
	protected int[] treatableIDs;

	public Doctor(char gender, int age, Health health) {
		super(gender, age, health);
		if (this.getClass().equals(Doctor.class)) {
			specialism = 1;
			treatableIDs = new int[] { 1, 2, 3 };
		} else if (this.getClass().equals(Surgeon.class)) {
			specialism = 2;
			treatableIDs = new int[] { 1, 2, 3, 4 };
		} else if (this.getClass().equals(OrganSurgeon.class)) {
			specialism = 3;
			treatableIDs = new int[] { 1, 2, 3, 4, 5, 6 };
		} else if (this.getClass().equals(LimbSurgeon.class)) {
			specialism = 4;
			treatableIDs = new int[] { 1, 2, 3, 4, 7, 8 };
		}
	}

	public int getSpecialism() {
		return specialism;
	}

	public int[] getTreatableIDs() {
		return treatableIDs;
	}

	public int getHighestID() {
		int maxID = 0;
		for (int ID : treatableIDs) {
			if (ID > maxID)
				maxID = ID;
		}
		return maxID;
	}
	
	public void assignPatient(Patient patient) {
		assignedPatient = patient;
	}
	
	public Patient getAssignedPatient() {
		return assignedPatient;
	}

	public boolean isAssignedPatient() {
		return (assignedPatient != null);
	}

	public boolean treatPatient() {
		return internalTreat();
	}

	protected boolean internalTreat() {
		if (assignedPatient.beTreated(this)) {
			assignedPatient = null;
			return true;
		} else
			return false;
	}

	@Override
	public boolean aDayPasses() {
		// TODO Auto-generated method stubs
		return false;
	}

}