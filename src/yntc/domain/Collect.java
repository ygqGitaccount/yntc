package yntc.domain;

public class Collect {
	private int id;
	private int userid;
	private int goodsid;
	private String picurl;
	private String name;
	private int price;
	private int state;
	private int num;
	private int cid;
  
	
	public Collect(int id, int userid, int goodsid, String picurl, String name, int price, int state, int num,
			int cid) {
		super();
		this.id = id;
		this.userid = userid;
		this.goodsid = goodsid;
		this.picurl = picurl;
		this.name = name;
		this.price = price;
		this.state = state;
		this.num = num;
		this.cid = cid;
	}
	public Collect() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}

}
