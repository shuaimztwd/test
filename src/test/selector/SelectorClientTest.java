package test.selector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Random;

public class SelectorClientTest {
	public static void main(String[] args) throws Exception {
		int[] ports = { 8000, 8001, 8002 };
		Random r = new Random();
		for (int i = 0; i < 1000; i++) {
			int rdm = r.nextInt(3);
			Socket client = new Socket("localhost", ports[rdm]);
			BufferedReader re = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			PrintStream print = new PrintStream(client.getOutputStream());
			print.println(i + "a请求" + ports[rdm] + "端口");
			String str = re.readLine();
			System.out.println(str);
			client.close();
		}
	}
}
