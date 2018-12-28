package test.settest;

import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		Set<String> set = new TreeSet<>();
		set.add("1C");
		set.add("2A");
		set.add("3D");
		set.add("4B");
		set.add("2A");
		for (String s : set) {
			System.out.println(s);
		}
	}
}
