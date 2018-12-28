import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class TestImage {

	private static final String[] nameArr = { "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙",
			"赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙",
			"赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙",
			"赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙",
			"赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙",
			"赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙",
			"赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙",
			"赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙",
			"赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙",
			"赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙",
			"赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙",
			"赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙", "赵钱孙" };
	private static final int[] ordArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
			12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
			29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45,
			46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62,
			63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
			80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96,
			97, 98, 99 };
	private static final String srcImgPath = "D:/1.png";

	public static void main(String[] args) throws IOException {
		File srcImgFile = new File(srcImgPath);
		Map<String, String> contentMap = new HashMap<>();
		Map<String, Color> colorMap = new HashMap<>();
		Map<String, Font> fontMap = new HashMap<>();
		Map<String, Integer> xpMap = new HashMap<>();
		Map<String, Integer> ypMap = new HashMap<>();
		Font nameFont = new Font("华文行楷", Font.PLAIN, 40);
		// Font nameFont = new Font("黑体", Font.PLAIN, 32);
		Color nameColor = new Color(231, 121, 0);
		Font ordFont = new Font("华文行楷", Font.BOLD, 38);
		// Font ordFont = new Font("黑体", Font.BOLD, 35);
		Color ordColor = new Color(220, 20, 60);
		for (int i = 0; i < nameArr.length; i++) {
			System.out.println("正在处理第" + (i + 1) + "张图片");
			String tarImgPath = "D:/2/" + (i + 1) + ".png";
			contentMap.clear();
			colorMap.clear();
			fontMap.clear();
			xpMap.clear();
			ypMap.clear();
			String name = nameArr[i];
			int x = 157 - name.length() * 32; // 华文行楷
			// int x = 157 - name.length() * 28; // 黑体

			contentMap.put("name", name);
			colorMap.put("name", nameColor);
			fontMap.put("name", nameFont);
			xpMap.put("name", x);
			ypMap.put("name", 293);

			int ord = ordArr[i];
			x = (ord < 9 ? 220 : 210); // 华文行楷
			// x = (ord < 9 ? 225 : 215); // 黑体
			String ordStr = "第" + ord + "位";
			contentMap.put("ord", ordStr);
			colorMap.put("ord", ordColor);
			fontMap.put("ord", ordFont);
			xpMap.put("ord", x);
			ypMap.put("ord", 435);
			addDrawStr(srcImgFile, tarImgPath, contentMap, colorMap, fontMap,
					xpMap, ypMap);
		}
	}

	private static void addDrawStr(File srcImgFile, String tarImgPath,
			Map<String, String> contentMap, Map<String, Color> colorMap,
			Map<String, Font> fontMap, Map<String, Integer> xpMap,
			Map<String, Integer> ypMap) {
		try {
			Image srcImg = ImageIO.read(srcImgFile);
			int srcImgWidth = srcImg.getWidth(null);
			int srcImgHeight = srcImg.getHeight(null);
			BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g = bufImg.createGraphics();
			g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
			for (String key : contentMap.keySet()) {
				g.setColor(colorMap.get(key));
				g.setFont(fontMap.get(key));
				g.drawString(contentMap.get(key), xpMap.get(key),
						ypMap.get(key));
			}
			g.dispose();
			FileOutputStream outImgStream = new FileOutputStream(tarImgPath);
			ImageIO.write(bufImg, "jpg", outImgStream);
			outImgStream.flush();
			outImgStream.close();
			System.out.println("添加文字完成");
		} catch (Exception e) {
		}
	}
}
