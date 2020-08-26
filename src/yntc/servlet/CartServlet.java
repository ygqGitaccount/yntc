package yntc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yntc.domain.Cart;
import yntc.domain.User;
import yntc.service.CartService;
import yntc.service.impl.CartServiceImpl;


public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=utf-8");
	        
	        String action =(String)request.getParameter("action");
	        String ids =request.getParameter("id");
	        HttpSession session =request.getSession();
	       // User user =(User) session.getAttribute("user");
	        //User user = (User)session.getAttribute("user");
	        //System.out.println(user.getId());
	        //System.out.println("hhh");
	        String buynum=request.getParameter("buyNum");
            String Cids=request.getParameter("cid");
            String Number=request.getParameter("number");
            String State=request.getParameter("state");
            Integer storeid=null;
            Integer number=null;
        	Integer cid=null;
        	if(State!=null&&!"".equals(State)) {
        		storeid=Integer.parseInt(State);
        	}
        	if(Cids!=null&&!"".equals(Cids)) {
        		cid=Integer.parseInt(Cids);
        	}
        	if(Number!=null&&!"".equals(Number)) {
        		number=Integer.parseInt(Number);
        	}
        	//System.out.println(cid);
	        Integer id=null;
	        Integer buyNum=null;
	        
	    	//System.out.println("hhh");
	    	
	        if(ids!=null&&!"".equals(ids)) {
	  			id=Integer.parseInt(ids);
	  		}
	        if(buynum!=null&&!"".equals(buynum)) {
	  			buyNum=Integer.parseInt(buynum);
	  		}
	        
	        //System.out.println(buyNum);
	        //System.out.println(id);
	        CartService cs =new CartServiceImpl();
	        if("addCart".equals(action)) {
	           cs.addCart(id, buyNum,storeid,session); 
	            response.getWriter().write("加入成功，1秒后跳转");
				response.setHeader("refresh","1;url="+request.getContextPath()+"/GoodsServlet?action=findGoodsById&id="+id+"&state="+storeid);
				return;
	        }else if("clickShopping".equals(action)) {
	        	List<Cart> lc=cs.findCartGoodsByState(session);
	        	//System.out.println("ll");
	        	//System.out.println(user.getId());
	        	request.setAttribute("lc", lc);
				request.getRequestDispatcher("/shoppingCart.jsp").forward(request,response);
	        	//response.sendRedirect("./shoppingCart.jsp");
				return;
	        }else if("delCartGoodsByCid".equals(action)) {
	        	cs.delCartGoodsByCid(cid);                                                                                                                                                                                            
	        	request.setAttribute("cs", cs);
				request.getRequestDispatcher("/CartServlet?action=clickShopping").forward(request,response);
				 return;
	        }else if("updateCartNumber".equals(action)) {
	        	cs.updateCartNumber(cid, number);
	        	request.setAttribute("cs", cs);
				request.getRequestDispatcher("/CartServlet?action=clickShopping").forward(request,response);
				 return;
	        }else if("clickCount".equals(action )) {
	        	List<Cart> lc=cs.findCartGoodsByState(session);
	        	request.setAttribute("lc", lc);
				request.getRequestDispatcher("/order.jsp").forward(request,response);
				return;
	        }else if("updateCartGoods".equals(action)) {
	        	String cids=request.getParameter("cids");
	        	String Totalprice=request.getParameter("totalprice");
				Integer totalprice=null;
				if(Totalprice!=null && !"".equals(Totalprice)) {
					totalprice=Integer.parseInt(Totalprice);
				}
	        	int i=cs.updateCartGoods(cids);
	        	if(i>0) {
	        		request.getRequestDispatcher("/UserServlet?action=updateUserBalanceReduce&totalprice="+totalprice).forward(request, response);
	        		//response.sendRedirect("./shoppingCart.jsp");
	        	}
	        }
	        
	        
	        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
