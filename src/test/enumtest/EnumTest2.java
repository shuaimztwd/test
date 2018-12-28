package test.enumtest;

public class EnumTest2 {

	public static void main(String[] args) {
		for (Color c : Color.values()) {
			System.out.println(c.ordinal() + " --> " + c.name());
		}
		System.out.println(Color.valueOf(Color.class, "GREEN"));
	}
}
