package yntc.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.w3c.dom.ranges.RangeException;

import utils.ManagerThreadLocal;
import yntc.domain.Goods;
import yntc.domain.PageBean;

import yntc.dao.GoodsDao;
import yntc.dao.impl.GoodsDaoImpl;
import yntc.service.GoodsService;

public class GoodsServiceImpl implements GoodsService {
    GoodsDao gd = new GoodsDaoImpl();
    
	@Override
	public List<Goods> findAll() throws Exception {
		List<Goods> goodses = gd.findAll();
		if(goodses!=null && goodses.size()>0) {
			return goodses;
		}else if(goodses==null && goodses.size()==0){
			 throw new RuntimeException("抱歉，没有商品");
			 
		}
		     return goodses;
	}


	@Override
	public Goods findGoodsById(int id) {
		Goods goods=gd.findGoodsById(id);
		
		return goods;
	}

	@Override
	public int addGoods(Goods goods,HttpSession session) throws Exception {
		int i =gd.addGoods(goods,session);
		if(i>0) {
			return i;
		}else {
			throw new RuntimeException("添加商品失败");
		}
	}

	@Override
	public PageBean<Goods> findGoodsByState(int currentPage,int pageSize,HttpSession session) throws Exception  {
		List<Goods> goods = gd.findGoodsByState(currentPage,pageSize,session);
		Integer count = gd.count(session);
		PageBean<Goods> pb = new PageBean<>();
		pb.setCurrentPage(currentPage);
		pb.setPageSize(pageSize);                  
		pb.setCount(count);
		int totalPage = (int)Math.ceil(count*1.0/pageSize);
		pb.setTotalPage(totalPage);
		pb.setList(goods);
		
		return pb;
		
	}

	@Override
	public int updateGoods(Goods goods){
		int i=gd.updateGoods(goods);
		if(i>0) {
			return i;
		}else {
			throw new RuntimeException("修改失败");
		}
	}

	@Override
	public int deleteGoodsById(int id) {
        int i =gd.deleteGoodsById(id);
        if(i>0) {
        	return i;
        }else {
        	throw new RuntimeException("删除失败");
        }
	}

	@Override
	public List<Goods> findGoodsByState(int state) {
		List<Goods> goodses = gd.findGoodsByState(state);
		if(goodses!=null && goodses.size()>0) {
			return goodses;
		}else if(goodses==null && goodses.size()==0){
			 throw new RuntimeException("抱歉，没有商品");
			 
		}
		     return goodses;
	}

	@Override
	public List<Goods> findMoreFood() {
		List<Goods> goods=gd.findMoreFood();
		if(goods!=null && goods.size()>0) {
			return goods;
		}else if(goods==null && goods.size()==0){
			 throw new RuntimeException("抱歉，没有商品");
		}
		     return goods;
	}

	@Override
	public List<Goods> findMoreHandicraft() {
       List<Goods> goods=gd.findMoreHandicraft();
      /*if(goods!=null && goods.size()>0) {
    	   return goods;
       }else if(goods==null && goods.size()==0){
			 throw new RuntimeException("抱歉，没有商品");
		}*/
		     return goods;
	}

	@Override
	public List<Goods> findMoreFruit() {
		List<Goods> goods=gd.findMoreFruit();
	      /* if(goods!=null && goods.size()>0) {
	    	   return goods;
	       }else if(goods==null && goods.size()==0){
				 throw new RuntimeException("抱歉，没有商品");
			}*/
		System.out.println("hhh");
		System.out.println(goods);
			     return goods;
	}

	@Override
	public List<Goods> findMoreMeat() {
		List<Goods> goods=gd.findMoreMeat();
	       if(goods!=null && goods.size()>0) {
	    	   return goods;
	       }else if(goods==null && goods.size()==0){
				 throw new RuntimeException("抱歉，没有商品");
			}
			     return goods;
	}

	@Override
	public List<Goods> findMoreDryCargo() {
		List<Goods> goods=gd.findMoreDryCargo();
	       if(goods!=null && goods.size()>0) {
	    	   return goods;
	       }else if(goods==null && goods.size()==0){
				 throw new RuntimeException("抱歉，没有商品");
			}
			     return goods;
	}


	@Override
	public List<Goods> searchGoodsByName(String word) {
		List<Goods> goods=gd.searchGoodsByName(word);
	       if(goods!=null && goods.size()>0) {
	    	   return goods;
	       }else if(goods==null && goods.size()==0){
				 throw new RuntimeException("抱歉，没有商品");
			}
			     return goods;
	}


	@Override
	public List<String> searchGoodsByLikeName(String word) {
       List<String> list=gd.searchGoodsByLikeName(word);
		return list;
	}


	@Override
	public int updateGoodsNum(int goodsid,int number) {
		int i=gd.updateGoodsNumRaduce(goodsid,number);
		if(i>0) {
			return i;
		}else {
			throw new RuntimeException("更新失败");
		}
	}


	@Override
	public int updateGoodsidsNum(String goodsids, String numbers) {
		ManagerThreadLocal.startTransacation();
		String[] ids = goodsids.split(",");
		String[] numbs=numbers.split(",");
		try {
			int a=0;
			int b=0;
			for(int i=0;i<ids.length;i++) {
				String A=ids[i];
				a=Integer.parseInt(A);
				//System.out.println(a);
				for(int j=i;j<=i;j++) {
					String B=numbs[j];
					 b=Integer.parseInt(B);
					 //System.out.println(b);
					int k=gd.updateGoodsNumRaduce(a, b);
					if(k==0){
						throw new RuntimeException("添加失败");
					}
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
	@Override
	public Goods findStoreName(int state) {
       Goods goods=gd.findStoreName(state);
		 
		return goods;
	}
	@Override
	public List<Goods> findGoodsByType(String type,int state) {
        List<Goods> goods=gd.findGoodsByType(type,state);
		return goods;
	}
	@Override
	public List<Goods> findGoodsAll(int state) {
        List<Goods> goods=gd.findGoodsAll(state);
		return goods;
	}


	@Override
	public int updateGoodsNumberAdd(int number, int gid) {
      int i=gd.updateGoodsNumberAdd(number, gid);
		return i;
	}


	@Override
	public Integer count(HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}



	
	
}