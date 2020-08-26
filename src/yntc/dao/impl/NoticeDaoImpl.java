package yntc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import utils.DBUtils;
import yntc.dao.NoticeDao;
import yntc.domain.Notice;

public class NoticeDaoImpl implements NoticeDao {

	@Override
	public int addNotice(String title, String content) {
        Connection conn=null;
        PreparedStatement ps=null;
        int i=0;
        Date Date = new Date();
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
        String date=sf.format(Date);
        
        try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("insert into notice(title,content,time) values(?,?,?)");
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setString(3, date);
			i=ps.executeUpdate();
			
			
		}  catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
        
		return i;
	}

	@Override
	public List<Notice> findNotice() {
       Connection conn =null;
       PreparedStatement ps=null;
       ResultSet rs=null;
       List<Notice> list =new ArrayList<>();
       
       try {
		conn=DBUtils.getConnection();
		ps =(PreparedStatement) conn.prepareStatement("select * from notice order by id desc");
		rs=ps.executeQuery();   
		
		while(rs.next()) {
			Notice notice=new Notice();
			notice.setId(rs.getInt("id"));
			notice.setTitle(rs.getString("title"));
			notice.setContent(rs.getString("content"));
			notice.setTime(rs.getString("time"));
			list.add(notice);
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		DBUtils.closeAll(rs, ps, conn);
	}
		return list;
	}

	@Override
	public Notice findNoticeById(int id) {
       Connection conn=null;
       PreparedStatement ps=null;
       ResultSet rs=null;
       Notice notice=new Notice();
       
       try {
		conn=DBUtils.getConnection();
			ps =(PreparedStatement) conn.prepareStatement("select * from notice where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				notice.setId(rs.getInt("id"));
				notice.setTitle(rs.getString("title"));
				notice.setContent(rs.getString("content"));
				notice.setTime(rs.getString("time"));
			}
			
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		DBUtils.closeAll(rs, ps, conn);
	}
		return notice;
	}

	@Override
	public int updateNotice( String title,String content,int id) {
		 Connection conn=null;
	     PreparedStatement ps=null;
         int i=0;
         
	       try {
			conn=DBUtils.getConnection();
				ps =(PreparedStatement) conn.prepareStatement("update notice set title=?,content=? where id=?");
                ps.setString(1, title);
                ps.setString(2, content);
                ps.setInt(3, id);
                i=ps.executeUpdate();
				
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
			return i;
	}

	@Override
	public int delNoticeById(int id) {
       Connection conn=null;
       PreparedStatement ps=null;
       int i=0;
       
       try {
		conn=DBUtils.getConnection();
		ps=(PreparedStatement) conn.prepareStatement("delete from notice where id=?");
		ps.setInt(1, id);
		i=ps.executeUpdate();
		   
		   
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		DBUtils.closeAll(null, ps, conn);
	}
		return i;
	}

}
