package com.custapp.model.persistance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "table1")
public class Customer {
	@Id
	@GeneratedValue
	private int id;

	@NotEmpty(message = "name cant be left blank")
	private String name;

	@NotNull(message = "phonenumber cant be left blank")
	private Integer phonenumber;

	@NotEmpty(message = "email cant be left blank")
	private String email;

	@NotEmpty(message = "gender cant be left blank")
	private String gender;

	@NotEmpty(message = "address cant be left blank")
	private String address;

	@NotNull(message = "salary cant be left blank")
	@Min(value = 10, message = "min value should be more then 10")
	@Max(value = 10000, message = "min value should be more then 10000")
	private Double salary;

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

	

	public Integer getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Integer phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Customer() {
		super();

	}

	public Customer(String name, Integer phonenumber, String email, String gender, String address, Double salary) {
		super();
		this.name = name;
		this.phonenumber = phonenumber;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.salary = salary;
	}

	

}
