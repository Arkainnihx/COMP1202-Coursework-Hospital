package com.github.arkainnihx.COMP1202.Coursework.Hospital.Admin;

import java.util.ArrayList;
import java.util.Random;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Doctor;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Patient;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Surgeon;

public class HospitalAdministrator {
	private Hospital workingHospital;
	private ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	private ArrayList<Patient> excessPatients = new ArrayList<Patient>();
	private int patientsAdmitted, patientsDischarged, patientsTurnedAway, dailyPatientsAdmitted, dailyPatientsDischarged, dailyPatientsTurnedAway = 0;

	public static void main(String[] args) {
		
	}

	public void aDayPasses() {
		dailyPatientsAdmitted = 0;
		dailyPatientsDischarged = 0;
		dailyPatientsTurnedAway = 0;
		admitNewPatients();
		assignPatients();
		prepPatientsForTheatre();
		treatPatients();
		dailyPatientsDischarged = workingHospital.aDayPasses();
		patientsAdmitted += dailyPatientsAdmitted;
		patientsDischarged += dailyPatientsDischarged;
		patientsTurnedAway += dailyPatientsTurnedAway;
		printDailyReport();
	}

	private void admitNewPatients() {
		ArrayList<Patient> newPatients = new ArrayList<Patient>();
		if (excessPatients.size() > 0)
			newPatients.addAll(excessPatients);
		newPatients.addAll(generateNewPatients());
		if (workingHospital.hasVacancy())
			while (newPatients.size() > 0)
				if (workingHospital.admitPatient(newPatients.get(0)) != -1) {
					dailyPatientsAdmitted++;
					newPatients.remove(0);
					if (excessPatients.size() > 0)
						excessPatients.remove(0);
				} else
					break;
		if (newPatients.size() > 0) {
			if (excessPatients.size() > 0)
				for (int patientCount = 0; patientCount < excessPatients.size(); patientCount++)
					newPatients.remove(0);
			excessPatients.addAll(newPatients);
			dailyPatientsTurnedAway = excessPatients.size();
		}
	}
	
	private ArrayList<Patient> generateNewPatients() {
		Random gen = new Random();
		int patientNum = gen.nextInt(6);
		ArrayList<Patient> newPatientList = new ArrayList<Patient>();
		for (int patientCount = 0; patientCount < patientNum; patientCount++)
			newPatientList.add(new Patient((gen.nextBoolean() ? 'm' : 'f'), gen.nextInt(100) + 1, new Health(gen.nextInt(8) + 1)));
		return newPatientList;
	}

	public void assignPatients() {
		int bedIndex;
		int maxID;
		for (Doctor doctor : doctorList) {
			bedIndex = 0;
			maxID = 0;
			for (PatientContainer bed : workingHospital.getBedList()) {
				if (bed.isOccupied()) {
					if (bed.getPatient().isTreatableBy(doctor)) { 
						if (bed.getPatient().getHealth().getIllness().getIdNum() > maxID) {
							maxID = bed.getPatient().getHealth().getIllness().getIdNum();
							bedIndex = workingHospital.getBedList().indexOf(bed);
							if (maxID == doctor.getHighestID())
								break;
						}
					}	
				}	
			}
			doctor.assignPatient(workingHospital.getPatient(bedIndex));
		}
	}
	
	private void prepPatientsForTheatre() {
		for (Doctor doctor : doctorList) {
			if (doctor.isAssignedPatient() && doctor.getAssignedPatient().requiresTheatre()) {
				for (int theatreCount = 0; theatreCount < workingHospital.getTheatreList().size(); theatreCount++) {
					if (workingHospital.prepForTheatre(theatreCount, doctor.getAssignedPatient())) {
						break;
					}
				}
			}
		}
	}
	
	private void treatPatients() {
		for (Doctor doctor : doctorList) {
			if (doctor.isAssignedPatient()) {
				doctor.aDayPasses();
			}
		}
	}
	
	public String[] getDailyReport() {
		ArrayList<String> dailyReport = new ArrayList<String>();
		dailyReport.add("=============== DAILY REPORT ===============");
		dailyReport.add("Patients Admitted Today: " + dailyPatientsAdmitted);
		dailyReport.add("Patients Discharged Today: " + dailyPatientsDischarged);
		dailyReport.add("Patients Turned Away Today: " + dailyPatientsTurnedAway);
		dailyReport.add("Total Patients Admitted: " + patientsAdmitted);
		dailyReport.add("Total Patients Discharged Today: " + patientsDischarged);
		dailyReport.add("Total Patients Turned Away Today: " + patientsTurnedAway);
		dailyReport.add("============================================");
		return (String[]) dailyReport.toArray();
	}
	
	public void printDailyReport() {
		for (String line : getDailyReport()) {
			System.out.println(line);
		}
	}

}