package yntc.service.impl;

import java.util.List;

import yntc.dao.NoticeDao;
import yntc.dao.impl.NoticeDaoImpl;
import yntc.domain.Notice;
import yntc.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	 NoticeDao nd= new NoticeDaoImpl();
	@Override
	public int addNotice(String title, String content) {
        int i=nd.addNotice(title, content);   
		if(i>0) {
			return i;
		}else {
			throw new RuntimeException("添加公告失败");
		}
	}
	@Override
	public List<Notice> findNiotice() {
       List<Notice> notice =nd.findNotice();
		return notice;
	}
	@Override
	public Notice findNoticeById(int id) {
		Notice notice=nd.findNoticeById(id);
		if(notice!=null) {
			return notice;
		}else {
			throw new RuntimeException("没有该公告");
		}
	}
	@Override
	public int updateNotice(String title, String content, int id) {
		int i=nd.updateNotice(title, content, id);
		if(i>0) {
			return i;
		}else {
			throw new RuntimeException("修改失败");
		}
	}
	@Override
	public int delNoticeById(int id) {
		int i=nd.delNoticeById(id);
		if(i>0) {
			return i;
		}else {
			throw new RuntimeException("删除失败");
		}
	}

}
