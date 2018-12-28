package test.system;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class SystemTest {

	public static void main(String[] args) throws IOException {
		OutputStream out = System.out;
		out.write("hello world\n".getBytes());
		out.close();
		String str = "hello";
		try {
			System.out.println(Integer.parseInt(str));
		} catch (Exception e) {
			PrintStream ps = System.err;
			ps.println(e);
			StackTraceElement[] elem = e.getStackTrace();
			for (int i = 0; i < elem.length; i++) {
				ps.println("\tat " + elem[i]);
			}
		}
	}
}
