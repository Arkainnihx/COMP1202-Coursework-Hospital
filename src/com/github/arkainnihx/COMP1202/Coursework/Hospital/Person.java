package com.github.arkainnihx.COMP1202.Coursework.Hospital;

public abstract class Person {
	private boolean gender = true;
	private int age = 0;
	private String health = "healthy";
	
	public Person(char gender, int age, String health) {
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

	public String getHealth() {
		return health;
	}
	
	public abstract boolean aDayPasses();
	
}