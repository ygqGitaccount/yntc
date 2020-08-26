package yntc.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import yntc.domain.Collect;

public interface CollectDao {
	public int addCollect(int goodsid,HttpSession session);
	public List<Collect> findCollectByUserid(HttpSession session);
	public int cancelCollect(int cid);

}
