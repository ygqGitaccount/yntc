package yntc.domain;

public class User {
   private int id;
   private String name;
   private String email;
   private String username;
   private String password;
   private String gender;
   private String qq;
   private String telphone;
   private String region;
   private String address;
   private String state;
   private int balance;
   private String role;
   private int countNum;
  
   
   
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(int id, String name, String email, String username, String password, String gender, String qq,
		String telphone, String region, String address, String state, int balance, String role,int countNum) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.username = username;
	this.password = password;
	this.gender = gender;
	this.qq = qq;
	this.telphone = telphone;
	this.region = region;
	this.address = address;
	this.state = state;
	this.balance = balance;
	this.role = role;
	this.countNum=countNum;
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
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
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
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

public int getCountNum() {
	return countNum;
}
public void setCountNum(int countNum) {
	this.countNum = countNum;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", password="
			+ password + ", gender=" + gender + ", qq=" + qq + ", telphone=" + telphone + ", region=" + region
			+ ", address=" + address + ", state=" + state + ", balance=" + balance + ", role=" + role + ", countNum="
			+ countNum + "]";
}


}
