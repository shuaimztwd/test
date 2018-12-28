package test.charsettest;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.SortedMap;

public class CharsetTest {

	public static void main(String[] args) throws Exception {
		// test1();
		Charset charset = Charset.forName("UTF-8");
		CharsetEncoder encoder = charset.newEncoder();
		CharsetDecoder decoder = charset.newDecoder();

		File f = new File("D:\\2\\data.txt");
		FileInputStream in = new FileInputStream(f);
		FileChannel fc = in.getChannel();
		ByteBuffer buf = ByteBuffer.allocate((int) f.length());
		fc.read(buf);
		buf.flip();
		ByteBuffer enBuf = encoder.encode(CharBuffer.wrap(new String(buf
				.array())));
		enBuf.flip();
		String str = new String(enBuf.array());
		System.out.println("encode = " + str);
		enBuf.limit((int) f.length());
		CharBuffer deBuf = decoder.decode(enBuf);
		System.out.println("decode = " + deBuf);
		in.close();
	}

	private static void test1() {
		SortedMap<String, Charset> map = Charset.availableCharsets();
		Iterator<Entry<String, Charset>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, Charset> en = it.next();
			System.out.println(en.getKey() + " --> " + en.getValue());
		}
	}
}
