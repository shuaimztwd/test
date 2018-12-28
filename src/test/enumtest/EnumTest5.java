package test.enumtest;

interface Print {
	String getColor();
}

enum Color1 implements Print {
	RED {
		@Override
		public String getColor() {
			return "red";
		}

		@Override
		public void print() {
			System.out.println(this);
		}
	},
	GREEN {
		@Override
		public void print() {
			System.out.println(this);
		}
	};

	@Override
	public String getColor() {
		return "null";
	}

	public abstract void print();
}

public class EnumTest5 {

	public static void main(String[] args) {
		Color1 c = Color1.RED;
		System.out.println(c.getColor());
		c.print();
		c = Color1.GREEN;
		System.out.println(c.getColor());
		c.print();
	}
}
