package com.github.arkainnihx.COMP1202.Coursework.Hospital.Files;

import java.util.ArrayList;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Admin.Hospital;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Doctor;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Patient;

public class SaveState {
	private Hospital workingHospital;
	private ArrayList<Doctor> doctorList;
	private ArrayList<Patient> excessPatients;
	private int dayCount, patientsAdmitted, patientsDischarged, patientsTurnedAway = 0;
	
	public SaveState(Hospital workingHospital, ArrayList<Doctor> doctorList, ArrayList<Patient> excessPatients, int dayCount, int patientsAdmitted, int patientsDischarged, int patientsTurnedAway) {
		this.workingHospital = workingHospital;
		this.doctorList = doctorList;
		this.excessPatients = excessPatients;
		this.dayCount = dayCount;
		this.patientsAdmitted = patientsAdmitted;
		this.patientsDischarged = patientsDischarged;
		this.patientsTurnedAway = patientsTurnedAway;
	}

	public Hospital getWorkingHospital() {
		return workingHospital;
	}

	public ArrayList<Doctor> getDoctorList() {
		return doctorList;
	}

	public ArrayList<Patient> getExcessPatients() {
		return excessPatients;
	}
	
	public int getDayCount() {
		return dayCount;
	}

	public int getPatientsAdmitted() {
		return patientsAdmitted;
	}

	public int getPatientsDischarged() {
		return patientsDischarged;
	}

	public int getPatientsTurnedAway() {
		return patientsTurnedAway;
	}
	
}