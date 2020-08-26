package yntc.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import utils.ManagerThreadLocal;
import yntc.dao.OrderDao;
import yntc.dao.impl.OrderDaoImpl;
import yntc.domain.Bar;
import yntc.domain.Goods;
import yntc.domain.Order;
import yntc.domain.PageBean;
import yntc.domain.Pie;
import yntc.service.OrderService;

public class OrderServiceImpl implements OrderService {

	 OrderDao od =new OrderDaoImpl();

	@Override
	public int addOrder(HttpSession session, Integer cid, String remark,int storeid) {
         int i=od.addOrder(session, cid, remark,storeid);
         if(i>0) {
        	 return i;
         }else {
        	 throw new RuntimeException("创建订单失败");
         }
	}

	@Override
	public int addOrders(HttpSession session, String cids, String remark,String states) {
		ManagerThreadLocal.startTransacation();
		String[] ids = cids.split(",");
		String[] States=states.split(",");
		try {
			int a=0;
			int b=0;
			for(int i=0;i<ids.length;i++) {
				String A=ids[i];
				a=Integer.parseInt(A);
				//System.out.println(a);
				for(int j=i;j<=i;j++) {
			    String B=States[j];
			    b=Integer.parseInt(B);
			    //System.out.println(b);
			    int k= od.addOrder(session,a,remark,b);
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
	public PageBean<Order> findOrderByState(int currentPage, int pageSize, HttpSession session) throws Exception {
		List<Order> order = od.findOrderByState(currentPage, pageSize, session);
		Integer count = od.count(session);
		PageBean<Order> pb = new PageBean<>();
		pb.setCurrentPage(currentPage);
		pb.setPageSize(pageSize);                  
		pb.setCount(count);
		int totalPage = (int)Math.ceil(count*1.0/pageSize);
		pb.setTotalPage(totalPage);
		pb.setList(order);
		
		return pb;
	}

	@Override
	public int updateOrderstateConfiemReceipt(int oid) {
       int i=od.updateOrdstateConfirmReceipt(oid);
       if(i>0) {
      	 return i;
       }else {
      	 throw new RuntimeException("确认收货失败");
       }
	}

	@Override
	public int updateOrderstateAppraise(int oid) {
		 int i=od.updateOrderstateAppraise(oid);
	       if(i>0) {
	      	 return i;
	       }else {
	      	 throw new RuntimeException("评价失败");
	       }
	}

	@Override
	public Order findOrderByOid(int oid) {
		Order order=od.findOrderByOid(oid);
		return order;
	}

	@Override
	public int delOrderByOid(int oid) {
        int i=od.delOrderByOid(oid);
        if(i>0) {
        	return i;
        }else {
        	throw new RuntimeException("删除失败");
        }
	}

	@Override
	public int updateOrder(int oid, String uname, String address, String telephone, String remark) {
		 int i=od.updateOrder(oid, uname, address, telephone, remark);
		if(i>0) {
	    	   return i;
	       }else {
	    	   throw new RuntimeException("修改订单失败");
	       }
	}

	@Override
	public int backstageUpdateOrderCount(int oid) {
        int i=od.backstageUpdateOrderCount(oid);
        if(i>0) {
        	return i;
        }else {
        	throw new RuntimeException("修改失败");
        }
        		
	}

	@Override
	public PageBean<Order> backstageFindOrderByState(int currentPage, int pageSize, HttpSession session) throws Exception {
		List<Order> order = od.backstageFindOrderByState(currentPage, pageSize, session);
		Integer count = od.backStageCount(session);
		PageBean<Order> pb = new PageBean<>();
		pb.setCurrentPage(currentPage);
		pb.setPageSize(pageSize);                  
		pb.setCount(count);
		int totalPage = (int)Math.ceil(count*1.0/pageSize);
		pb.setTotalPage(totalPage);
		pb.setList(order);
		
		return pb;
	}

	@Override
	public List<Bar> orderChart(String goodsname, String year, HttpSession session) {
        List<Bar> bar=od.orderChart(goodsname, year, session);
		return bar;
	}

	@Override
	public List<Pie> chartPie(String year, HttpSession session) {
		List<Pie> pie=od.chartPie(year, session);
		return pie;
	}

	@Override
	public int thUpdateOrderOrderstate(int oid) {
         int i=od.thUpdateOrderOrderstate(oid);
		return i;
	}

	@Override
	public int thUpdateoOrderTh(int oid) {
       int i=od.thUpdateOrderTh(oid);
		return i;
	}

	


}
