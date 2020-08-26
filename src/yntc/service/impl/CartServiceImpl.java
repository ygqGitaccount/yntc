package yntc.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import utils.ManagerThreadLocal;
import yntc.dao.CartDao;
import yntc.dao.impl.CartDaoImpl;
import yntc.domain.Cart;
import yntc.domain.Goods;
import yntc.service.CartService;

public class CartServiceImpl implements CartService {
     CartDao cd =new CartDaoImpl();
	@Override
	public int addCart(int id,int buyNum,int storeid,HttpSession session) {
      int i=cd.addCart( id,buyNum,storeid,session );
      if(i>0) {
			return i;
		}else {
			throw new RuntimeException("加入购物车失败");
		}
	}
	@Override
	public List<Cart> findCartGoodsByState(HttpSession session) {
		List<Cart> carts=cd.findCartGoodsByState(session);
		
		return carts;
	}
	@Override
	public int delCartGoodsByCid(int cid) {
        int i=cd.delCartGoodsByCid(cid);
        if(i>0) {
        	return i;
        }else {
        	throw new RuntimeException("删除失败");
        }
		
	}
	@Override
	public int updateCartNumber(int cid, int number) {
       int i=cd.updateCartNumber(cid, number);
       if(i>0) {
    	   return i;
       }else {
    	   throw new RuntimeException("修改失败");
       }
		
	}
	
	@Override
	public int updateCartGoodsState(int cid) {
      int i=cd.updateCartGoodsState(cid);
      if(i>0) {
    	  return i;
      }else {
    	  throw new RuntimeException("修改失败");
      }
	}
	@Override
	public int updateCartGoods(String cids) {
		ManagerThreadLocal.startTransacation();
		String[] cid = cids.split(",");
		try {
			for(String id : cid) {
				int i=Integer.parseInt(id);
				int j= cd.updateCartGoodsState(i);
				if(j==0){
					throw new RuntimeException("修改失败");
				}
			}
			ManagerThreadLocal.commit();
		} catch (Exception e) {
			ManagerThreadLocal.rollback();
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

}
