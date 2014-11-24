package com.github.arkainnihx.COMP1202.Coursework.Hospital.People;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;

public class Doctor extends Person {
	protected int specialism = 0;
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
		int[] idArray = {1, 2, 3};
		return internalTreat(idArray);
	}
	
	protected boolean internalTreat(int[] idArray) {
		if (assignedPatient.beTreated(idArray)) {
			assignedPatient = null;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean aDayPasses() {
		// TODO Auto-generated method stubs
		return false;
	}

}