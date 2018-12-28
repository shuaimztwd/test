package test.enumtest;

import java.util.EnumSet;
import java.util.Set;

public class EnumTest4 {

	public static void main(String[] args) {
		Set<Color> enumSet = EnumSet.allOf(Color.class);
		print(enumSet);
		enumSet = EnumSet.of(Color.BLUE);
		print(enumSet);
	}

	private static void print(Set<Color> enumSet) {
		for (Color c : enumSet) {
			System.out.println(c);
		}
	}
}
