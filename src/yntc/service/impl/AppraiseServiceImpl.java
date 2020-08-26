package yntc.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import yntc.dao.AppraiseDao;
import yntc.dao.impl.AppraiseDaoImpl;
import yntc.domain.Appraise;
import yntc.service.AppraiseService;

public class AppraiseServiceImpl implements AppraiseService {

	AppraiseDao ad=new AppraiseDaoImpl();
	@Override
	public int addAppraise(HttpSession session, int goodsid, String content) {
		int i=ad.addAppraise(session, goodsid, content);
		if(i>0) {
			return i;
		}else {
			throw new RuntimeException("评价失败");
		}
	}
	@Override
	public List<Appraise> findAppraiseById(int id) {
		List<Appraise> appraise=ad.findAppraiseById(id);
		if(appraise!=null && appraise.size()>0) {
			return appraise;
		}else if(appraise==null && appraise.size()==0){
			throw new RuntimeException("没有评价");
		}
		return appraise;
	}

}
