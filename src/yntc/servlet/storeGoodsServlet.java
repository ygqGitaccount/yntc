package yntc.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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

import yntc.domain.Goods;
import yntc.domain.GoodsForm;
import yntc.domain.PageBean;
import yntc.domain.User;
import yntc.service.GoodsService;
import yntc.service.impl.GoodsServiceImpl;

/**
 */

public class storeGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public storeGoodsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //设置字符编码 
	  request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=UTF-8");
	 
      String action =(String)request.getParameter("action");
    
      //System.out.println(action);
      //System.out.println("hhhhhh");
      String ids =request.getParameter("id");
      //System.out.println(ids);
      Integer id=null;
      if(ids!=null&&!"".equals(ids)) {
			id=Integer.parseInt(ids);
		}
      
      GoodsService gs =new GoodsServiceImpl();
      HttpSession  session = request.getSession();
      User user = (User)session.getAttribute("user");
      String state =user.getState();
     if("addGoods".equals(action)) {
    	 if("0".equals(state)) {
			 response.getWriter().write("管理员审核未通过，你还没有该权限,2秒后跳转");
		     response.setHeader("refresh","2;url="+request.getContextPath()+"/backstage/goodsManager.jsp");
             return;
		 }
    	 GoodsForm gf=new GoodsForm();
         Map<String,String[]> map = request.getParameterMap();
         System.out.println("kkk");
         System.out.println(map);
         
    	 try {
 			BeanUtils.populate(gf, map);
 			 Boolean bool = gf.check();
 			 if(!bool) {
 				 request.setAttribute("gf", gf);
 				 request.getRequestDispatcher("/backstage/goodsManager.jsp").forward(request,response);
 				 return;
 			 }
 		} catch (IllegalAccessException e1) {
 			e1.printStackTrace();
 		} catch (InvocationTargetException e1) {
 			e1.printStackTrace();
 		}
    	 
    	  Goods goods = packGoods(request);//打包商品
    	   try {
			  gs.addGoods(goods,session);
			  //System.out.println(i);
			    response.getWriter().write("添加成功，1秒后跳转");
				response.setHeader("refresh","1;url="+request.getContextPath()+"/storeGoodsServlet?action=findGoodsByState");
				return;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("addGoods_message", e.getMessage());
			request.getRequestDispatcher("/backstage/goodsManager.jsp").forward(request,response);
			return;
		}
      }else if("findGoodsByState".equals(action)) {
    	  try {
    		  
    		  PageBean<Goods> pb= null;
				try {
					int pageSize=10;
					int currentPage=1;
					String currentPages = request.getParameter("currentPage");
					if(currentPages!=null) {
						currentPage =Integer.parseInt(currentPages);
					}
					pb = gs.findGoodsByState(currentPage,pageSize,session);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				request.getSession().setAttribute("pb", pb);
				request.getRequestDispatcher("/backstage/goodsManager.jsp").forward(request, response);
				return;
    		  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	  
      }else if("initUpdate".equals(action)) {
    	  if(id!=null) {
    		  Goods goods =gs.findGoodsById(id);
    		  request.setAttribute("goods",goods);
    		  request.getRequestDispatcher("/backstage/updateGoods.jsp").forward(request, response);
    		  return;
    	  }
      }else if("updateGoods".equals(action)) {
    	  Goods goods=packGoods(request);
    	  try {
			 gs.updateGoods(goods);
			response.getWriter().write("修改成功，1秒后跳转");
			response.setHeader("refresh","1;url="+request.getContextPath()+"/storeGoodsServlet?action=findGoodsByState");
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }else if("delGoods".equals(action)) {
    	  gs.deleteGoodsById(id);
    	  response.getWriter().write("删除成功，1秒后跳转");
		  response.setHeader("refresh","1;url="+request.getContextPath()+"/backstage/merchant.jsp");
		  return;
      }
      
      
    
      
      
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
			
		
 
	//打包商品
		public  Goods packGoods(HttpServletRequest request) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			Map<String,Object> map= new HashMap<>();
			try {

				List<FileItem> fileItems= upload.parseRequest(request);//解析请求

				for (FileItem fileItem : fileItems) {
					if(fileItem.isFormField()) {//普通的数据类型
						String name = fileItem.getFieldName();//去拿form表单的name  username
						String value = fileItem.getString("UTF-8");//去拿form表单的name对应的值 fanbinbin
						map.put(name, value);
					}else {//文件类型
						String fileName = fileItem.getName();//拿上传文件的名字
						String path = this.getServletContext().getRealPath("\\images");//绝对路径 复制到项目的webapps里的时候用
						//String path="D:\\apache-tomcat-8.5.31\\imgs\\img\\mm";//虚拟目录
						//System.out.println(path);
						String copyPath=path+File.separator+fileName;
						//System.out.println(copyPath);
						File file = new File(copyPath);

						//map.put("url", "img\\mm\\"+fileName);复制到项目的webapps里的时候用
						if(!"".equals(fileName)) {
							if(!file.exists()) {
								FileOutputStream outputStream = new FileOutputStream(file);
								IOUtils.copy(fileItem.getInputStream(), outputStream);
								map.put("picurl", "images\\"+fileName);
							}else {
								map.put("picurl", "images\\"+fileName);
							}
						}else {
							GoodsService gs = new GoodsServiceImpl();
							String ids = (String) map.get("id");
							Integer id=null;
							if(ids!=null&&!"".equals(ids)) {
								id = Integer.parseInt(ids);
							}
							Goods g = gs.findGoodsById(id);
							//System.out.println("gggggg");
							//System.out.println(g.getPicurl());
							map.put("picurl", g.getPicurl());
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//封装美女
			Goods g= new Goods();
			try {
				BeanUtils.populate(g, map);
			} catch (Exception e) {
				e.printStackTrace();
			} 

			return g;
		}

}


