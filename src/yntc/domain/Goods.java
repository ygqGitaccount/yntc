package yntc.domain;

public class Goods {
	private int id;
	private String name;
	private String type;
	private String region;
	private String location;
	private int monnum;
	private int num;
	private String picurl;
	private int inputprice;
	private int price;
	private int state;//店主id
	private String status;
	private int number;
	public String storeName;
	public Goods(int id, String name, String type, String region, String location, int monnum, int num, String picurl,
			int inputprice, int price, int state, String status,int number,String storeName) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.region = region;
		this.location = location;
		this.monnum = monnum;
		this.num = num;
		this.picurl = picurl;
		this.inputprice = inputprice;
		this.price = price;
		this.state = state;
		this.status = status;
		this.number=number;
		this.storeName=storeName;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getMonnum() {
		return monnum;
	}
	public void setMonnum(int monnum) {
		this.monnum = monnum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public int getInputprice() {
		return inputprice;
	}
	public void setInputprice(int inputprice) {
		this.inputprice = inputprice;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", type=" + type + ", region=" + region + ", location=" + location
				+ ", monnum=" + monnum + ", num=" + num + ", picurl=" + picurl + ", inputprice=" + inputprice
				+ ", price=" + price + ", state=" + state + ", status=" + status + ", number=" + number + ", storeName="
				+ storeName + "]";
	}
	
	
}
