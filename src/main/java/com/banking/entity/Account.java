package com.banking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "account_details")
public class Account 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_number_generator")
	@SequenceGenerator(initialValue = 100000000, name = "account_number_generator", allocationSize = 1)
	private long accountNumber;
	@Column(nullable = false, length = 50)
	private String branch;
	@Column(nullable = false, precision = 10, scale = 2)
	private double balance;
	@Column(nullable = false, length = 20)
	private int customerId;
	
	@Override 
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", branch=" + branch +  ", balance=" + balance + "]";
	}
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}
