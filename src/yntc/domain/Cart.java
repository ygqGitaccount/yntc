package yntc.domain;

import java.util.Enumeration;

public class Cart {
	private int cid;
	private  int userid;
	private int goodsid;
	private String mark;
	private String picurl;
	private String name;
	private int price;
	private int number;
	private int num;
	private int state;
	private int storeid;
	private int balance;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Cart(int cid, int userid, int goodsid, String mark, String picurl, String name, int price, int number,
			int num,int state,int storeid,int balance) {
		super();
		this.cid = cid;
		this.userid = userid;
		this.goodsid = goodsid;
		this.mark = mark;
		this.picurl = picurl;
		this.name = name;
		this.price = price;
		this.number = number;
		this.num = num;
		this.state=state;
		this.storeid=storeid;
		this.balance=balance;
	}



	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	public int getstate() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getStoreid() {
		return storeid;
	}
	public void setStoreid(int storeid) {
		this.storeid = storeid;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	
	
}
