package yntc.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class UserForm {
  private String name;
  private String email;
  private String username;
  private String password;
  private String repassword;
  private String qq;
  private String telphone;
  private String region;
  private String address;
  
  Map<String,String> msg = new HashMap<String,String>();
   
   public Boolean validate() {
	   if("".equals(name)) {
		   msg.put("name", "昵称不能为空");
	   }
	   if("".equals(email)) {
		   msg.put("email","邮箱不能为空");
		   
	   }else if(!email.matches("\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b"
)) {
		   msg.put("email","邮箱格式不正确");
	   }
	   if("".equals(username)) {
		   msg.put("username","用户名不能为空");
	   }else if(!username.matches("\\w{3,8}")){
		   msg.put("username","用户必须是3-8位的英文");
		   
	   }if("".equals(password)) {
		   msg.put("password","密码不能为空");
	   }else if(!password.matches("\\d{3,8}")){
		   msg.put("password","密码必须是3-8位的英文或数字");
	   }
	   if(!password.equals(repassword)) {
		   msg.put("repassword", "两次密码要一致");	   
	   }
       if("".equals(qq)) {
	   msg.put("qq","QQ号不能为空");
       }
       if("".equals(telphone)) {
    	   msg.put("telphone","联系电话号不能为空");
           }
       if("".equals(region)) {
    	   msg.put("region","地区号不能为空");
           }
       if("".equals(address)) {
    	   msg.put("address","详细地址不能为空");
           }
	   
	   return msg.isEmpty();
   }
public UserForm() {
	super();
	
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRepassword() {
	return repassword;
}
public void setRepassword(String repassword) {
	this.repassword = repassword;
}
public String getQq() {
	return qq;
}
public void setQq(String qq) {
	this.qq = qq;
}
public String getTelphone() {
	return telphone;
}
public void setTelphone(String telphone) {
	this.telphone = telphone;
}
public String getRegion() {
	return region;
}
public void setRegion(String region) {
	this.region = region;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Map<String, String> getMsg() {
	return msg;
}
public void setMsg(Map<String, String> msg) {
	this.msg = msg;
}


}
