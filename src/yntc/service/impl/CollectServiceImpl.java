package yntc.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import yntc.dao.CollectDao;
import yntc.dao.impl.CollectDaoImpl;
import yntc.domain.Collect;
import yntc.service.CollectService;

public class CollectServiceImpl implements CollectService {

	CollectDao cd=new CollectDaoImpl();
	@Override
	public int addCollect(int goodsid, HttpSession session) {
       int i=cd.addCollect(goodsid, session);
       if(i>0) {
    	   return i;
       }else {
    	   throw new RuntimeException("收藏失败");
       }
	}
	@Override
	public List<Collect> findCollectByUserid(HttpSession session) {
         List<Collect> collect=cd.findCollectByUserid(session);
        	 return collect;
     }
	@Override
	public int cancelCollect(int cid) {
		int i=cd.cancelCollect(cid);
		if(i>0) {
			 return i;
		}else {
			throw new RuntimeException("取消收藏失败");
		}
	}

}
