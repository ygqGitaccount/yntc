package yntc.domain;

import java.util.Date;

public class Order {
  private int oid;
  private int uid;
  private int cid;
  private int goodsid;
  private String time;
  private String ordState;
  private String remark;
  private int storeid;
  private String gname;
  private String address;
  private String telephone;
  private int totalprice;
  private int price;
  private int number;
  private int goodsstate;
  private String uname;
  private String gpicurl;
  private String count;
  private int th;
public Order() {
	super();
	// TODO Auto-generated constructor stub
}
public Order(int oid, int uid, int cid, int goodsid, String time, String ordState, String remark, int storeid,String gname,String address,String telephone,int totalprice,int price,int number,int goodsstate,String uname,String gpicurl,String count,int  th) {
	super();
	this.oid = oid;
	this.uid = uid;
	this.cid = cid;
	this.goodsid = goodsid;
	this.time = time;
	this.ordState = ordState;
	this.remark = remark;
	this.storeid = storeid;
	this.gname=gname;
	this.address=address;
	this.telephone=telephone;
	this.totalprice=totalprice;
	this.price=price;
	this.number=number;
	this.goodsstate=goodsstate;
	this.uname=uname;
	this.gpicurl=gpicurl;
	this.count=count;
	this.th=th;
}

public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public int getGoodsid() {
	return goodsid;
}
public void setGoodsid(int goodsid) {
	this.goodsid = goodsid;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public String getOrdState() {
	return ordState;
}
public void setOrdState(String ordState) {
	this.ordState = ordState;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public int getStoreid() {
	return storeid;
}
public void setStoreid(int storeid) {
	this.storeid = storeid;
}
public String getGname() {
	return gname;
}
public void setGname(String gname) {
	this.gname = gname;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public int getTotalprice() {
	return totalprice;
}
public void setTotalprice(int totalprice) {
	this.totalprice = totalprice;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public int getGoodsstate() {
	return goodsstate;
}
public void setGoodsstate(int goodsstate) {
	this.goodsstate = goodsstate;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getGpicurl() {
	return gpicurl;
}
public void setGpicurl(String gpicurl) {
	this.gpicurl = gpicurl;
}
public String getCount() {
	return count;
}
public void setCount(String count) {
	this.count = count;
}
public int  getTh() {
	return th;
}
public void setTh(int th) {
	this.th = th;
}
}
