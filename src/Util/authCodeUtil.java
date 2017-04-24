package Util;

import java.awt.Color;
import java.util.Random;

/**
 * 随机数字与颜色
 * @author QuanJun
 *
 */
public class authCodeUtil {
	//随机字符字典
	public static final char[] chars = {
		'2','3','4','5','6','7','8','9',
		'A','B','C','D','E','F','G','H',
		'J','K','L','M','N','P','Q','R',
		'S','T','U','V','W','X','Y','Z'
	};
	//产生随机数
	public static Random random = new Random();
	//获取六位随机数
	public static String getRandomString(){
		StringBuffer buffer = new StringBuffer();
		for(int i=0;i<6;i++){
			buffer.append(chars[random.nextInt(chars.length)]);
		}
		return buffer.toString();
	}
	//获取随机的颜色
	public static Color getRandomColor(){
		return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
	}
	//获取随机颜色的反色
	public static Color getReversColor(Color c){
		return new Color(255 - c.getRed(),255 - c.getGreen(),255 - c.getBlue());
	}
}
