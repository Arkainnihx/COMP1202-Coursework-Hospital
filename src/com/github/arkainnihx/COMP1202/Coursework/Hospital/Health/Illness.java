package com.github.arkainnihx.COMP1202.Coursework.Hospital.Health;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Doctor;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.LimbSurgeon;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.OrganSurgeon;
import com.github.arkainnihx.COMP1202.Coursework.Hospital.People.Surgeon;

public enum Illness {
	Dijkstras_Syndrome(1, 5, 5, Doctor.class, false), 
	Java_Flu(2, 3, 3, Doctor.class, false), 
	Deadline_Panic_Attacks(3, 1, 1, Doctor.class, false), 
	Polymorphic_Cist(4, 2, 4, Surgeon.class, true), 
	Semicolon_Missing(5, 5, 8, OrganSurgeon.class, true), 
	Trapped_Exception(6, 6, 8, OrganSurgeon.class, true), 
	Tim_Berners_Knee(7, 4, 6, LimbSurgeon.class, true), 
	Coders_Elbow(8, 2, 3, LimbSurgeon.class, true);

	private int idNum;
	private int recoveryMin;
	private int recoveryMax;
	private Class<? extends Doctor> treatedBy;
	private boolean requiresTheatre;

	private Illness(int idNum, int recoveryMin, int recoveryMax,
			Class<? extends Doctor> treatedBy, boolean requiresTheatre) {
		this.idNum = idNum;
		this.recoveryMin = recoveryMin;
		this.recoveryMax = recoveryMax;
		this.treatedBy = treatedBy;
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

	public Class<? extends Doctor> getTreatedBy() {
		return treatedBy;
	}

	public boolean isRequiresTheatre() {
		return requiresTheatre;
	}
	
	public static Illness idToIllness(int illnessID) {
		for (int illnessCount = 1; illnessCount < 9; illnessCount++) {
			if (Illness.values()[illnessCount].getIdNum() == illnessID) {
				return Illness.values()[illnessCount];
			}
		}
		return null;
	}

}