package test.nettest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class NetTest {

	public static void main(String[] args) throws IOException {
		InetAddress locAdd = InetAddress.getLocalHost();
		InetAddress remAdd = InetAddress.getByName("www.jiuyihao.com");
		System.out.println(locAdd.getHostAddress());
		System.out.println(remAdd.getHostAddress());

		URL url = new URL("https://www.jiuyihao.com");
		URLConnection urlcon = url.openConnection();
		System.out.println(urlcon.getContentLength());
		System.out.println(urlcon.getContentType());
		Scanner scan = new Scanner(urlcon.getInputStream());
		scan.useDelimiter("\n");
		while (scan.hasNext()) {
			System.out.println(scan.next());
		}
		scan.close();
	}
}
