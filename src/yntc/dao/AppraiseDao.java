package yntc.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import yntc.domain.Appraise;

public interface AppraiseDao {
	public int addAppraise(HttpSession session,int goodsid,String content);
	public List<Appraise> findAppraiseById(int id);

}
