package test.settest;

import java.util.HashSet;
import java.util.Set;

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Person)) {
			return false;
		}
		Person other = (Person) obj;
		if (this.getAge() == other.getAge()
				&& this.getName().equals(this.getName())) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return this.getName() + "，" + this.getAge();
	}
}

public class SetTest2 {

	public static void main(String[] args) {
		Set<Person> set = new HashSet<>();
		set.add(new Person("张三", 31));
		set.add(new Person("李四", 31));
		set.add(new Person("王五", 32));
		set.add(new Person("王五", 32));
		set.add(new Person("赵六", 33));
		set.add(new Person("李四", 31));
		set.add(new Person("孙七", 34));
		for (Person p : set) {
			System.out.println(p);
		}
	}
}
