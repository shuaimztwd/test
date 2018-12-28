package test.enumtest;

import java.util.EnumMap;
import java.util.Map;

public class EnumTest3 {

	public static void main(String[] args) {
		Map<Color, String> enumMap = new EnumMap<>(Color.class);
		enumMap.put(Color.BLUE, "blue");
		enumMap.put(Color.RED, "red");
		enumMap.put(Color.GREEN, "green");
		for (Color c : Color.values()) {
			System.out.println(c.name() + " --> " + enumMap.get(c));
		}

		for (Color c : enumMap.keySet()) {
			System.out.print(c + "、");
		}

		for (String str : enumMap.values()) {
			System.out.print(str + "、");
		}
	}
}
