package com.bankapp.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.CustomerService;
import com.bankapp.model.service.TransactionLogService;
import com.bankapp.web.controller.home.TransferReq;

@RestController
@RequestMapping(path = "/api/transaction")
public class TransferController {


	private AccountService accountService;

	
	private CustomerService customerService;
	
	
	private TransactionLogService transactionLogService;

	@Autowired
	public TransferController(AccountService accountService, CustomerService customerService) {
		super();
		this.accountService = accountService;
		this.customerService = customerService;
	}
	
	@Autowired
	public TransactionLogService getTransactionLogService() {
		return transactionLogService;
	}


	public void setTransactionLogService(TransactionLogService transactionLogService) {
		this.transactionLogService = transactionLogService;
	}


	@PostMapping(path = "/transfer")
	public ResponseEntity<Account> transfer(@RequestBody TransferReq req,Principal principal){
		
		accountService.transfer(req.getFromAccount(),req.getToAccount(),req.getAmount());
		
		return new ResponseEntity<Account>(HttpStatus.OK);
		
	}
	@GetMapping(path="/alltransaction",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<TransactionLog>getAllTransaction(){
		return transactionLogService.getAllTransaction();
		
	}
	@GetMapping(path="/alltransaction/{fromAccount}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TransactionLog>>getAllTransactionById(
			@PathVariable(name="fromAccount")Long fromAccount){
		
		return new ResponseEntity<List<TransactionLog>>(transactionLogService.findByfromAccount(fromAccount),HttpStatus.OK);
		
	}
}
