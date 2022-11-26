package entities;

import com.github.javafaker.Faker;


public class Person {

	private String name;
	private String surname;

	final static Faker faker = new Faker();

	public Person() {
		this.name = faker.name().firstName();
		this.surname = faker.name().lastName();
	}

	@Override
	public String toString() {
		return String.format("%s %s", name, surname);
	}

}