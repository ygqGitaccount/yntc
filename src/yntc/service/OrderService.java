package yntc.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import yntc.domain.Bar;
import yntc.domain.Goods;
import yntc.domain.Order;
import yntc.domain.PageBean;
import yntc.domain.Pie;

public interface OrderService {
	public int addOrder(HttpSession session, Integer cid,String remark,int storeid);
	public int addOrders(HttpSession session, String cids,String remark,String states);
	public PageBean<Order> findOrderByState(int currentPage,int pageSize,HttpSession session) throws Exception;
	public int updateOrderstateConfiemReceipt(int oid);
	public int updateOrderstateAppraise(int oid);
	public Order findOrderByOid(int oid);
	public int delOrderByOid(int oid);
	public int updateOrder(int oid,String uname,String address,String telephone,String remark);
	public int backstageUpdateOrderCount(int oid);
	public PageBean<Order> backstageFindOrderByState(int currentPage,int pageSize,HttpSession session)throws Exception;
	public List<Bar> orderChart(String goodsname,String year,HttpSession session);
	public List<Pie> chartPie(String year,HttpSession session);
	public int thUpdateOrderOrderstate(int oid);
	public int thUpdateoOrderTh(int oid);
}
