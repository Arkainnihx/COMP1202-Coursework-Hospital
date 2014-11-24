package com.github.arkainnihx.COMP1202.Coursework.Hospital.Admin;

import java.util.ArrayList;
import java.util.Random;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Doctor;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Patient;

public class HospitalAdministrator {
	private Hospital workingHospital;
	private ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	private ArrayList<Patient> excessPatients = new ArrayList<Patient>();
	private int patientsDischarged, patientsTurnedAway, dailyPatientsAdmitted,
			dailyPatientsDischarged, dailyPatientsTurnedAway = 0;

	public static void main(String[] args) {
		
	}
	
	public boolean aDayPasses() {
		dailyPatientsAdmitted = 0;
		dailyPatientsDischarged = 0;
		dailyPatientsTurnedAway = 0;
		admitNewPatients();
		
		
		
		System.out.println(getDailyReport());
		return true;
	}
	
	public void admitNewPatients() {
		ArrayList<Patient> newPatients = new ArrayList<Patient>();
		if (excessPatients.size() > 0)
			newPatients.addAll(excessPatients);
		newPatients.addAll(generateNewPatients());
		if (workingHospital.hasVacancy()) {
				while (newPatients.size() > 0) {
					if (workingHospital.admitPatient(newPatients.get(0)) != -1) {
						dailyPatientsAdmitted++;
						newPatients.remove(0);
						if (excessPatients.size() > 0)
							excessPatients.remove(0);
					} else 
						break;
				}
		}
		if (newPatients.size() > 0) {
			if (excessPatients.size() > 0) {
				for (int patientCount = 0; patientCount < excessPatients.size(); patientCount++) 
					newPatients.remove(0);
			}
			excessPatients.addAll(newPatients);
			dailyPatientsTurnedAway = excessPatients.size();
		}
	}
	
	public ArrayList<Patient> generateNewPatients() {
		Random gen = new Random();
		int patientNum = gen.nextInt(10);
		ArrayList<Patient> newPatientList = new ArrayList<Patient>();
		for (int patientCount = 0; patientCount < patientNum; patientCount++) {
			newPatientList.add(new Patient((gen.nextBoolean() ? 'm' : 'f'), gen.nextInt(100) + 1, new Health(gen.nextInt(8) + 1)));
		}
		return newPatientList;
	}
	
	public String getDailyReport() {
		
		return "";
	}

}
