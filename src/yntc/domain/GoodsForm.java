package yntc.domain;

import java.util.HashMap;
import java.util.Map;

public class GoodsForm {
	 private String name;
	 private String type;
	 private String region;
	 private String location;
	 private String monnum;
	 private String num;
	 private String inputprice;
	 private String price;
	 private String state;
	 private String status;
	 private String picurl;
	 
	 Map<String,String> msg = new HashMap<String,String>();
	 public Boolean check() {
		 if("".equals(name)) {
			 msg.put("name", "商品名称不能为空");
		 }
		 if("".equals(type)) {
			 msg.put("type", "类型不能为空");
		 }
		 if("".equals(region)) {
			 msg.put("region", "州市不能为空");
		 }
		 if("".equals(location)) {
			 msg.put("location", "原产地不能为空");
		 }
		 if("".equals(num)) {
			 msg.put("num", "数量不能为空");
		 }
		 if("".equals(inputprice)) {
			 msg.put("inputprice", "进价不能为空");
		 }
		 if("".equals(price)) {
			 msg.put("price", "售价不能为空");
		 }
		 if("".equals(status)) {
			 msg.put("status", "说明不能为空");
		 }
		 if("".equals(picurl)) {
			 msg.put("picurl", "图片不能为空");
		 }
		return msg.isEmpty();
		 
	 }
	public GoodsForm() {
		super();
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
	public String getMonnum() {
		return monnum;
	}
	public void setMonnum(String monnum) {
		this.monnum = monnum;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getInputprice() {
		return inputprice;
	}
	public void setInputprice(String inputprice) {
		this.inputprice = inputprice;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public Map<String, String> getMsg() {
		return msg;
	}
	public void setMsg(Map<String, String> msg) {
		this.msg = msg;
	}

	
	
}
