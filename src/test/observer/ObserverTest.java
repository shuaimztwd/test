package test.observer;

import java.util.Observable;
import java.util.Observer;

class Person extends Observable {

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
		super.setChanged();
		super.notifyObservers(1);
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
		super.setChanged();
		super.notifyObservers(2);
	}
}

class PersonObserver implements Observer {

	private String obName;

	public PersonObserver(String obName) {
		this.obName = obName;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof Integer) {
			int flag = ((Integer) arg).intValue();
			Person p = (Person) o;
			switch (flag) {
			case 1:
				System.out.println(obName + "观察到名字被修改为：" + p.getName());
				break;
			case 2:
				System.out.println(obName + "观察到年龄被修改为：" + p.getAge());
				break;
			}
		}
	}

}

public class ObserverTest {

	public static void main(String[] args) {
		Person p = new Person("张三", 20);
		PersonObserver po1 = new PersonObserver("观察者1");
		PersonObserver po2 = new PersonObserver("观察者2");
		PersonObserver po3 = new PersonObserver("观察者3");
		PersonObserver po4 = new PersonObserver("观察者4");
		PersonObserver po5 = new PersonObserver("观察者5");
		p.addObserver(po1);
		p.addObserver(po2);
		p.addObserver(po3);
		p.addObserver(po4);
		p.addObserver(po5);
		p.setName("李四");
		p.setAge(30);
	}

}
