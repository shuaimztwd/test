package test.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test1 {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		Person p1 = new Person("张三", 20);
		Person p2 = new Person("李四", 30);
		Person p3 = new Person("王五", 40);
		Person[] arr = { p1, p2, p3 };

		File f = new File("D:" + File.separator + "test.dat"); // 定义保存路径
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(arr);

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
		Object[] arr1 = (Object[]) ois.readObject();
		for (Object o : arr1) {
			System.out.println(o);
		}
		oos.close();
		ois.close();
	}
}
