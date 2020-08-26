package yntc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yntc.domain.Notice;
import yntc.service.NoticeService;
import yntc.service.impl.NoticeServiceImpl;

@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("utf-8");
	  response.setContentType("text/html;charset=utf-8");
	  
	  String action =(String)request.getParameter("action");
	  String title =request.getParameter("title");
	  String content=request.getParameter("content");
	  String Id=request.getParameter("id");
	  Integer id=null;
	  if(Id!=null && !"".equals(Id)){
		  id=Integer.parseInt(Id);
	  }
	  
	  NoticeService ns =new NoticeServiceImpl();
	  if("findNotice".equals(action)) {
		List<Notice> ln=ns.findNiotice();
		request.getSession().setAttribute("ln", ln);
		response.sendRedirect("./backstage/admin/notice.jsp");
	  }else if("addNotice".equals(action)) {
		ns.addNotice(title, content);
		request.getRequestDispatcher("/NoticeServlet?action=findNotice").forward(request, response);   
	  }else if("findNoticeById".equals(action)) {
		Notice notice=ns.findNoticeById(id);
		request.getSession().setAttribute("notice", notice);
		response.sendRedirect("./backstage/admin/updateNotice.jsp");
	  }else if("updateNotice".equals(action)) {
		 ns.updateNotice(title, content, id);
		 request.getRequestDispatcher("/NoticeServlet?action=findNotice").forward(request, response);   
	  }else if("delNoticeById".equals(action)) {
		 ns.delNoticeById(id);
		 request.getRequestDispatcher("/NoticeServlet?action=findNotice").forward(request, response);   
	  }
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
