package yntc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.mysql.jdbc.PreparedStatement;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import utils.DBUtils;
import yntc.dao.OrderDao;
import yntc.domain.Bar;
import yntc.domain.Order;
import yntc.domain.Pie;
import yntc.domain.User;

public class OrderDaoImpl implements OrderDao {

	@Override
	public int addOrder(HttpSession session, int cid,String remark,int storeid) {
		Connection conn=null;
	    PreparedStatement ps= null;
	    int i=0;
	    User user = (User)session.getAttribute("user");
	    Date Date = new Date();
	    SimpleDateFormat sf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sf.format(Date);
	    try {
			conn=DBUtils.getConnection();
            ps=(PreparedStatement) conn.prepareStatement("insert into ord(uid,cid,time,remark,uname,address,telephone,ordState,storeid,count,th) values(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1,user.getId());
            ps.setInt(2, cid);
            
			//System.out.println(date);
			ps.setString(3,date);
			ps.setString(4,remark);
			ps.setString(5, user.getName());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getTelphone());
			ps.setString(8, "已付款");
			ps.setInt(9, storeid);
			ps.setString(10,"发货");
			ps.setInt(11, 0);
			i=ps.executeUpdate();
            
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
	    
		return i;
	}

	@Override
	public List<Order> findOrderByState(int currentPage, int pageSize, HttpSession session) throws Exception {
		  Connection conn =null;
	       PreparedStatement ps =null;
	       ResultSet rs =null;
		   List<Order>	list = new ArrayList<>();
		   User user = (User)session.getAttribute("user");
		  
	try {	
		   conn=DBUtils.getConnection();
		   String sql="select ord.oid,ord.cid,goods.id,goods.name,goods.price,cart.number,ord.ordState,goods.state,ord.uname,ord.address,ord.telephone,ord.time,ord.remark,goods.picurl,ord.storeid,ord.count,ord.th from ord inner join cart on ord.cid=cart.cid inner join goods on cart.goodsid=goods.id where ord.uid=? order by oid desc limit ?,?";
		   ps=(PreparedStatement) conn.prepareStatement(sql);
		   int start=(currentPage-1)*pageSize;
		   ps.setInt(1, user.getId());
		   ps.setInt(2, start);
		   ps.setInt(3, pageSize);
		   rs=ps.executeQuery();
		  
			while(rs.next()) {
				   Order order = new Order();
				   order.setOid(rs.getInt("oid"));
				   order.setCid(rs.getInt("cid"));
				   order.setGoodsid(rs.getInt("id"));
				   order.setGname(rs.getString("name"));
				   order.setPrice(rs.getInt("price"));
				   order.setNumber(rs.getInt("number"));
				   order.setOrdState(rs.getString("ordState"));
				   order.setGoodsstate(rs.getInt("state"));
				   order.setUname(rs.getString("uname"));
				   order.setAddress(rs.getString("address"));
				   order.setTelephone(rs.getString("telephone"));
				   order.setTime(rs.getString("time"));
				   order.setRemark(rs.getString("remark"));
				   order.setGpicurl(rs.getString("picurl"));
				   order.setStoreid(rs.getInt("storeid"));
				   order.setCount(rs.getString("count"));
				   order.setTh(rs.getInt("th"));
				   list.add(order);
				   
			   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		   
			return list;
		}
@Override
 public Integer count(HttpSession session) {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs =null;
	User user = (User)session.getAttribute("user");
	Integer i=null;
	try {
		conn = DBUtils.getConnection();
		ps = (PreparedStatement) conn.prepareStatement("select count(1) as c from ord where uid=?");
		ps.setInt(1, user.getId());
		//查询
		rs=ps.executeQuery();
		if(rs.next()) {
			i=rs.getInt("c");
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBUtils.closeAll(null, ps, conn);
	}
	return i;
 }

@Override
public int updateOrdstateConfirmReceipt(int oid) {
	 Connection conn =null;
     PreparedStatement ps =null;
     int i=0;
     
     try {
		conn = DBUtils.getConnection();
		 ps = (PreparedStatement) conn.prepareStatement("update ord set ordState=?,th=? where oid=?");
		 ps.setString(1, "已收货");
		 ps.setInt(2, 2);
		 ps.setInt(3, oid);
		 i=ps.executeUpdate();
	}  catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		DBUtils.closeAll(null, ps, conn);
	}
	return i;
}

@Override
public int updateOrderstateAppraise(int oid) {
	Connection conn =null;
    PreparedStatement ps =null;
    int i=0;
    
    try {
		conn = DBUtils.getConnection();
		 ps = (PreparedStatement) conn.prepareStatement("update ord set ordState=?,th=? where oid=?");
		 ps.setString(1, "交易完成");
		 ps.setInt(2, 2);
		 ps.setInt(3, oid);
		 i=ps.executeUpdate();
	}  catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		DBUtils.closeAll(null, ps, conn);
	}
	return i;
}

@Override
public Order findOrderByOid(int oid) {
	 Connection conn=null;
     PreparedStatement ps= null;
     ResultSet rs =null;
     Order order=null;
     
    try {
		conn=DBUtils.getConnection();
		ps=(PreparedStatement) conn.prepareStatement("select ord.oid,ord.uname,ord.address,ord.telephone,goods.name,goods.price,cart.number,goods.picurl,ord.remark from ord inner join cart on ord.cid=cart.cid inner join goods on cart.goodsid=goods.id where oid=?");
		ps.setInt(1, oid);
	    rs=ps.executeQuery();
	    
	    while(rs.next()) {
	    	order=new Order();
	    	order.setOid(rs.getInt("oid"));
	    	order.setUname(rs.getString("uname"));
	    	order.setAddress(rs.getString("address"));
	    	order.setTelephone(rs.getString("telephone"));
	    	order.setGname(rs.getString("name"));
	    	order.setPrice(rs.getInt("price"));
	    	order.setNumber(rs.getInt("number"));
	    	order.setGpicurl(rs.getString("picurl"));
	    	order.setRemark(rs.getString("remark"));
	    	
	    }
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		DBUtils.closeAll(rs, ps, conn);
	}
    
	return order;
}

@Override
public int delOrderByOid(int oid) {
	Connection conn=null;
	PreparedStatement ps=null;
	int i=0;
	
	try {
		conn=DBUtils.getConnection();
		ps=(PreparedStatement) conn.prepareStatement("delete from ord where oid=?");
		ps.setInt(1, oid);
		i=ps.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		DBUtils.closeAll(null, ps, conn);
	}
	
	return i;
}

@Override
public int updateOrder(int oid,String uname,String address,String telephone,String remark) {
   Connection conn=null;
   PreparedStatement ps=null;
   int i=0;
   
   try {
	conn=DBUtils.getConnection();
	   ps=(PreparedStatement) conn.prepareStatement("update ord set uname=?,address=?,telephone=?,remark=? where oid=?");
	   ps.setString(1, uname);
	   ps.setString(2, address);
	   ps.setString(3, telephone);
	   ps.setString(4, remark);
	   ps.setInt(5, oid);
	   i=ps.executeUpdate();
	   
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} finally {
	DBUtils.closeAll(null, ps, conn);
}
		   
	return i;
}

@Override
public int backstageUpdateOrderCount(int oid) {
	Connection conn =null;
    PreparedStatement ps =null;
    int i=0;
    
    try {
		conn = DBUtils.getConnection();
		 ps = (PreparedStatement) conn.prepareStatement("update ord set count=? where oid=?");
		 ps.setString(1, "已发货");
		 ps.setInt(2, oid);
		 i=ps.executeUpdate();
	}  catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} finally {
		DBUtils.closeAll(null, ps, conn);
	}
	return i;
}

@Override
public List<Order> backstageFindOrderByState(int currentPage, int pageSize, HttpSession session) throws Exception {
	  Connection conn =null;
      PreparedStatement ps =null;
      ResultSet rs =null;
	   List<Order>	list = new ArrayList<>();
	   User user = (User)session.getAttribute("user");
	  
try {	
	   conn=DBUtils.getConnection();
	   String sql="select ord.oid,ord.cid,goods.id,goods.name,goods.price,cart.number,ord.ordState,goods.state,ord.uname,ord.address,ord.telephone,ord.time,ord.remark,goods.picurl,ord.storeid,ord.count from ord inner join cart on ord.cid=cart.cid inner join goods on cart.goodsid=goods.id where ord.storeid=? limit ?,?";
	   ps=(PreparedStatement) conn.prepareStatement(sql);
	   int start=(currentPage-1)*pageSize;
	   ps.setInt(1, user.getId());
	   ps.setInt(2, start);
	   ps.setInt(3, pageSize);
	   rs=ps.executeQuery();
	  
		while(rs.next()) {
			   Order order = new Order();
			   order.setOid(rs.getInt("oid"));
			   order.setCid(rs.getInt("cid"));
			   order.setGoodsid(rs.getInt("id"));
			   order.setGname(rs.getString("name"));
			   order.setPrice(rs.getInt("price"));
			   order.setNumber(rs.getInt("number"));
			   order.setOrdState(rs.getString("ordState"));
			   order.setGoodsstate(rs.getInt("state"));
			   order.setUname(rs.getString("uname"));
			   order.setAddress(rs.getString("address"));
			   order.setTelephone(rs.getString("telephone"));
			   order.setTime(rs.getString("time"));
			   order.setRemark(rs.getString("remark"));
			   order.setGpicurl(rs.getString("picurl"));
			   order.setStoreid(rs.getInt("storeid"));
			   order.setCount(rs.getString("count"));
			   list.add(order);
			   
		   }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		DBUtils.closeAll(rs, ps, conn);
	}
	   
		return list;
}

@Override
public Integer backStageCount(HttpSession session) {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs =null;
	User user = (User)session.getAttribute("user");
	Integer i=null;
	try {
		conn = DBUtils.getConnection();
		ps = (PreparedStatement) conn.prepareStatement("select count(1) as c from ord where storeid=?");
		ps.setInt(1, user.getId());
		//查询
		rs=ps.executeQuery();
		if(rs.next()) {
			i=rs.getInt("c");
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		DBUtils.closeAll(null, ps, conn);
	}
	return i;
}

@Override
public List<Bar> orderChart(String goodsname, String year,HttpSession session) {
	Connection conn =null;
    PreparedStatement ps =null;
    ResultSet rs =null;
	List<Bar>	list = new ArrayList<>();
	User user = (User)session.getAttribute("user");
	try {
		conn=DBUtils.getConnection();
		String sql="select year(time)年,month(time)月,sum(number)销售合计, goods.location from ord join cart on ord.cid=cart.cid join goods on cart.goodsid=goods.id where cart.cid in(select cart.cid from  cart join goods on cart.goodsid=goods.id where goods.name like ? and ord.storeid=? and (ord.th=0 or ord.th=2)) and ord.time like ? group by year(time),month(time),location";
		ps=(PreparedStatement) conn.prepareStatement(sql);
		ps.setString(1, "%"+goodsname+"%");
		ps.setInt(2, user.getId());
		ps.setString(3, year+"%");
		rs=ps.executeQuery();
		
		while(rs.next()) {
			Bar bar =new Bar();
			bar.setYear(rs.getString("年"));
			bar.setMonth(rs.getString("月"));
			bar.setCountNumber(rs.getInt("销售合计"));
			bar.setLocation(rs.getString("location"));
			list.add(bar);
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		DBUtils.closeAll(rs, ps, conn);
	}
	//System.out.println("list");
	//System.out.println(list);
	return list;
}

@Override
public List<Pie> chartPie(String year, HttpSession session) {
	Connection conn= null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	List<Pie> list =new ArrayList<>();
	User user=(User) session.getAttribute("user");
	
	try {
		conn=DBUtils.getConnection();
		ps=(PreparedStatement) conn.prepareStatement("select goods.type,sum(cart.number)Sum from ord join cart on ord.cid=cart.cid join goods on cart.goodsid=goods.id where (ord.storeid=? and ord.time like ? and (ord.th=0 or ord.th=2) ) group by goods.type;");
		ps.setInt(1, user.getId());
		ps.setString(2, year+"%");
		rs=ps.executeQuery();
		
		while(rs.next()) {
			Pie pie = new Pie();
			pie.setType(rs.getString("type"));
			pie.setSum(rs.getInt("Sum"));
			list.add(pie);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		DBUtils.closeAll(rs, ps, conn);
	}
	
	return list;
}

@Override
public int thUpdateOrderOrderstate(int oid) {
	Connection conn =null;
	PreparedStatement ps =null;
	int i=0;
	
	try {
		conn=DBUtils.getConnection();
		ps=(PreparedStatement) conn.prepareStatement("update ord set ordState=?,th=?,count=? where oid=?");
		ps.setString(1, "已退货");
		ps.setInt(2, 1);
		ps.setString(3, "已退货");
		ps.setInt(4, oid);
		i=ps.executeUpdate();
		
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		DBUtils.closeAll(null, ps, conn);
	}
	return i;
}

@Override
public int thUpdateOrderTh(int oid) {
	Connection conn=null;
    PreparedStatement ps=null;
    int i=0;
    
    try {
		conn=DBUtils.getConnection();
		ps=(PreparedStatement) conn.prepareStatement("update ord set th=? where oid=?");
		ps.setInt(1, 3);
		ps.setInt(2, oid);
		i=ps.executeUpdate();
		
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		DBUtils.closeAll(null, ps, conn);
	}

	return i;
}


}
