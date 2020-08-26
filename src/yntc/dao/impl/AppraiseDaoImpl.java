package yntc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import utils.DBUtils;
import yntc.dao.AppraiseDao;
import yntc.domain.Appraise;
import yntc.domain.User;

public class AppraiseDaoImpl implements AppraiseDao {

	@Override
	public int addAppraise(HttpSession session, int goodsid,String content) {
        Connection conn=null;
        PreparedStatement ps=null;
        int i=0;
        User user=(User) session.getAttribute("user");
        Date Date=new Date();
        SimpleDateFormat sf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sf.format(Date);
        try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("insert into appraise(userid,goodsid,content,mark) values(?,?,?,?)");
			ps.setInt(1, user.getId());
			ps.setInt(2, goodsid);
			ps.setString(3, content);
			ps.setString(4, date);
			i=ps.executeUpdate();
		}  catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
	    
		return i;
	}

	@Override
	public List<Appraise> findAppraiseById(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Appraise> list=new ArrayList<>();
		
		try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("select appraise.content,appraise.mark,user.name from appraise inner join user on appraise.userid=user.id where goodsid=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Appraise appraise = new Appraise();
				appraise.setContent(rs.getString("content"));
				appraise.setMark(rs.getString("mark"));
				appraise.setUname(rs.getString("name"));
				list.add(appraise);
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs, ps, conn);
		}
				
		return list;
	}



}
