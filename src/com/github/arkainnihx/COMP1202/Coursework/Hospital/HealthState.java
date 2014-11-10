package com.github.arkainnihx.COMP1202.Coursework.Hospital;

public enum HealthState {
	HEALTHY(0), RECOVERING(1), ILL(2);

	private int healthNum;

	HealthState(int healthNum) {
		this.healthNum = healthNum;
	}

	public int getHealthNum() {
		return healthNum;
	}
	
}