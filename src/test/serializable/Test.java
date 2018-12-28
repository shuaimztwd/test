package test.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		Person p1 = new Person("张三", 20);
		Person p2 = new Person("李四", 30);
		Person p3 = new Person("王五", 40);
		Person[] arr = { p1, p2, p3 };

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(arr);

		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		Object[] arr1 = (Object[]) ois.readObject();
		for (Object o : arr1) {
			System.out.println(o);
		}
		bos.close();
		oos.close();
		bis.close();
		ois.close();
	}
}
