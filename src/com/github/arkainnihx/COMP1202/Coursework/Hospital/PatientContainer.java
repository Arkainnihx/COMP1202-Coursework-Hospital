package com.github.arkainnihx.COMP1202.Coursework.Hospital;

public class PatientContainer {
	private Patient patient = null;
	private boolean isOccupied = false;
	
	public boolean occupy(Patient patient) {
		if (!isOccupied) {
			isOccupied = true;
			this.patient = patient;	
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