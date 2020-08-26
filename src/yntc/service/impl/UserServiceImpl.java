package yntc.service.impl;


import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpSession;

import yntc.dao.UserDao;
import yntc.dao.impl.UserDaoImpl;
import yntc.domain.Goods;
import yntc.domain.PageBean;
import yntc.domain.User;
import yntc.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao ud = new UserDaoImpl();
    
	@Override
	public int registerUser(User user) throws Exception {
       int i = ud.addUser(user);
       //System.out.println(i);
		if(i>0) {
			return i;
		}else {
			 throw new RuntimeException("注册失败，请重试");
		}
	}

	@Override
	public User loginUser(String username, String password) throws Exception {
		User user = ud.findUserByUsernameAndPassword(username, password);
		if(user!=null) {
			return user;
		}else {
			throw new RuntimeException("登录失败，用户名或密码错误");
		}
	}

	@Override
	public User findUserById(int id) {
        User user = ud.findUserById(id);
        if(user!=null) {
        	return user;
        }else {
			throw new RuntimeException("没有该用户");
		}
		
	}

	@Override
	public int updateUser(String name, String email, String username, String qq, String telphone, int id) {
		int i=ud.updateUser(name,email,username,qq,telphone,id);
		if(i>0) {
			return i;
		}else {
			throw new RuntimeException("修改用户失败");
		}
	}

	@Override
	public int updateUserBalanceReduce(HttpSession session, int totalprice) {
       int i=ud.updateUserBalanceReduce(session, totalprice);
       if(i>0) {
    	   return i;
       }else {
			throw new RuntimeException("修改失败");
		}
	}

	@Override
	public int updateAdminBalanceAdd(int totalprice) {
		 int i=ud.updateAdminBalanceAdd(totalprice);
	       if(i>0) {
	    	   return i;
	       }else {
				throw new RuntimeException("修改失败");
			}
	}

	@Override
	public int updateAdminBalanceReduce(int count) {
		int i=ud.updateAdminBalanceReduce(count);
		if(i>0) {
	    	   return i;
	       }else {
				throw new RuntimeException("修改失败");
			}
	}

	@Override
	public int updateStoreBalanceAdd(int storeid, int count) {
       int i=ud.updateStoreBalanceAdd(storeid, count);
       if(i>0) {
    	   return i;
       }else {
			throw new RuntimeException("修改失败");
		}
	}

	@Override
	public PageBean<User> findUserByRole(int currentPage,int pageSize) {
       List<User> user=ud.findUserByRole(currentPage,pageSize);
       Integer count = ud.count();
		PageBean<User> pb = new PageBean<>();
		pb.setCurrentPage(currentPage);
		pb.setPageSize(pageSize);                  
		pb.setCount(count);
		int totalPage = (int)Math.ceil(count*1.0/pageSize);
		pb.setTotalPage(totalPage);
		pb.setList(user);
		
		return pb;
	}

	@Override
	public User countUser() {
        User user=ud.countUser();
		return user;
	}

	@Override
	public int upodateUserState(int id) {
		int i=ud.updateUserState(id);
		if(i>0) {
			return i;
		}else {
			throw new RuntimeException("更新失败");
		}
	}

	@Override
	public List<User> findStoreByRole() {
        List<User> user=ud.findStoreByRole();
		return user;
	}

	@Override
	public int thUpdatePtBalanceReduce( int count) {
		int i=ud.thUpdatePtBalanceReduce(count);
		return i;
	}

	@Override
	public int thUpdateUserBalanceAdd(HttpSession session, int count) {
        int i=ud.thUpdateUserBalanceAdd(session, count);
		return i;
	}

	@Override
	public int recharge(HttpSession session, int recharge) {
        int i=ud.recharge(session, recharge);
        if(i>0) {
			return i;
		}else {
			throw new RuntimeException("充值失败");
		}
	}

	@Override
	public int adminBalance() {
		int i=ud.adminBalance();
		 if(i>0) {
				return i;
			}else {
				throw new RuntimeException("查询失败");
			}
	}

	
	

}
