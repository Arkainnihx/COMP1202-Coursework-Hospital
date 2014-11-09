package com.github.arkainnihx.COMP1202.Coursework.Hospital;

import java.util.ArrayList;

public class Hospital {
	private ArrayList<PatientContainer> bedList = new ArrayList<PatientContainer>();
	private ArrayList<PatientContainer> theatreList = new ArrayList<PatientContainer>();
	
	public static void main(String[] args) {
		Hospital testHospital = new Hospital();
		testHospital.admitPatient(new Patient('m', 19, "healthy"));
		testHospital.admitPatient(new Patient('f', 45, "healthy"));
		testHospital.admitPatient(new Patient('m', 10, "healthy"));
		testHospital.admitPatient(new Patient('f', 23, "healthy"));
		if (testHospital.isTheatreFree(0))
			testHospital.prepForTheatre(0, testHospital.getPatient(0));
		
		
	}
	
	public Hospital() {
		for (int bedCount = 0; bedCount < 50; bedCount++) {
			bedList.add(new PatientContainer());
		}
		for (int bedCount = 0; bedCount < 4; bedCount++) {
			theatreList.add(new PatientContainer());
		}
	}
	
	public int admitPatient(Patient patient) {
		for(int bedCount = 0; bedCount < bedList.size(); bedCount++) {
			if (bedList.get(bedCount).occupy(patient)) {
				return bedCount;
			}
		}
		return -1;
	}
	
	public Patient getPatient(int bedIndex) {
		return (bedList.get(bedIndex).isOccupied() ? bedList.get(bedIndex).getPatient() : null);
	}
	
	public int size() {
		int occupyCount = 0;
		for (PatientContainer bed : bedList) {
			if (bed.isOccupied()) occupyCount++;
		}
		return occupyCount;
	}
	
	public void dischargePatient(int bedIndex) {
		bedList.get(bedIndex).discharge();
	}
	
	public boolean isTheatreFree(int theatreIndex) {
		return !theatreList.get(theatreIndex).isOccupied();
	}
	
	public void prepForTheatre(int theatreIndex, Patient patient) {
		theatreList.get(theatreIndex).occupy(patient);
	}
	
	public void takeForRecovery(int theatreIndex) {
		theatreList.get(theatreIndex).discharge();
	}
	
	// TODO: Stub class.
	public void aDayPasses() {
		 
	}
}