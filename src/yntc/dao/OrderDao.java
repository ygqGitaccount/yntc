package yntc.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import yntc.domain.Bar;
import yntc.domain.Order;
import yntc.domain.Pie;

public interface OrderDao {
	public int addOrder(HttpSession session,int cid,String remark,int storeid);
	public List<Order> findOrderByState(int currentPage,int pageSize,HttpSession session)throws Exception;
	public Integer count(HttpSession session);
	public int updateOrdstateConfirmReceipt(int oid);
	public int updateOrderstateAppraise(int oid);
	public Order findOrderByOid(int oid);
	public int delOrderByOid(int oid);
	public int updateOrder(int oid,String uname,String address,String telephone,String remark);
	public int backstageUpdateOrderCount(int oid);
	public List<Order> backstageFindOrderByState(int currentPage,int pageSize,HttpSession session)throws Exception;
	public Integer backStageCount(HttpSession session);
	public List<Bar> orderChart(String goodsname,String year,HttpSession session);
	public List<Pie> chartPie(String year,HttpSession session);
	public int thUpdateOrderOrderstate(int oid);
	public int thUpdateOrderTh(int oid);
}
