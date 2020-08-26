package yntc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import utils.DBUtils;
import yntc.dao.GoodsDao;
import yntc.domain.Goods;
import yntc.domain.User;

public class GoodsDaoImpl implements GoodsDao {

	@Override
	public List<Goods> findAll() throws Exception {
       Connection conn = null;
       PreparedStatement ps = null;
       ResultSet rs = null;
       List<Goods> list =new ArrayList<>();
       
       try {
		conn = DBUtils.getConnection();
		   ps = (PreparedStatement) conn.prepareStatement("select * from goods where num!=0 order by monnum desc");
		   rs = ps.executeQuery();
		   
		   while(rs.next()) {
			   Goods goods = new Goods();
			   goods.setId(rs.getInt("id"));
			   goods.setName(rs.getString("name"));
			   goods.setType(rs.getString("type"));
			   goods.setRegion(rs.getString("region"));
			   goods.setLocation(rs.getString("location"));
			   goods.setMonnum(rs.getInt("monnum"));
			   goods.setNum(rs.getInt("num"));
			   goods.setPicurl(rs.getString("picurl"));
			   goods.setInputprice(rs.getInt("inputprice"));
			   goods.setPrice(rs.getInt("price"));
			   goods.setState(rs.getInt("state"));
			   goods.setStatus(rs.getString("status"));
			   list.add(goods);
			   
		   }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		DBUtils.closeAll(null, ps, conn);
	}
       
		return list;
	}

	@Override
	public Goods findGoodsById(int id) {
       Connection conn=null;
       PreparedStatement ps= null;
       ResultSet rs =null;
       Goods goods=null;
      
		try {
			conn =DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("select * from goods where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				   goods= new Goods();
				   goods.setId(rs.getInt("id"));
				   goods.setName(rs.getString("name"));
				   goods.setType(rs.getString("type"));
				   goods.setRegion(rs.getString("region"));
				   goods.setLocation(rs.getString("location"));
				   goods.setMonnum(rs.getInt("monnum"));
				   goods.setNum(rs.getInt("num"));
				   goods.setPicurl(rs.getString("picurl"));
				   goods.setInputprice(rs.getInt("inputprice"));
				   goods.setPrice(rs.getInt("price"));
				   goods.setState(rs.getInt("state"));
				   goods.setStatus(rs.getString("status"));
				   
			   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return goods;
	}

	@Override
	public int addGoods(Goods goods,HttpSession session) {
		Connection conn=null;
	    PreparedStatement ps= null;
	    int i=0;
		//HttpServletRequest httprequest =(HttpServletRequest)request;
	   //HttpSession  session1 = request.getSession();
	    User user = (User)session.getAttribute("user");
	    try {
			conn=DBUtils.getConnection();
			String sql="insert into goods(name,type,region,location,monnum,num,inputprice,price,state,status,picurl) values(?,?,?,?,?,?,?,?,?,?,?)";
			ps=(PreparedStatement) conn.prepareStatement(sql);
		    ps.setString(1, goods.getName());
		    ps.setString(2, goods.getType());
		    ps.setString(3, goods.getRegion());
		    ps.setString(4, goods.getLocation());
		    ps.setInt(5, goods.getMonnum());
		    ps.setInt(6, goods.getNum());
		    ps.setInt(7, goods.getInputprice());
		    ps.setInt(8, goods.getPrice());
		    ps.setInt(9,user.getId());
		    ps.setString(10,goods.getStatus());
		    ps.setString(11, goods.getPicurl());
		    i=ps.executeUpdate();
			
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
	    
		return i;
	}

	@Override
	public List<Goods> findGoodsByState(int currentPage,int pageSize,HttpSession session) throws Exception {
       Connection conn =null;
       PreparedStatement ps =null;
       ResultSet rs =null;
	   List<Goods>	list = new ArrayList<>();
	   User user = (User)session.getAttribute("user");
	  
try {	
	   conn=DBUtils.getConnection();
	   ps=(PreparedStatement) conn.prepareStatement("select * from goods where state=? order by num  limit ?,?");
	   int start=(currentPage-1)*pageSize;
	   ps.setInt(1, user.getId());
	   ps.setInt(2, start);
	   ps.setInt(3, pageSize);
	   rs=ps.executeQuery();
	  
		while(rs.next()) {
			   Goods goods = new Goods();
			   goods.setId(rs.getInt("id"));
			   goods.setName(rs.getString("name"));
			   goods.setType(rs.getString("type"));
			   goods.setRegion(rs.getString("region"));
			   goods.setLocation(rs.getString("location"));
			   goods.setMonnum(rs.getInt("monnum"));
			   goods.setNum(rs.getInt("num"));
			   goods.setPicurl(rs.getString("picurl"));
			   goods.setInputprice(rs.getInt("inputprice"));
			   goods.setPrice(rs.getInt("price"));
			   goods.setState(rs.getInt("state"));
			   goods.setStatus(rs.getString("status"));
			   list.add(goods);
			   
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
	public int updateGoods(Goods goods)  {
		Connection conn=null;
		PreparedStatement ps=null;
		int i=0;
		
		try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("update goods set name=?,type=?,region=?,location=?,num=?,inputprice=?,price=?,status=?,picurl=? where id=?");
			
			ps.setString(1, goods.getName());
			ps.setString(2, goods.getType());
			ps.setString(3, goods.getRegion());
			ps.setString(4, goods.getLocation());
			ps.setInt(5, goods.getNum());
			ps.setInt(6, goods.getInputprice());
			ps.setInt(7, goods.getPrice());
			ps.setString(8, goods.getStatus());
			ps.setString(9, goods.getPicurl());
			ps.setInt(10, goods.getId());
			i=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
		
		return i;
	}

	@Override
	public int deleteGoodsById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		int i=0;
		
		try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("delete from goods where id=?");
			ps.setInt(1, id);
			i=ps.executeUpdate();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null,ps, conn);
		}
		return i;
	}

	@Override
	public Integer count(HttpSession session) {
		Connection conn=null;
		PreparedStatement ps=null;
		User user = (User)session.getAttribute("user");
		ResultSet rs =null;
		Integer i=null;
		try {
			conn = DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement("select count(1) as c from goods where state=?");
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
	public List<Goods> findGoodsByState(int state) {
		 Connection conn = null;
	       PreparedStatement ps = null;
	       ResultSet rs = null;
	       List<Goods> list =new ArrayList<>();
	       
	       try {
			conn = DBUtils.getConnection();
			   ps = (PreparedStatement) conn.prepareStatement("select * from goods where state=? and num!=0 order by monnum desc");
			   ps.setInt(1, state);
			   rs = ps.executeQuery();
			   
			   while(rs.next()) {
				   Goods goods = new Goods();
				   goods.setId(rs.getInt("id"));
				   goods.setName(rs.getString("name"));
				   goods.setType(rs.getString("type"));
				   goods.setRegion(rs.getString("region"));
				   goods.setLocation(rs.getString("location"));
				   goods.setMonnum(rs.getInt("monnum"));
				   goods.setNum(rs.getInt("num"));
				   goods.setPicurl(rs.getString("picurl"));
				   goods.setInputprice(rs.getInt("inputprice"));
				   goods.setPrice(rs.getInt("price"));
				   goods.setState(rs.getInt("state"));
				   goods.setStatus(rs.getString("status"));
				   list.add(goods);
				   
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
	public List<Goods> findMoreFood() {
       Connection conn =null;
       PreparedStatement ps= null;
       ResultSet rs=null;
       List<Goods> list= new ArrayList<>();
       
       try {
		conn=DBUtils.getConnection();
		ps=(PreparedStatement) conn.prepareStatement("select * from goods where type='食品' and num!=0 order by monnum desc"); 
		rs=ps.executeQuery();
		
		   while(rs.next()) {
			   Goods goods = new Goods();
			   goods.setId(rs.getInt("id"));
			   goods.setName(rs.getString("name"));
			   goods.setType(rs.getString("type"));
			   goods.setRegion(rs.getString("region"));
			   goods.setLocation(rs.getString("location"));
			   goods.setMonnum(rs.getInt("monnum"));
			   goods.setNum(rs.getInt("num"));
			   goods.setPicurl(rs.getString("picurl"));
			   goods.setInputprice(rs.getInt("inputprice"));
			   goods.setPrice(rs.getInt("price"));
			   goods.setState(rs.getInt("state"));
			   goods.setStatus(rs.getString("status"));
			   list.add(goods);
			   
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
	public List<Goods> findMoreHandicraft() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
        List<Goods> list =new ArrayList<>();
         
        try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("select * from goods where type='手工艺品' and num!=0 order by monnum desc");
			rs=ps.executeQuery();
			
			 while(rs.next()) {
				   Goods goods = new Goods();
				   goods.setId(rs.getInt("id"));
				   goods.setName(rs.getString("name"));
				   goods.setType(rs.getString("type"));
				   goods.setRegion(rs.getString("region"));
				   goods.setLocation(rs.getString("location"));
				   goods.setMonnum(rs.getInt("monnum"));
				   goods.setNum(rs.getInt("num"));
				   goods.setPicurl(rs.getString("picurl"));
				   goods.setInputprice(rs.getInt("inputprice"));
				   goods.setPrice(rs.getInt("price"));
				   goods.setState(rs.getInt("state"));
				   goods.setStatus(rs.getString("status"));
				   list.add(goods);
				   
			   }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, ps, conn);
		}
        return list;
	}

	@Override
	public List<Goods> findMoreFruit() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
        List<Goods> list =new ArrayList<>();
         
        try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("select * from goods where type='水果' and num!=0 order by monnum desc");
			rs=ps.executeQuery();
			
			 while(rs.next()) {
				   Goods goods = new Goods();
				   goods.setId(rs.getInt("id"));
				   goods.setName(rs.getString("name"));
				   goods.setType(rs.getString("type"));
				   goods.setRegion(rs.getString("region"));
				   goods.setLocation(rs.getString("location"));
				   goods.setMonnum(rs.getInt("monnum"));
				   goods.setNum(rs.getInt("num"));
				   goods.setPicurl(rs.getString("picurl"));
				   goods.setInputprice(rs.getInt("inputprice"));
				   goods.setPrice(rs.getInt("price"));
				   goods.setState(rs.getInt("state"));
				   goods.setStatus(rs.getString("status"));
				   list.add(goods);
				   
			   }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, ps, conn);
		}
        return list;
	}

	@Override
	public List<Goods> findMoreMeat() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
        List<Goods> list =new ArrayList<>();
         
        try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("select * from goods where type='肉类' and num!=0  order by monnum desc");
			rs=ps.executeQuery();
			
			 while(rs.next()) {
				   Goods goods = new Goods();
				   goods.setId(rs.getInt("id"));
				   goods.setName(rs.getString("name"));
				   goods.setType(rs.getString("type"));
				   goods.setRegion(rs.getString("region"));
				   goods.setLocation(rs.getString("location"));
				   goods.setMonnum(rs.getInt("monnum"));
				   goods.setNum(rs.getInt("num"));
				   goods.setPicurl(rs.getString("picurl"));
				   goods.setInputprice(rs.getInt("inputprice"));
				   goods.setPrice(rs.getInt("price"));
				   goods.setState(rs.getInt("state"));
				   goods.setStatus(rs.getString("status"));
				   list.add(goods);
				   
			   }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, ps, conn);
		}
        return list;
	}

	@Override
	public List<Goods> findMoreDryCargo() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
        List<Goods> list =new ArrayList<>();
         
        try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("select * from goods where type='干货' and num!=0 order by monnum desc");
			rs=ps.executeQuery();
			
			 while(rs.next()) {
				   Goods goods = new Goods();
				   goods.setId(rs.getInt("id"));
				   goods.setName(rs.getString("name"));
				   goods.setType(rs.getString("type"));
				   goods.setRegion(rs.getString("region"));
				   goods.setLocation(rs.getString("location"));
				   goods.setMonnum(rs.getInt("monnum"));
				   goods.setNum(rs.getInt("num"));
				   goods.setPicurl(rs.getString("picurl"));
				   goods.setInputprice(rs.getInt("inputprice"));
				   goods.setPrice(rs.getInt("price"));
				   goods.setState(rs.getInt("state"));
				   goods.setStatus(rs.getString("status"));
				   list.add(goods);
				   
			   }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, ps, conn);
		}
        return list;
	}

	@Override
	public List<Goods> searchGoodsByName(String word) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
        List<Goods> list =new ArrayList<>();

        try {
			conn = DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("select * from goods where name like ? and num!=0 order by monnum desc");
			ps.setString(1,"%"+word+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				   Goods goods = new Goods();
				   goods.setId(rs.getInt("id"));
				   goods.setName(rs.getString("name"));
				   goods.setType(rs.getString("type"));
				   goods.setRegion(rs.getString("region"));
				   goods.setLocation(rs.getString("location"));
				   goods.setMonnum(rs.getInt("monnum"));
				   goods.setNum(rs.getInt("num"));
				   goods.setPicurl(rs.getString("picurl"));
				   goods.setInputprice(rs.getInt("inputprice"));
				   goods.setPrice(rs.getInt("price"));
				   goods.setState(rs.getInt("state"));
				   goods.setStatus(rs.getString("status"));
				   list.add(goods);
		   }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return list;
		
	}

	@Override
	public List<String> searchGoodsByLikeName(String word) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
        List<String> list =new ArrayList<>();
        
        try {
			conn = DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("select name from goods where name like ? and num!=0 order by monnum desc");
			ps.setString(1,"%"+word+"%");
			rs=ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				list.add(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public int updateGoodsNumRaduce(int goodsid, int number) {
		Connection conn=null;
		PreparedStatement ps=null;
		int i=0;
		
		try {
			conn = DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("update goods set num=num-?,monnum=monnum+? where id=?");
			ps.setInt(1, number);
			ps.setInt(2, number);
			ps.setInt(3, goodsid);
			i=ps.executeUpdate();
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
		
		return i;
	}

	@Override
	public Goods findStoreName(int state) {
		 Connection conn = null;
	       PreparedStatement ps = null;
	       ResultSet rs = null;
	       Goods goods=new Goods();
	       try {
			conn = DBUtils.getConnection();
			   ps = (PreparedStatement) conn.prepareStatement("select goods.state,user.name as storename from goods join user on goods.state=user.id where goods.state=? limit 1");
			   ps.setInt(1, state);
			   rs = ps.executeQuery();
			   
			   while(rs.next()) {
				   goods.setState(rs.getInt("state"));
				   goods.setStoreName(rs.getString("storename"));
			   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
	       
			return goods;
	}

	@Override
	public List<Goods> findGoodsByType(String type,int state) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
        List<Goods> list =new ArrayList<>();
        
        try {
			conn = DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("select * from goods where type=? and state=? and num!=0 order by monnum desc");
			ps.setString(1,type);
			ps.setInt(2, state);
			rs=ps.executeQuery();
			while(rs.next()) {
				 Goods goods = new Goods();
				   goods.setId(rs.getInt("id"));
				   goods.setName(rs.getString("name"));
				   goods.setType(rs.getString("type"));
				   goods.setRegion(rs.getString("region"));
				   goods.setLocation(rs.getString("location"));
				   goods.setMonnum(rs.getInt("monnum"));
				   goods.setNum(rs.getInt("num"));
				   goods.setPicurl(rs.getString("picurl"));
				   goods.setInputprice(rs.getInt("inputprice"));
				   goods.setPrice(rs.getInt("price"));
				   goods.setState(rs.getInt("state"));
				   goods.setStatus(rs.getString("status"));
				   list.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public List<Goods> findGoodsAll(int state) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
        List<Goods> list =new ArrayList<>();
        
        try {
			conn = DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("select * from goods where state=? and num!=0 order by monnum desc");
			ps.setInt(1,state);
			rs=ps.executeQuery();
			while(rs.next()) {
				 Goods goods = new Goods();
				   goods.setId(rs.getInt("id"));
				   goods.setName(rs.getString("name"));
				   goods.setType(rs.getString("type"));
				   goods.setRegion(rs.getString("region"));
				   goods.setLocation(rs.getString("location"));
				   goods.setMonnum(rs.getInt("monnum"));
				   goods.setNum(rs.getInt("num"));
				   goods.setPicurl(rs.getString("picurl"));
				   goods.setInputprice(rs.getInt("inputprice"));
				   goods.setPrice(rs.getInt("price"));
				   goods.setState(rs.getInt("state"));
				   goods.setStatus(rs.getString("status"));
				   list.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public int updateGoodsNumberAdd(int number,int gid) {
		Connection conn=null;
		PreparedStatement ps=null;
		int i=0;
		
		try {
			conn = DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("update goods set monnum=monnum-?,num=+? where id=?");
			ps.setInt(1, number);
			ps.setInt(2, number);
			ps.setInt(3, gid);
			i=ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
		
		return i;
	}

	
}
	
