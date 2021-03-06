package com.github.arkainnihx.COMP1202.Coursework.Hospital.Admin;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Patient;

public class PatientContainer {
	private Patient patient = null;
	private boolean isOccupied = false;

	public boolean occupy(Patient patient) {
		if (!isOccupied) {
			isOccupied = true;
			this.patient = patient;
			patient.setMyBed(this);
			return true;
		} else
			return false;
	}

	public boolean discharge() {
		if (isOccupied) {
			isOccupied = false;
			this.patient = null;
			return true;
		} else
			return false;
	}

	public Patient getPatient() {
		return patient;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

}