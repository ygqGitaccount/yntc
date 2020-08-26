package yntc.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io 

.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckImgServlet
 */
public class CheckImagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CheckImagServlet() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 	StringBuffer sb = new StringBuffer();
		int width = 110;
		int height = 25;
		//在内存中创建一个图像对象
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//创建一个画笔
		Graphics g = img.getGraphics();
		
		//给图片添加背景色
		g.setColor(Color.PINK);//设置一个颜色
		g.fillRect(1, 1, width-2, height-2);//填充颜色
		
		//给边框一个色
		g.setColor(Color.RED);
		g.drawRect(0, 0, width-1, height-1);//设置边框的显示坐标
		
		//设置文本样式
		g.setColor(Color.BLUE);
		g.setFont(new Font("宋体", Font.BOLD|Font.ITALIC, 15));
		
		//给图片添加文本
		Random rand = new Random();
		int position = 20;
		
		for (int i = 0; i < 4; i++) {
			int c = rand.nextInt(10);
			String str= String.valueOf(c);
			sb.append(str);
			g.drawString(str, position, 20);//给图片填充文本
			position+=20;
		}
		
		//添加9条干扰线
		for (int i = 0; i < 6; i++) {
			g.drawLine(rand.nextInt(width), rand.nextInt(height), rand.nextInt(width), rand.nextInt(height));
		}
		request.getSession().setAttribute("code", sb.toString());
		//System.out.println(sb);
		//将图片对象以流的方式输出的客户端
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
