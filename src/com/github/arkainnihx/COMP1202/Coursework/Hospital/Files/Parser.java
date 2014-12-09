package com.github.arkainnihx.COMP1202.Coursework.Hospital.Files;

import java.util.ArrayList;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Admin.Hospital;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.HealthState;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Doctor;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Patient;

public class Parser {

	public static SaveState textToData(String[] text) {
		ArrayList<String> components = new ArrayList<String>();
		Hospital workingHospital = null;
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();
		ArrayList<Patient> patientList, excessPatients = new ArrayList<Patient>();
		int dayCount, patientsAdmitted, patientsDischarged, patientsTurnedAway, currentLoadState = 0;
		/*
		 * currentLoadState value definitions:
		 * 0 = Hospital State
		 * 1 = Patients State
		 * 2 = Doctors State
		 * 3 = Excess Patients State
		 * 4 = Statistics State
		 */
		for (String line : text) {
			components = splitComponents(line);
			switch (currentLoadState) {
			case 0: 
				if (components.get(0).equalsIgnoreCase("hospital")) {
					workingHospital = new Hospital(Integer.parseInt(components.get(1)), Integer.parseInt(components.get(2)));
					currentLoadState = 1;
				} else {
					throw new InvalidConfigFileException();
				}
				break;
			case 1:
				if (components.get(0).equalsIgnoreCase("patient")) {
					Health myHealth = generateHealth(Integer.parseInt(components.get(3)), Integer.parseInt(components.get(4)));
					if (components.size() == 5) {
						workingHospital.admitPatient(new Patient(components.get(1).charAt(0), Integer.parseInt(components.get(2)), myHealth));
					} else {
						workingHospital.admitPatient(new Patient(components.get(1).charAt(0), Integer.parseInt(components.get(2)), myHealth), Integer.parseInt(components.get(5)));
					}
				} else {
					currentLoadState = 2;
				}
			case 2: 
				if (components.size() == 3) {
					// TODO Start here
				} else {
					if (doctorList.size() > 0) {
						currentLoadState = 3;
					} else {
						throw new InvalidConfigFileException();
					}
				}
				break;
			case 3:
				if (components.get(0).equalsIgnoreCase("patient")) {
					Health myHealth = generateHealth(Integer.parseInt(components.get(3)), Integer.parseInt(components.get(4)));
					
				} else {
					currentLoadState = 4;
				}
			case 4:
				if () {
					
				} else {
					throw new InvalidConfigFileException();
				}
				break;
			}
		}
	}
	
	public static String[] dataToText(SaveState data) {
		
	}

	private static ArrayList<String> splitComponents(String line) {
		ArrayList<String> components = new ArrayList<String>();
		String[] splitLine = null;
		if (line.contains(":")) {
			splitLine = line.split(":");
			components.add(splitLine[0]);
			if (splitLine[1].contains(",")){
				splitLine = splitLine[1].split(",");
				for (String component : splitLine) {
					components.add(component);
				}
			}
		} else {
			components.add(line);
		}
		return components;
	}
	
	private static Health generateHealth(int IllnessID, int recoveryTime) {
		if (IllnessID > 0) {
			return new Health(IllnessID);
		} else {
			return new Health(HealthState.RECOVERING, null, recoveryTime);
		}
	}

}