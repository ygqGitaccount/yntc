package yntc.service;

import java.util.List;

import yntc.domain.Notice;

public interface NoticeService {
	public int addNotice(String title,String content);
	public List<Notice> findNiotice();
	public Notice findNoticeById(int id);
	public int updateNotice( String title,String content,int id);
	public int delNoticeById(int id);
}
