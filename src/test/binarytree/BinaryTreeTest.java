package test.binarytree;

class Person implements Comparable<Person> {

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
	}

	@Override
	public int compareTo(Person o) {
		if (this.getAge() > o.getAge()) {
			return -1;
		} else if (this.getAge() < o.getAge()) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "name = " + this.getName() + "，age = " + this.getAge();
	}
}

class BinaryTree {
	class Node {
		private Person data;
		private Node left;
		private Node right;

		public Node(Person data) {
			this.data = data;
		}

		public void addNode(Node n) {
			if (this.data.compareTo(n.data) > 0) {
				if (this.left == null) {
					this.left = n;
				} else {
					this.left.addNode(n);
				}
			}
			if (this.data.compareTo(n.data) < 0) {
				if (this.right == null) {
					this.right = n;
				} else {
					this.right.addNode(n);
				}
			}
		}

		public void print() {
			if (this.left != null) {
				this.left.print();
			}
			System.out.println(this.data);
			if (this.right != null) {
				this.right.print();
			}
		}
	}

	private Node root;

	public void add(Person data) {
		Node n = new Node(data);
		if (this.root == null) {
			this.root = n;
		} else {
			this.root.addNode(n);
		}
	}

	public void print() {
		this.root.print();
	}
}

public class BinaryTreeTest {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.add(new Person("A", 30));
		bt.add(new Person("B", 25));
		bt.add(new Person("C", 41));
		bt.add(new Person("D", 56));
		bt.add(new Person("E", 12));
		bt.add(new Person("F", 34));
		bt.add(new Person("G", 27));
		bt.add(new Person("H", 64));
		bt.print();
	}
}
