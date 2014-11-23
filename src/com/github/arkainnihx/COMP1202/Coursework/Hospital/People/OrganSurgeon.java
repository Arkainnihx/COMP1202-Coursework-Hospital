package com.github.arkainnihx.COMP1202.Coursework.Hospital.People;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;

public class OrganSurgeon extends Surgeon {

	public OrganSurgeon(char gender, int age, Health health) {
		super(gender, age, health);
	}
	
	protected boolean operate() {
		int[] idArray = {4, 5, 6};
		return internalTreat(idArray);
	}

}
