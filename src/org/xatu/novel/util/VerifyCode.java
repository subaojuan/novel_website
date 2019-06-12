package org.xatu.novel.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
/**
 * 验证码工具类。可以生成图片。
 * 其中包含4个数字或字母，并且提供了可以获取其中数字或字母的方法。
 * @author Feng
 * 2019年1月24日上午10:42:46
 */
public class VerifyCode {

	private int width = 100;//宽度
	private int height = 35;//高度
	private Random random = new Random();
	private String[] fontName = {"宋体","华文楷体","黑体","隶书","微软雅黑","Tahoma","Segoe Print"};
	//字符
	private String codes = "0123456789qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";
	private Color bgColor = new Color(255, 255, 255);//验证码的背景色
	private String text;//服务器端保存验证码的字符串。用于和客户输入的验证码比较
	
	/**
	 * 获取到随机的颜色，通过rgb的随机获取组合成随机颜色。
	 * @return 随机的颜色
	 */
	private Color randomColor(){
		
		int red = random.nextInt(255);
		int green = random.nextInt(255);
		int blue = random.nextInt(255);
		
		return new Color(red, green, blue);
	}
	
	/**
	 * 获取随机的字体
	 * @return
	 */
	private Font randomFont(){
		int index = random.nextInt(fontName.length);
		//获取一个随机的字体名字。
		String fName = fontName[index];
		//style有0,1,2,3这四种格式。0表示正常，1表示加粗，2表示斜体，3表示加粗斜体
		int style = random.nextInt(4);
		int size = random.nextInt(6)+20;//字体大小
		
		return new Font(fName,style,size);
	}
	
	/**
	 * 生成一个字符。
	 * @return
	 */
	private char randomChar(){
		
		int index = random.nextInt(codes.length());
		return codes.charAt(index);
	}
	
	//画干扰线
	public void drawLine(BufferedImage image){
		
		Graphics2D graph =  (Graphics2D) image.getGraphics();//得到画笔
		int len = random.nextInt(3)+3;
		//生成两个坐标点，4个值
		for(int i=0;i<len;i++){
			int x1 = random.nextInt(width);
			int y1 = random.nextInt(height);
			int x2 = random.nextInt(width);
			int y2 = random.nextInt(height);
			
			graph.setColor(randomColor());//设置笔的颜色
			graph.setStroke(new BasicStroke(1.2f));//设置线的粗细
			
			graph.drawLine(x1, y1, x2, y2);//画线
		}
	}
	
	//创建BufferedImage对象    矩型
	public BufferedImage createImage(){
		//创建图片缓冲区
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics2D graph =  (Graphics2D) image.getGraphics();//得到画笔
		//设置笔的颜色
		graph.setColor(bgColor);
		graph.fillRect(0, 0, width, height);
		return image;
	}
	//图片上画4个字符
	public BufferedImage getImage(){
		BufferedImage image = createImage();//得到矩型
		Graphics2D graph =  (Graphics2D) image.getGraphics();//得到画笔
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {//向图片上画4个字符
			String str = randomChar()+"";
			sb.append(str);
			graph.setFont(randomFont());//设置画笔的字体
			graph.setColor(randomColor());//设置画笔的颜色
			float x = i * 1.0f * width / 4;//设置当前字符的X位置
			graph.drawString(str, x, height-5);
		}
		
		text = sb.toString();//4个字符
		drawLine(image);
		return image;
	}
	
	
	//得到字符串
	public String getText(){
		return text;
	}
	
	
	//保存图片到指定位置
	public void output(BufferedImage image,OutputStream out){
		try {
			ImageIO.write(image, "JPEG", out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
