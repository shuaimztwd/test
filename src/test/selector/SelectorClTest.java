package test.selector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Random;

public class SelectorClTest {

	public static void main(String[] args) throws Exception {
		int[] ports = { 8000, 8001, 8002 };
		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			int idx = r.nextInt(3);
			Socket client = new Socket("localhost", ports[idx]);
			PrintStream print = new PrintStream(client.getOutputStream());
			print.println(i + "请求端口" + ports[idx]);
			BufferedReader buf = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			String str = null;
			while ((str = buf.readLine()) != null) {
				System.out.println(str);
			}
			client.close();
		}
	}
}
