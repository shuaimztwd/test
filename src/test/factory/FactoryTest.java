package test.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

interface Fruit {
	void eat();
}

class Apple implements Fruit {

	@Override
	public void eat() {
		System.out.println("eat apple");
	}
}

class Orange implements Fruit {

	@Override
	public void eat() {
		System.out.println("eat orange");
	}
}

class FruitFactory {

	public static Fruit getNewInstance(String className) {
		Fruit fruit = null;
		try {
			fruit = (Fruit) Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return fruit;
	}
}

class Init {
	public static Properties getPro() {
		Properties pro = new Properties();
		File f = new File(
				"D:\\workspace\\Test\\src\\test\\factory\\pro.properties");
		if (f.exists()) {
			try {
				pro.load(new FileInputStream(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			pro.setProperty("apple", "test.factory.Apple");
			pro.setProperty("orange", "test.factory.Orange");
			try {
				pro.store(new FileOutputStream(f), "Fruit Init Class");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return pro;
	}
}

public class FactoryTest {

	public static void main(String[] args) {
		Properties pro = Init.getPro();
		Fruit f = FruitFactory.getNewInstance(pro.getProperty("apple"));
		f.eat();
		f = FruitFactory.getNewInstance(pro.getProperty("orange"));
		f.eat();
	}
}
