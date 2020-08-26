package yntc.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import yntc.domain.User;
import yntc.domain.UserForm;
import yntc.service.UserService;
import yntc.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理请求乱码
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
       //创建UserForm对象
        UserForm uf = new UserForm();
        
        //获取表单数据
        Map<String,String[]> map = request.getParameterMap();
         try {
			BeanUtils.populate(uf, map);
			 Boolean bool = uf.validate();
			 if(!bool) {
				 request.setAttribute("uf", uf);
				 request.getRequestDispatcher("register.jsp").forward(request,response);
				 return;
			 }
		} catch (Exception e) {
		    e.printStackTrace();
		}
        
        //封装实体
        User user = new User();
        try {
			//ConvertUtils.register(new DateLocaleConverter(),Date.class);
			BeanUtils.populate(user,map);
			//调用业务逻辑
			UserService us = new UserServiceImpl();
			us.registerUser(user);
		}  catch (Exception e) {
			e.printStackTrace();
		}
        //分发转向
        response.getWriter().write("注册成功，1秒后跳转");
        response.setHeader("refresh", "1; url="+request.getContextPath()+"/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
