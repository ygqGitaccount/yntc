package yntc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import utils.DBUtils;
import yntc.dao.CartDao;
import yntc.domain.Cart;
import yntc.domain.Goods;
import yntc.domain.User;

public class CartDaoImpl implements CartDao {

	@Override
	public int addCart(int id,int buyNum,int storeid,HttpSession session) {
        Connection conn=null;
        PreparedStatement ps=null;
        int i=0;
        User user = (User)session.getAttribute("user");
        try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("insert into cart(userid,goodsid,storeid,number,state) values(?,?,?,?,?)");
			ps.setInt(1,user.getId());
			ps.setInt(2, id);
			ps.setInt(3, storeid);
			ps.setInt(4, buyNum);
			ps.setInt(5, 1);
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
	public List<Cart> findCartGoodsByState(HttpSession session) {
       Connection conn =null;
       PreparedStatement ps =null;
       ResultSet rs =null;
       List<Cart>	list = new ArrayList<>();
	   User user = (User)session.getAttribute("user");
       
       
       try {
		conn=DBUtils.getConnection();
		String sql="select cart.cid,goods.picurl,goods.name,goods.price,cart.number,goods.num,cart.state,cart.storeid,cart.goodsid from cart inner join goods on cart.goodsid=goods.id where cart.userid=?";
		ps=(PreparedStatement) conn.prepareStatement(sql);
		ps.setInt(1, user.getId());
		rs=ps.executeQuery();
		
		while(rs.next()) {
			Cart cart =new Cart();
			cart.setCid(rs.getInt("cid"));
			cart.setPicurl(rs.getString("picurl"));
			cart.setName(rs.getString("name"));
			cart.setPrice(rs.getInt("price"));
			cart.setNumber(rs.getInt("number"));
			cart.setNum(rs.getInt("num"));
			cart.setState(rs.getInt("state"));
			cart.setStoreid(rs.getInt("storeid"));
			cart.setGoodsid(rs.getInt("goodsid"));
			list.add(cart);
			
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
	public int delCartGoodsByCid(int cid) {
		Connection conn=null;
		PreparedStatement ps=null;
		int i=0;
		
		try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("delete from cart where cid=?");
			ps.setInt(1, cid);
			i=ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null,ps, conn);
		}
		return i;
	}

	@Override
	public int updateCartNumber(int cid, int number) {
		Connection conn=null;
		PreparedStatement ps=null;
		int i=0;
		
		try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("update cart set number=? where cid=?");
			ps.setInt(1, number);
			ps.setInt(2, cid);
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
	public int updateCartGoodsState(int cid) {
		Connection conn=null;
		PreparedStatement ps=null;
		int i=0;
		try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("update cart set state=? where cid=?");
			ps.setInt(1, 0);
			ps.setInt(2, cid);
			i=ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
		
		return i;
	}

}
