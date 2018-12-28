package test.printstream;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {

	public static void main(String[] args) throws IOException {
		System.out.write("hello world\n".getBytes());
		PrintStream ps = new PrintStream(System.out);
		ps.println("hello world");
	}

}
