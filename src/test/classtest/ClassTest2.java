package test.classtest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Person {

	private String name;
	private int age;

	public Person() {
		super();
	}

	public Person(String name, int age) {
		this();
		this.setName(name);
		this.setAge(age);
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

	@Override
	public String toString() {
		return "name = " + this.getName() + "，age = " + this.getAge();
	}
}

public class ClassTest2 {

	public static void main(String[] args) throws Exception {
		// test1();
		test2();
	}

	private static void test1() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		Class<?> c1 = Class.forName("test.classtest.Person");
		Person per = (Person) c1.newInstance();
		per.setName("张三");
		per.setAge(40);
		System.out.println(per);
	}

	private static void test2() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			NoSuchMethodException, SecurityException, IllegalArgumentException,
			InvocationTargetException {
		Class<?> c1 = Class.forName("test.classtest.Person");
		Constructor<?> ct = c1.getConstructor(String.class, int.class);
		Person per = null;
		per = (Person) ct.newInstance("张三", 40);
		System.out.println(per);
	}
}
