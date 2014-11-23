package com.github.arkainnihx.COMP1202.Coursework.Hospital.People;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;

public class LimbSurgeon extends Surgeon {

	public LimbSurgeon(char gender, int age, Health health) {
		super(gender, age, health);
	}
	
	protected boolean operate() {
		int[] idArray = {4, 7, 8};
		return internalTreat(idArray);
	}
	
}
