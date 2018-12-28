package test.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class FileTest {

	public static void main(String[] args) throws IOException {
		File file = new File("d:" + File.separator + "text.txt");
		Reader r = new FileReader(file);
		char[] c = new char[1024];
		int len = r.read(c);
		r.close();
		System.out.println(new String(c, 0, len));

		Writer w = new FileWriter(new File("d:" + File.separator + "txtini"
				+ File.separator + "test.txt"), true);
		w.write(new String(c, 0, len));
		w.close();
	}

}
