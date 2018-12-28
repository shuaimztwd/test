package test.nettest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class SocketClient {

	public static void main(String[] args) throws IOException {
		Socket client = new Socket("localhost", 8888);
		System.out.println("**********Client连接Server成功**********");
		PrintStream print = new PrintStream(client.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(
				client.getInputStream()));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		boolean flag = true;
		while (flag) {
			String str = in.readLine();
			System.out.println("开始发送数据：" + str);
			print.println(str);
			if (str == null || "".equals(str) || "bye".equals(str)) {
				flag = false;
			} else {
				String echo = br.readLine();
				System.out.println("接收到Server返回值：" + echo);
			}
		}
		br.close();
		client.close();
		System.out.println("**********Client断开**********");
	}
}
