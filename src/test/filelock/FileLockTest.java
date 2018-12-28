package test.filelock;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockTest {

	public static void main(String[] args) throws Exception {
		// FileInputStream in = new FileInputStream(new
		// File("D:\\2\\data.txt")); // 不能通过FileInputStream获取channel文件锁
		File f = new File("D:\\2\\data.txt");
		FileInputStream in = new FileInputStream(f);
		FileChannel fcin = in.getChannel();
		ByteBuffer buf = ByteBuffer.allocate((int) f.length());
		fcin.read(buf);

		FileOutputStream out = new FileOutputStream(f, true); // 无法在映射区域打开
		FileChannel fcout = out.getChannel();
		FileLock fl = fcout.tryLock();
		System.out.println(fl.isShared());
		System.out.println(fl.isValid());
		System.out.println(fl);
		System.out.println("文件锁定");
		Thread.sleep(30000);
		buf.flip();
		while (buf.hasRemaining()) {
			fcout.write(buf);
		}
		fl.release();
		System.out.println("文件解锁");
		fl.close();
		fcout.close();
		in.close();
		out.close();
	}
}
