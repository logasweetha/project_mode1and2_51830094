package com.bankapp.web.controller.home;

public class DepositWithdrawReq {
	
	private Long accountNumber;
	private double amount;
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public double setAmount(double amount) {
		return this.amount = amount;
	}

	


}
