package com.github.arkainnihx.COMP1202.Coursework.Hospital.Health;

import java.util.Random;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Doctor;

public enum Illness {
	Dijkstras_Syndrome(1, 5, 5, false), Java_Flu(2, 3, 3, false), Deadline_Panic_Attacks(3, 1, 1, false), Polymorphic_Cist(4, 2, 4, true), Semicolon_Missing(5, 5, 8, true), Trapped_Exception(6, 6, 8, true), Tim_Berners_Knee(7, 4, 6, true), Coders_Elbow(8, 2, 3, true);

	private int idNum;
	private int recoveryMin;
	private int recoveryMax;
	private boolean requiresTheatre;

	private Illness(int idNum, int recoveryMin, int recoveryMax, boolean requiresTheatre) {
		this.idNum = idNum;
		this.recoveryMin = recoveryMin;
		this.recoveryMax = recoveryMax;
		this.requiresTheatre = requiresTheatre;
	}

	public int getIdNum() {
		return idNum;
	}

	public int getRecoveryMin() {
		return recoveryMin;
	}

	public int getRecoveryMax() {
		return recoveryMax;
	}

	public boolean requiresTheatre() {
		return requiresTheatre;
	}

	public static Illness idToIllness(int illnessID) {
		for (int illnessCount = 1; illnessCount < Illness.values().length; illnessCount++)
			if (Illness.values()[illnessCount].getIdNum() == illnessID)
				return Illness.values()[illnessCount];
		return null;
	}

	public boolean isTreatableBy(Doctor doctor) {
		int illnessID = this.idNum;
		for (int currentID : doctor.getTreatableIDs())
			if (illnessID == currentID)
				return true;
		return false;
	}

	public int generateRecoveryTime() {
		Random rnd = new Random();
		int min = this.getRecoveryMin();
		int max = this.getRecoveryMax();
		if (min == max)
			return min;
		else
			return min + rnd.nextInt(max - min + 1);
	}

}