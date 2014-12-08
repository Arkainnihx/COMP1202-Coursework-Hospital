package com.github.arkainnihx.COMP1202.Coursework.Hospital.Admin;

import java.util.ArrayList;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Doctor;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Patient;

public class SaveState {
	Hospital workingHospital;
	ArrayList<Doctor> doctorList;
	ArrayList<Patient> excessPatients;
	int patientsAdmitted, patientsDischarged, patientsTurnedAway = 0;
	
	public SaveState(Hospital workingHospital, ArrayList<Doctor> doctorList, ArrayList<Patient> excessPatients, int patientsAdmitted, int patientsDischarged, int patientsTurnedAway) {
		this.workingHospital = workingHospital;
		this.doctorList = doctorList;
		this.excessPatients = excessPatients;
		this.patientsAdmitted = patientsAdmitted;
		this.patientsDischarged = patientsDischarged;
		this.patientsTurnedAway = patientsTurnedAway;
	}
	
}