package authCode;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import Util.authCodeUtil;

public class authCodeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 public authCodeUtil ac = new authCodeUtil();

	@Override
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//输出类型
		response.setContentType("image/jpeg");
		
		//随机产生的字符串放入Session中
		String randomString = ac.getRandomString();
		request.getSession(true).setAttribute("randomString", randomString);
		
		//图片宽高
		int width = 100;
		int height = 30;	
		//颜色和反色
		Color color = ac.getRandomColor();
		Color reverse = ac.getReversColor(color);		
		//色彩图片
		BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//绘图对象并设置相关属性
		Graphics2D g = bi.createGraphics();
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
		g.setColor(color);
		g.fillRect(0, 0, width, height);
		g.setColor(reverse);
		g.drawString(randomString, 18, 20);
		//随机100个噪音点
		for(int i = 0,n=ac.random.nextInt(100);i<n;i++){
			g.drawRect(ac.random.nextInt(width), ac.random.nextInt(height), 1, 1);
		}
		
		//转成JPEG格式
		ServletOutputStream out = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		//对图片进行编码
		encoder.encode(bi);
		
		out.flush();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doGet(request, response);
	}
}
