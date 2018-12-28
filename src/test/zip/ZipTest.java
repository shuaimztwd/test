package test.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipTest {

	public static void main(String[] args) throws IOException {
		ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(
				new File("d:" + File.separator + "1.zip")));
		File dir = new File("d:" + File.separator + "2");
		for (File f : dir.listFiles()) {
			InputStream fis = new FileInputStream(f);
			ZipEntry ze = new ZipEntry(dir.getName() + File.separator
					+ f.getName());
			zipOut.putNextEntry(ze);
			int len = 0;
			byte[] b = new byte[10];
			while ((len = fis.read(b)) != -1) {
				zipOut.write(b, 0, len);
			}
			fis.close();
		}
		zipOut.setComment("测试压缩文件1");
		zipOut.close();
	}

}
