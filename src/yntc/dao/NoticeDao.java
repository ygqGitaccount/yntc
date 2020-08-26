package yntc.dao;

import java.util.List;

import yntc.domain.Notice;

public interface NoticeDao {
	public int addNotice(String title,String content);
	public List<Notice> findNotice();
	public Notice findNoticeById(int id);
    public int updateNotice( String title,String content,int id);
    public int delNoticeById(int id);
}
