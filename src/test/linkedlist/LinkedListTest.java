package test.linkedlist;

import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		LinkedList<String> link = new LinkedList<>();
		link.add("a");
		link.add("b");
		link.add("c");
		for (int i = 0; i < link.size();) {
			System.out.println(link.poll());
		}
	}
}
