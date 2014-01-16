package com.slengineering.data;

public final class Person {

	// region Properties

	private long id;
	private String name;
	private int age;
	private String sex;
	private String city;

	// endregion

	// region Get / Set

	public long getId() {
		return id;
	}

	public Person setId(long id) {
		this.id = id;

		return this;
	}

	public String getName() {
		return name;
	}

	public Person setName(String name) {
		this.name = name;

		return this;
	}

	public int getAge() {
		return age;
	}

	public Person setAge(int age) {
		this.age = age;

		return this;
	}

	public String getSex() {
		return sex;
	}

	public Person setSex(String sex) {
		this.sex = sex;

		return this;
	}

	public String getCity() {
		return city;
	}

	public Person setCity(String city) {
		this.city = city;

		return this;
	}

	// endregion

}
