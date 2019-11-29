package com.bankapp.web.controller.home;

public class FormBean {
private Double balance;
private boolean blocked;
private String name;
private String email;
private String phone;
private String address;
private String city;
private String country;

public Double getBalance() {
	return balance;
}
public void setBalence(Double balance) {
	this.balance = balance;
}
public boolean isBlocked() {
	return blocked;
}
public void setBlocked(boolean blocked) {
	this.blocked = blocked;
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
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public FormBean(Double balance, boolean blocked, String name, String email, String phone, String address, String city,
		String country) {
	super();
	this.balance = balance;
	this.blocked = blocked;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.address = address;
	this.city = city;
	this.country = country;
}
public FormBean() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "FormBean [balance=" + balance + ", blocked=" + blocked + ", name=" + name + ", email=" + email + ", phone="
			+ phone + ", address=" + address + ", city=" + city + ", country=" + country + "]";
}


}
