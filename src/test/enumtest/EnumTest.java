package test.enumtest;

public class EnumTest {

	public static void main(String[] args) {
		for (Color c : Color.values()) {
			System.out.println(c);
		}
		for (Color c : Color.values()) {
			switch (c) {
			case GREEN: {
				System.out.println("green");
				break;
			}
			case RED: {
				System.out.println("red");
				break;
			}
			case BLUE: {
				System.out.println("blue");
				break;
			}
			default: {
				System.out.println("null");
				break;
			}
			}
		}
	}

}
