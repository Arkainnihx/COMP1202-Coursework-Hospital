package com.github.arkainnihx.COMP1202.Coursework.Hospital.Admin;

import java.util.ArrayList;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Patient;

public class Hospital {
	private ArrayList<PatientContainer> bedList = new ArrayList<PatientContainer>();
	private ArrayList<PatientContainer> theatreList = new ArrayList<PatientContainer>();
	private boolean hasVacancy = true;
	private int dailyPatientsAdmitted = 0;
	private int dailyPatientsDischarged = 0;
	private int dailyPatientsTurnedAway = 0;
	
	/**
	 * Constructs a new Hospital with the specified number of beds and theatres.
	 * 
	 * @param bedNum the number of beds to be constructed with the hospital.
	 * @param theatreNum the number of theatres to be constructed with the hospital.
	 */
	public Hospital(int bedNum, int theatreNum) {
		for (int bedCount = 0; bedCount < bedNum; bedCount++) {
			bedList.add(new PatientContainer());
		}
		for (int theatreCount = 0; theatreCount < theatreNum; theatreCount++) {
			theatreList.add(new PatientContainer());
		}
	}
	
	/**
	 * Checks for an available bed and admits the specified patient to that bed.
	 * 
	 * @param patient the patient to be admitted.
	 * @return the index in the bedList of the bed that the patient was admitted
	 *         to. Returns -1 if there was no space for the patient to be
	 *         admitted.
	 */
	public int admitPatient(Patient patient) {
		for(int bedCount = 0; bedCount < bedList.size(); bedCount++) {
			if (bedList.get(bedCount).occupy(patient)) {
				dailyPatientsAdmitted++;
				return bedCount;
			}
		}
		hasVacancy = false;
		return -1;
	}
	
	/**
	 * Returns the patient at the specified index in the bedList.
	 * 
	 * @param bedIndex the specified index in the bedList.
	 * @return a patient in that bed. Returns null if no person is in that bed, or a bed with that index doesn't exist.
	 */
	public Patient getPatient(int bedIndex) {
		try {
			return (bedList.get(bedIndex).isOccupied() ? bedList.get(bedIndex).getPatient() : null);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	/**
	 * Returns the total number of patients in the hospital.
	 * 
	 * @return the total number of patients in the hospital.
	 */
	public int size() {
		int occupyCount = 0;
		for (PatientContainer bed : bedList) {
			if (bed.isOccupied())
				occupyCount++;
		}
		return occupyCount;
	}
	
	/**
	 * Discharges a the patient in the bed of the specified bedIndex.
	 * 
	 * @param bedIndex the specified index of the bed in the bedList.
	 */
	public void dischargePatient(int bedIndex) {
		if (bedList.get(bedIndex).discharge())
			dailyPatientsDischarged++;
	}
	
	/**
	 * Checks if the theatre with the specified index is free.
	 * 
	 * @param theatreIndex the specified index of the theatre.
	 * @return true if theatre is free.
	 */
	public boolean isTheatreFree(int theatreIndex) {
		return !theatreList.get(theatreIndex).isOccupied();
	}
	
	/**
	 * Puts the specified patient in the theatre with the specified index.
	 * 
	 * @param theatreIndex the specified index of the theatre.
	 * @param patient the specified patient.
	 */
	public void prepForTheatre(int theatreIndex, Patient patient) {
		theatreList.get(theatreIndex).occupy(patient);
	}
	
	/**
	 * Puts the patient back in their assigned bed after surgery.
	 * 
	 * @param theatreIndex the specified index of the theatre that a patient is in.
	 */
	public void takeForRecovery(int theatreIndex) {
		theatreList.get(theatreIndex).discharge();
	}
	
	/**
	 * Returns the bedList.
	 */
	public ArrayList<PatientContainer> getBedList() {
		return bedList;
	}
	
	/**
	 * Checks if there are any free beds in the bedList.
	 * 
	 * @return true if there are free beds, and false if not.
	 */
	public boolean hasVacancy() {
		return hasVacancy;
	}

	/**
	 * Sets the vacancy to the specified boolean.
	 * 
	 * @param hasVacancy the specified boolean.
	 */
	public void setVacancy(boolean hasVacancy) {
		this.hasVacancy = hasVacancy;
	}

	/**
	 * Returns the number of patients admitted to the hospital during that day.
	 */
	public int getDailyPatientsAdmitted() {
		return dailyPatientsAdmitted;
	}
	
	/**
	 * Returns the number of patients discharged from the hospital during that day.
	 */
	public int getDailyPatientsDischarged() {
		return dailyPatientsDischarged;
	}

	/**
	 * Returns the number of patients turned away from the hospital during that day.
	 */
	public int getDailyPatientsTurnedAway() {
		return dailyPatientsTurnedAway;
	}

	// TODO: Stub class.
	/**
	 * Simulates a single day for the hospital.
	 */
	public void aDayPasses() {
		dailyPatientsAdmitted = 0;
		dailyPatientsDischarged = 0;
		dailyPatientsTurnedAway = 0;
	}
	
}