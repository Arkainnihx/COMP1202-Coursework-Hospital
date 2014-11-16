package com.github.arkainnihx.COMP1202.Coursework.Hospital.Health;

import java.util.Random;

public class Health {
	private HealthState healthState;
	private Illness illness;
	private int recoveryTime;
	
	public Health(HealthState healthState, Illness illness, int recoveryTime) {
		this.healthState = healthState;
		this.illness = illness;
		this.recoveryTime = recoveryTime;
	}
	
	public Health(Illness illness) {
		this(HealthState.ILL, illness, 0);
	}
	
	public Health() {
		this(HealthState.HEALTHY, null, 0);
	}

	public HealthState getHealthState() {
		return healthState;
	}
	
	public void setHealthState(HealthState healthState) {
		this.healthState = healthState;
	}
	
	public Illness getIllness() {
		return illness;
	}
	
	public void setIllness(Illness illness) {
		this.illness = illness;
	}
	
	public int getRecoveryTime() {
		return recoveryTime;
	}
	
	public void setRecoveryTime(int recoveryTime) {
		this.recoveryTime = recoveryTime;
	}
	
	public int generateRecoveryTime() {
		Random rnd = new Random();
		int min = this.illness.getRecoveryMin();
		int max = this.illness.getRecoveryMax();
		if (min == max) {
			return min;
		} else {
			return min + rnd.nextInt(max - min + 1);
		}
	}
	
}