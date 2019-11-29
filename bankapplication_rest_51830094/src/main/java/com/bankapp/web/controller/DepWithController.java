package com.bankapp.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.CustomerService;
import com.bankapp.web.controller.home.DepositWithdrawReq;

@RestController
@RequestMapping(path = "/api/transaction")
public class DepWithController {
	@Autowired
	private AccountService accountService;

	@Autowired
	private CustomerService customerService;

	public DepWithController(AccountService accountService, CustomerService customerService) {
		super();
		this.accountService = accountService;
		this.customerService = customerService;
	}
	
	@PostMapping(path = "/deposit")
	public ResponseEntity<Account> deposit(@RequestBody DepositWithdrawReq reqController,Principal principal){
		//Account account2=accountService.getAccountById(accountNumber);
	//reqController.setAmount(reqController.getAmount());
		accountService.deposit(reqController.getAccountNumber(),reqController.getAmount());
		
		return new ResponseEntity<Account>(HttpStatus.OK);
		
	}
	
	@PostMapping(path = "/withdraw")
	public ResponseEntity<Account> withdraw(@RequestBody DepositWithdrawReq reqController,Principal principal){
		//Account account2=accountService.getAccountById(accountNumber);
	//reqController.setAmount(reqController.getAmount());
		accountService.withdraw(reqController.getAccountNumber(),reqController.getAmount());
		
		return new ResponseEntity<Account>(HttpStatus.OK);
		
	}

}
