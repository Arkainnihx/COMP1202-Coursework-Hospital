package com.github.arkainnihx.COMP1202.Coursework.Hospital.People;

import com.github.arkainnihx.COMP1202.Coursework.Hospital.Health.Health;

public abstract class Person {
	protected boolean gender = true;
	protected int age = 0;
	protected Health health;
	
	public Person(char gender, int age, Health health) {
		this.gender = (Character.toLowerCase(gender) == 'm' ? true : false);
		this.age = age;
		this.health = health;
	}
	
	public char getGender() {
		return (gender ? 'm' : 'f');
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Health getHealth() {
		return health;
	}
	
	public abstract boolean aDayPasses();
	
}