package yntc.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import yntc.domain.Cart;
import yntc.domain.Goods;

public interface CartService {
   public int addCart(int id,int buyNum,int storeid,HttpSession session);
   public List<Cart> findCartGoodsByState(HttpSession session);
   public int delCartGoodsByCid(int cid);
   public int updateCartNumber(int cid,int number);
   public int updateCartGoodsState(int cid);
   public int updateCartGoods(String cids);
}
