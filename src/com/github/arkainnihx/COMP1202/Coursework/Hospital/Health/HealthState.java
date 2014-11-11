package com.github.arkainnihx.COMP1202.Coursework.Hospital.Health;

public enum HealthState {
	HEALTHY(0), RECOVERING(1), ILL(2);

	private int idNum;

	HealthState(int idNum) {
		this.idNum = idNum;
	}

	public int getIDNum() {
		return idNum;
	}
	
}