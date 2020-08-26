package yntc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import utils.DBUtils;
import yntc.dao.CollectDao;
import yntc.domain.Collect;
import yntc.domain.User;

public class CollectDaoImpl implements CollectDao {

	@Override
	public int addCollect(int goodsid, HttpSession session) {
		Connection conn=null;
		PreparedStatement ps =null;
		int i =0;
		User user=(User) session.getAttribute("user");
		
		try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("insert into collect(goodsid,userid) values(?,?)");
			ps.setInt(1, goodsid);
			ps.setInt(2, user.getId());
		    i=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Collect> findCollectByUserid(HttpSession session) {
       Connection conn=null;
       PreparedStatement ps=null;
       ResultSet rs =null;
       List<Collect> list =new ArrayList<Collect>();
       User user=(User) session.getAttribute("user");
       
      try {
		conn=DBUtils.getConnection();
		ps=(PreparedStatement) conn.prepareStatement("select goods.picurl,goods.name,goods.price,goods.num,goods.id,goods.state,collect.cid,collect.userid from goods inner join collect on goods.id=collect.goodsid where userid=?");
		ps.setInt(1, user.getId());
		rs=ps.executeQuery();
		
		while(rs.next()) {
			Collect collect= new Collect();
			collect.setPicurl(rs.getString("picurl"));
			collect.setName(rs.getString("name"));
			collect.setPrice(rs.getInt("price"));
			collect.setNum(rs.getInt("num"));
			collect.setId(rs.getInt("id"));
			collect.setState(rs.getInt("state"));
			collect.setCid(rs.getInt("cid"));
			collect.setUserid(rs.getInt("userid"));
			list.add(collect);
		}
		
	}  catch (Exception e) {
		e.printStackTrace();
	}finally {
		DBUtils.closeAll(rs, ps, conn);
	}
		return list;
	}

	@Override
	public int cancelCollect(int cid) {
		Connection conn=null;
		PreparedStatement ps=null;
		int i=0;
		
		try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("delete from collect where cid=?");
			ps.setInt(1, cid);
			i=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
		
		return i;
	}

}
