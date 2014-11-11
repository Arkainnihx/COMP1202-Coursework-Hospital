package com.github.arkainnihx.COMP1202.Coursework.Hospital.Health;

public class Health {
	private HealthState healthState;
	private Illness illness;
	private int recoveryTime = 0;
	
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
	
}