package com.github.arkainnihx.COMP1202.Coursework.Hospital.Admin;

import java.util.ArrayList;
import java.util.Random;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Doctor;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Patient;

public class HospitalAdministrator {
	Hospital workingHospital;
	ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
	ArrayList<Patient> excessPatients = new ArrayList<Patient>();
	int patientsDischarged = 0;
	int patientsTurnedAway = 0;
	boolean vacancy = true;
	
	public static void main(String[] args) {

	}
	
	public boolean aDayPasses() {
		ArrayList<Patient> newPatients = new ArrayList<Patient>();
		if (excessPatients.size() > 0)
			newPatients.addAll(excessPatients);
		newPatients.addAll(generateNewPatients());
		// TODO: This is not finished and will not work yet. Fix while loop.
		while (vacancy) {
			for (PatientContainer bed : workingHospital.getBedList()) {
				if (bed.occupy(newPatients.get(0))) {
					newPatients.remove(0);
					if (excessPatients.size() > 0)
						excessPatients.remove(0);
				}
			}
		}
		
		return true;
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

}
