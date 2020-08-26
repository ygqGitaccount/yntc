package yntc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yntc.service.AppraiseService;
import yntc.service.OrderService;
import yntc.service.impl.AppraiseServiceImpl;
import yntc.service.impl.OrderServiceImpl;

@WebServlet("/AppraiseServlet")
public class AppraiseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
       response.setContentType("text/html;charset=utf-8");
       
       HttpSession session=request.getSession();
       String action=(String)request.getParameter("action");
       
       AppraiseService as=new AppraiseServiceImpl();
       OrderService os = new OrderServiceImpl();
       if("addAppraise".equals(action)) {
    	  String Goodsid=request.getParameter("goodsid");
    	  Integer goodsid=null;
    	  if(Goodsid!=null && !"".equals(Goodsid)) {
    		  goodsid=Integer.parseInt(Goodsid);
    	  }
    	  String Oid=request.getParameter("oid");
    	  Integer oid=null;
    	  if(Oid!=null && !"".equals(Oid)) {
    		  oid=Integer.parseInt(Oid);
    	  }
    	  String content=request.getParameter("content");  
    	  //OrderService os = new OrderServoceImpl();
          as.addAppraise(session, goodsid, content);
          //os.thUpdateoOrderTh(oid);
          request.getRequestDispatcher("/OrderServlet?action=updateOrderstateAppraise&oid="+oid).forward(request, response);
       }
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
