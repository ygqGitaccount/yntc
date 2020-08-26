package yntc.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import yntc.domain.PageBean;
import yntc.domain.User;

public interface UserDao {
      public int addUser(User user) throws Exception;
      public User findUserByUsernameAndPassword(String username,String password) throws Exception;
      public int updateUser(String name, String email, String username,String qq,String telphone,int id);
      public User findUserById(int id);
      public int updateUserBalanceReduce(HttpSession session,int totalprice);
      public int updateAdminBalanceAdd(int totalprice);
      public int updateAdminBalanceReduce(int count);
      public int updateStoreBalanceAdd(int storeid,int count);
      public List<User> findUserByRole(int currentPage,int pageSize);
      public User countUser();
      public int updateUserState(int id);
      public Integer count();
      public List<User> findStoreByRole();
      public int thUpdatePtBalanceReduce(int count);
      public int thUpdateUserBalanceAdd(HttpSession session,int count);
      public int recharge(HttpSession session,int recharge);
      public int adminBalance();
}