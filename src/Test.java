import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {

	public static void main(String[] args) throws IOException, ParseException {
		String path = "D:\\1\\";
		String toPath = "D:\\2\\";
		String cDate = "2018-02-07 18:01:02";
		File dir = new File(path);
		for (File f : dir.listFiles()) {
			if (!f.isFile()) {
				continue;
			}
			Path fp = f.toPath();
			System.out.println(fp.getFileName()
					+ "----------------------------------------");
			System.out.println("创建日期:"
					+ Files.getAttribute(fp, "basic:creationTime"));// 创建时间
			System.out.println("访问日期:"
					+ Files.getAttribute(fp, "basic:lastAccessTime"));// 访问时间
			System.out.println("修改日期:"
					+ Files.getAttribute(fp, "basic:lastModifiedTime"));// 修改时间
			System.out.println(Files.getOwner(fp));
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			FileTime fileTime = FileTime.fromMillis(sdf.parse(cDate).getTime());
			Files.setAttribute(f.toPath(), "basic:creationTime", fileTime);
			Files.setAttribute(f.toPath(), "basic:lastAccessTime", fileTime);
			Files.setAttribute(f.toPath(), "basic:lastModifiedTime", fileTime);
			File toFile = new File(f.getAbsolutePath().replace(path, toPath));
			if (toFile.exists()) {
				toFile.delete();
			}
			Files.copy(new FileInputStream(f), toFile.toPath());
		}
	}
}
