package com.bankapp.web.controller.home;

public class AccountUpdateRequest {
	private String email;
	private String phone;
	private String address;
	private String city;
	private String country;
	private Double balance;
	private boolean blocked;
	
	
	
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
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
	
	public AccountUpdateRequest(String email, String phone, String address, String city, String country, Double balance,
			boolean blocked) {
		super();
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.country = country;
		this.balance = balance;
		this.blocked = blocked;
	}
	public AccountUpdateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AccountUpdateRequest [email=" + email + ", phone=" + phone + ", address=" + address + ", city=" + city
				+ ", country=" + country + "]";
	}
	
	
}
