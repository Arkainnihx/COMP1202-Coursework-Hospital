package com.github.arkainnihx.COMP1202.Coursework.Hospital.Health;

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
		this(HealthState.ILL, illness, -1);
	}
	
	public Health(int illnessID) {
		this(HealthState.ILL, Illness.idToIllness(illnessID), -1);
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
	
	public void setRecoveryTime() {
		this.recoveryTime = illness.generateRecoveryTime();
	}
	
}