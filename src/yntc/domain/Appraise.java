package yntc.domain;

public class Appraise {
private int id;
private int uid;
private int goodsid;
private String content;
private String mark;
private String uname;
public Appraise(int id, int uid, int goodsid, String content, String mark,String uname) {
	super();
	this.id = id;
	this.uid = uid;
	this.goodsid = goodsid;
	this.content = content;
	this.mark = mark;
	this.uname=uname;
}
public Appraise() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getGoodsid() {
	return goodsid;
}
public void setGoodsid(int goodsid) {
	this.goodsid = goodsid;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getMark() {
	return mark;
}
public void setMark(String mark) {
	this.mark = mark;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}



}
