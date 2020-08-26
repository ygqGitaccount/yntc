package yntc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yntc.domain.Collect;
import yntc.service.CollectService;
import yntc.service.impl.CollectServiceImpl;

/**
 * Servlet implementation class CollectServlet
 */
@WebServlet("/CollectServlet")
public class CollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //设置请求和响应的编码方式
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		HttpSession session=request.getSession();
		String Goodsid=request.getParameter("goodsid");
		String action =request.getParameter("action");
		Integer goodsid=null;
		if(Goodsid!=null && !"".equals(Goodsid)) {
			goodsid=Integer.parseInt(Goodsid);
		}
		
		CollectService cs=new CollectServiceImpl();
		if("addCollect".equals(action)) {
			String State=request.getParameter("state");
			Integer state=null;
	    	if(State!=null && !"".equals(State)) {
	    		state=Integer.parseInt(State);
;	    	}
			int i=cs.addCollect(goodsid, session);
			if(i>0) {
                response.getWriter().write("加入成功，1秒后跳转");
                response.setHeader("refresh", "1,url="+request.getContextPath()+"/GoodsServlet?action=findGoodsById&id="+goodsid+"&state="+state);
			}
		}else if("findCollect".equals(action)) {
			
			List<Collect> lc=cs.findCollectByUserid(session);
		    request.getSession().setAttribute("lc", lc);
		    response.sendRedirect("./myCollect.jsp");
		}else if("cancelCollect".equals(action)) {
			String Cid=request.getParameter("cid");
			Integer cid=null;
			if(Cid!=null && !"".equals(Cid)) {
				cid=Integer.parseInt(Cid);
			}
			cs.cancelCollect(cid);
			request.getRequestDispatcher("/CollectServlet?action=findCollect").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
