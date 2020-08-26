package yntc.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import yntc.domain.Appraise;
import yntc.domain.Goods;
import yntc.domain.Notice;
import yntc.domain.User;
import yntc.service.AppraiseService;
import yntc.service.GoodsService;
import yntc.service.NoticeService;
import yntc.service.impl.AppraiseServiceImpl;
import yntc.service.impl.GoodsServiceImpl;
import yntc.service.impl.NoticeServiceImpl;

public class GoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GoodsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("utf-8");
	      response.setContentType("text/html;charset=UTF-8");
		 
	      String action =(String)request.getParameter("action");
	      HttpSession  session = request.getSession();
	      User user = (User)session.getAttribute("user");
	      String ids =request.getParameter("id");
	      Integer id=null;
	      if(ids!=null&&!"".equals(ids)) {
				id=Integer.parseInt(ids);
			}
	      String State=request.getParameter("state");
	    	Integer state=null;
	    	if(State!=null && !"".equals(State)) {
	    		state=Integer.parseInt(State);
;	    	}
	      GoodsService gs =new GoodsServiceImpl();
	      AppraiseService as =new AppraiseServiceImpl();
	      NoticeService ns =new NoticeServiceImpl();
	    if("findAll".equals(action)) {
	    	 try {
	 			List<Goods> lg=gs.findAll();
	 			request.getSession().setAttribute("lg", lg);
	 			 List<Notice> ln=ns.findNiotice();
	 			request.getSession().setAttribute("ln", ln);
	 		    //request.getRequestDispatcher("/index.jsp").forward(request,response);
	 			 response.sendRedirect("./index.jsp");
	 			  return;
	 		} catch (Exception e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	    }else if("findList".equals(action)) {
	    	try {
	    		
	 			List<Goods> lg=gs.findAll();
	 			  request.setAttribute("lg", lg);
	 			  request.getRequestDispatcher("/goodsList.jsp").forward(request,response);
	 			  return;
	 		} catch (Exception e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	    }else if("findGoodsById".equals(action)) {
	    	Goods goods=gs.findGoodsById(id);
	    	request.setAttribute("goods", goods);
	    	List<Goods> lg=gs.findGoodsByState(state);
	    	request.setAttribute("lg", lg);
	    	List<Appraise> la=as.findAppraiseById(id);
	    	request.setAttribute("la", la);
	    	request.getRequestDispatcher("/details.jsp").forward(request, response);
	    }else if("findMoreFood".equals(action)){
	    	List<Goods> lg=gs.findMoreFood();
			  request.setAttribute("lg", lg);
			  request.getRequestDispatcher("/goodsList.jsp").forward(request,response);
			//response.sendRedirect("./moreFood.jsp");
	    }else if("findMoreHandicraft".equals(action)) {
	    	List<Goods> lg=gs.findMoreHandicraft();
	    	request.setAttribute("lg", lg);
	    	request.getRequestDispatcher("/goodsList.jsp").forward(request,response);
	    	//response.sendRedirect("./moreHandicraft.jsp");
	    }else if("findMoreFruit".equals(action)) {
	    	List<Goods> lg=gs.findMoreFruit();
	    	//System.out.println("ttt");
	    	//System.out.println(lg);
	    	request.setAttribute("lg", lg);
	    	request.getRequestDispatcher("/goodsList.jsp").forward(request,response);
	    	//response.sendRedirect("./moreFruit.jsp");
	    }else if("findMoreMeat".equals(action)) {
	    	List<Goods> lg=gs.findMoreMeat();
	    	request.setAttribute("lg", lg);
	    	request.getRequestDispatcher("/goodsList.jsp").forward(request,response);
	    }else if("findMoreDryCargo".equals(action)) {
	    	List<Goods> lg=gs.findMoreDryCargo();
	    	request.setAttribute("lg", lg);
	    	request.getRequestDispatcher("/goodsList.jsp").forward(request,response);
	    }else if("findGoodsByState".equals(action)) {
	    	List<Goods> lg=gs.findGoodsByState(state);
	    	request.setAttribute("lg", lg);
	    	Goods storeName=gs.findStoreName(state);
	    	request.getSession().setAttribute("storeName", storeName);
	    	request.getRequestDispatcher("/inStore.jsp").forward(request, response);
	    }else if("searchGoodsByName".equals(action)) {
	    	String word =request.getParameter("word");
	    	List<Goods> lg=gs.searchGoodsByName(word);
	    	request.setAttribute("lg", lg);
	    	request.getRequestDispatcher("/goodsList.jsp").forward(request,response);
	    }else if("searchGoodsByLikeName".equals(action)) {
	    	String word =request.getParameter("word");
	    	List<String> list =gs.searchGoodsByLikeName(word);
	    	Gson gson =new Gson();
	    	String json = gson.toJson(list);
	    	//System.out.println(json);
	        response.getWriter().write(json);
	    }else if("findGoodsByType".equals(action)) {
	    	String type=request.getParameter("type");
	    	List<Goods> lg=gs.findGoodsByType(type,state);
	        request.getSession().setAttribute("lg", lg);
	        request.getRequestDispatcher("/inStore.jsp").forward(request, response);
	    }else if("findGoodsAll".equals(action)) {
	    	List<Goods> lg=gs.findGoodsAll(state);
	    	request.getSession().setAttribute("lg", lg);
	        request.getRequestDispatcher("/inStore.jsp").forward(request, response);
	    }
	  
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
