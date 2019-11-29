package com.bankapp.web.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.CustomerService;
import com.bankapp.model.service.exceptions.AccountNotFoundException;
import com.bankapp.web.controller.home.AccountUpdateRequest;
import com.bankapp.web.controller.home.FormBean;

@RestController
@RequestMapping(path = "/api")
public class RestAppController {

	@Autowired
	private AccountService accountService;

	private CustomerService customerService;

	@Autowired
	public RestAppController(CustomerService customerService) {

		this.customerService = customerService;
	}

	
	public RestAppController(AccountService accountService) {

		this.accountService = accountService;
	}

	/*
	 * @GetMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public ResponseEntity<List<Account>> getAllAccounts() { return new
	 * ResponseEntity<List<Account>>(accountService.getAllAccount(), HttpStatus.OK);
	 * }
	 */

	@GetMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Customer>> getAllCustomer() {
		return new ResponseEntity<List<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
	}

	@GetMapping(path = "/account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> getAnCustomer(@PathVariable(name = "id") Long id) {
		Customer customer = customerService.findCustomerById(id).orElseThrow(AccountNotFoundException::new);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@DeleteMapping(path = "/account/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteCustomer(@PathVariable(name = "id") Long id) {
		customerService.deleteCustomer(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping(path = "/account/{accountNumber}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> updateAccount(@PathVariable(name = "accountNumber") Long accountNumber,
			@RequestBody AccountUpdateRequest request) {
			
		Customer customer=accountService.getCustomerById(accountNumber);
		customer.setEmail(request.getEmail());
		customer.setCountry(request.getCountry());
		customer.setCity(request.getCity());
		customer.setAddress(request.getAddress());
		customer.setPhone(request.getPhone());
		
		
		Account account=accountService.getAccountById(accountNumber);
	account.setBalance(request.getBalance());
	account.setBlocked(request.isBlocked());
	customer.setAccount(account);
	account.setCustomer(customer);
		return new ResponseEntity<Account>(accountService.createAccount(account), HttpStatus.OK);
	}
	
	/*
	 * @PutMapping(path = "/customer/{id}", consumes =
	 * MediaType.APPLICATION_JSON_VALUE, produces =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<Customer>
	 * updateCustomer(@PathVariable(name = "id") Long id, @RequestBody Customer
	 * customer) {
	 * 
	 * return new ResponseEntity<Customer>(customerService.updateCustomer(id,
	 * customer), HttpStatus.OK); }
	 */

	@PostMapping(path = "/account", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> addCustomer(@RequestBody FormBean formBean) {
		Customer cust = new Customer(formBean.getName(), formBean.getEmail(), formBean.getPhone(),
				formBean.getAddress(), formBean.getCity(), formBean.getCountry());
		Account acc = new Account(formBean.getBalance(), cust, formBean.isBlocked());
		cust.setAccount(acc);

		return new ResponseEntity<Account>(accountService.addAccount(acc), HttpStatus.OK);
	}
		
	

	/*
	 * @GetMapping(path = "home") public String home() { return "hello to home"; }
	 * 
	 * @GetMapping(path = "admin") public String homeAdmin() { return
	 * "hello to home admin"; }
	 * 
	 * @GetMapping(path = "mgr") public String homeMgr() { return
	 * "hello to home mgr"; }
	 * 
	 * @GetMapping(path = "clerk") public String homeuser() { return
	 * "hello to home clerk"; }
	 */
}
