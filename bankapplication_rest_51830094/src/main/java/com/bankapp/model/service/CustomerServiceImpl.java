package com.bankapp.model.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.entities.Customer;
import com.bankapp.model.repo.AccountRepository;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.service.exceptions.AccountNotFoundException;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	@Override
	public List<Customer> getAllCustomers() {
		
		return customerRepository.findAll() ;
	}
	@Override
	public Optional<Customer> findCustomerById(Long id) {
		
		return customerRepository.findById(id);
	}
	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
		accountRepository.deleteById(id);
		
		
	}
	@Override
	public Customer updateCustomer(Long id, Customer customer) {
		Customer customerToBeUpdated=customerRepository.findById(id).orElseThrow(AccountNotFoundException::new);
		customerToBeUpdated.setEmail(customer.getEmail());
		return customerRepository.save(customerToBeUpdated);
	}
	@Override
	public Customer addCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

}
