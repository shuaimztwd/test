package test.niotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {

	public static void main(String[] args) throws IOException {
		String strArr = "作为一个优秀的开发人员最重要的当然就是技术能力,没有扎实的技术实力是无法通过企业面试的层层关卡的,\n在09年MLDN为广大学员带来了完备的知识体系,不管是现在公司的主流技术,还是未来将会流行的技术我们将一网打尽,为大家带来为期四个多月的JAVA饕餮盛宴。";
		File f = new File("D:\\2\\data.txt");
		FileOutputStream fos = new FileOutputStream(f);
		FileChannel fcOut = fos.getChannel();
		ByteBuffer outBuf = ByteBuffer.allocate(1024);
		outBuf.put(strArr.getBytes());
		outBuf.flip();
		fcOut.write(outBuf);
		fos.close();
		fcOut.close();

		FileInputStream fin = new FileInputStream(f);
		FileChannel fcIn = fin.getChannel();
		ByteBuffer buf = ByteBuffer.allocate((int) f.length());
		fcIn.read(buf);
		buf.flip();
		System.out.println(new String(buf.array()));
		// fcIn.close();

		// FileChannel fcIn1 = fin.getChannel();
		MappedByteBuffer mbb = fcIn.map(FileChannel.MapMode.READ_ONLY, 0,
				f.length());
		byte[] data = new byte[(int) f.length()];
		int foot = 0;
		while (mbb.hasRemaining()) {
			data[foot++] = mbb.get();
		}
		System.out.println(new String(data));
		fcIn.close();
		fin.close();
	}
}
