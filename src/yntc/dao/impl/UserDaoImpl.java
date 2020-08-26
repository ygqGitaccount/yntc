package yntc.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.DbUtils;

import com.mysql.jdbc.PreparedStatement;
import com.sun.org.apache.regexp.internal.RE;

import utils.DBUtils;
import yntc.dao.UserDao;
import yntc.domain.User;

public class UserDaoImpl implements UserDao {

	@Override
	public int addUser(User user) throws Exception {
         Connection conn =null;
         PreparedStatement ps = null;
         int i = 0;
         
         
         try {
			//获取连接
			 conn=DBUtils.getConnection();
			 //获取预编译对象，执行预编译语句
			 ps = (PreparedStatement) conn.prepareStatement("insert into user(name,email,username,password,gender,qq,telphone,region,address,state,balance,role) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			 //设置参数
			 ps.setString(1, user.getName());
			 ps.setString(2, user.getEmail());
			 ps.setString(3, user.getUsername());
			 ps.setString(4, user.getPassword());
			 ps.setString(5, user.getGender());
			 ps.setString(6, user.getQq());
			 ps.setString(7, user.getTelphone());
			 ps.setString(8, user.getRegion());
			 ps.setString(9, user.getAddress());
			 ps.setString(10, user.getState());
			 ps.setInt(11, user.getBalance());
			 ps.setString(12, user.getRole());
			 
			 //执行操作
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
	public User findUserByUsernameAndPassword(String username,String password) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        
        try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("select * from user where username=? and password=?");
			ps.setString(1,username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setQq(rs.getString("qq"));
				user.setTelphone(rs.getString("telphone"));
				user.setRegion(rs.getString("region"));
				user.setAddress(rs.getString("address"));
				user.setState(rs.getString("state"));
				user.setBalance(rs.getInt("balance"));
				user.setRole(rs.getString("role"));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs,ps,conn);
		}
		return user;
	}
    @Override
	public User findUserById(int id) {
        Connection conn =null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        User user =new User();
         
        try {
			conn =DBUtils.getConnection(); 
			ps =(PreparedStatement) conn.prepareStatement("select * from user where id=?");
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setQq(rs.getString("qq"));
				user.setTelphone(rs.getString("telphone"));
				user.setRegion(rs.getString("region"));
				user.setAddress(rs.getString("address"));
				user.setState(rs.getString("state"));
				user.setBalance(rs.getInt("balance"));
				user.setRole(rs.getString("role"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(rs,ps,conn);
		}
		return user;
	}

	@Override
	public int updateUser(String name, String email, String username, String qq, String telphone, int id) {
		 Connection conn =null;
         PreparedStatement ps = null;
         int i=0;
         
         try {
			//获取连接
			 conn = DBUtils.getConnection();
			 //获取预编译对象，执行预编译语句
			 ps = (PreparedStatement) conn.prepareStatement("update User set name=?,email=?,username=?,qq=?,telphone=? where id=?");
			 ps.setString(1,name);
			 ps.setString(2, email);
			 ps.setString(3, username);
			 ps.setString(4, qq);
			 ps.setString(5, telphone);
			 ps.setInt(6,id);
			 //执行操作
			 i=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null,ps,conn);
		}
        return i;
	}

	@Override
	public int updateUserBalanceReduce(HttpSession session,int totalprice) {
		Connection conn=null;
		PreparedStatement ps =null;
		int i=0;
		User user = (User) session.getAttribute("user");
		
		try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("update user set balance=balance-? where id=?");
			ps.setInt(1, totalprice);
			ps.setInt(2, user.getId());
			i=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
		
		return i;
	}

	@Override
	public int updateAdminBalanceAdd(int totalprice) {
		Connection conn=null;
		PreparedStatement ps =null;
		int i=0;
		try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("update user set balance=balance+? where id=5");
			ps.setInt(1, totalprice);
			i=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
		
		return i;
	}

	@Override
	public int updateAdminBalanceReduce(int count) {
		Connection conn=null;
		PreparedStatement ps =null;
		int i=0;
		try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("update user set balance=balance-? where id=5");
			ps.setInt(1, count);
			i=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
		
		return i;
	}

	@Override
	public int updateStoreBalanceAdd(int storeid,int count) {
		Connection conn=null;
		PreparedStatement ps =null;
		int i=0;
		try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("update user set balance=balance+? where id=?");
			ps.setInt(1, count);
			ps.setInt(2, storeid);
			i=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
		
		return i;
	}

	@Override
	public User countUser() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User user=new User();	
			try {
				conn=DBUtils.getConnection();
				ps=(PreparedStatement) conn.prepareStatement("select count(role) as countNum from user where role=2");
				rs=ps.executeQuery();
				
				while(rs.next()) {
					user.setCountNum(rs.getInt("countNum"));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUtils.closeAll(rs, ps, conn);
			}
			return user;
	}

	@Override
	public int updateUserState(int id) {
        Connection conn=null;
        PreparedStatement ps=null;
        int i= 0;
		
        try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("update user set state=1 where id=?");
			ps.setInt(1, id);
			i=ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
        
		return i;
	}

	@Override
	public List<User> findUserByRole(int currentPage, int pageSize) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;;
		List<User> list=new ArrayList<>();
		
		try {
			conn=DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("select * from user where role=1 or role=2 order by role limit ?,?");
			 int start=(currentPage-1)*pageSize; 
			   ps.setInt(1, start);
			   ps.setInt(2, pageSize);
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				User user =new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setQq(rs.getString("qq"));
				user.setTelphone(rs.getString("telphone"));
				user.setRegion(rs.getString("region"));
				user.setAddress(rs.getString("address"));
				user.setState(rs.getString("state"));
				user.setBalance(rs.getInt("balance"));
				list.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}

	@Override
	public Integer count() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		Integer i=null;
		try {
			conn = DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement("select count(1) as c from user where role=1 or role=2" );
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
	public List<User> findStoreByRole() {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<User> list=new ArrayList<>();
		
        try {
			conn = DBUtils.getConnection();
			ps = (PreparedStatement) conn.prepareStatement("select * from user where role=1" );
			//查询
			rs=ps.executeQuery();
			while(rs.next()) {
				User user =new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				list.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, ps, conn);
		}
		return list;
	}

	@Override
	public int thUpdatePtBalanceReduce(int count) {
       Connection conn = null;
       PreparedStatement ps =null;
       int i=0;
       
       try {
    		conn=DBUtils.getConnection();
    		ps=(PreparedStatement) conn.prepareStatement("update user set balance=balance-? where id=5");
    		ps.setInt(1, count);
		    i=ps.executeUpdate();
		   
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		DBUtils.closeAll(null, ps, conn);
	}
       
		return i;
	}

	@Override
	public int thUpdateUserBalanceAdd(HttpSession session, int count) {
		Connection conn = null;
	    PreparedStatement ps =null;
	    User user = (User) session.getAttribute("user");
	    int i=0;
	       
	       try {
	    		conn=DBUtils.getConnection();
	    		ps=(PreparedStatement) conn.prepareStatement("update user set balance=balance+? where id=?");
			    ps.setInt(1, count);
			    ps.setInt(2, user.getId());
	    		i=ps.executeUpdate();
			   
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(null, ps, conn);
		}
	       
			return i;
	}

	@Override
	public int recharge(HttpSession session, int recharge) {
       Connection conn =null;
       PreparedStatement ps =null;
       int i =0;
       User user =(User) session.getAttribute("user");
       
       try {
    	   
		conn=DBUtils.getConnection();
		ps=(PreparedStatement) conn.prepareStatement("update user set balance=balance+? where id=?");
		ps.setInt(1, recharge);
		ps.setInt(2, user.getId());
		i=ps.executeUpdate();
		
	  } catch (Exception e) {
		e.printStackTrace();
	  }finally {
		  DBUtils.closeAll(null, ps, conn);
	  }
       
       return i;
	}

	@Override
	public int adminBalance() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet  rs= null;	
		Integer i=null;
		try {
			conn = DBUtils.getConnection();
			ps=(PreparedStatement) conn.prepareStatement("select user.balance from user where id=5");
			rs=ps.executeQuery();
			
			if(rs.next()) {
				i=rs.getInt("balance");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			  DBUtils.closeAll(rs, ps, conn);
		  }
		
		return i;
	}

	

}
