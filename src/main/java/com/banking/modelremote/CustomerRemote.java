package com.banking.modelremote;

import java.util.List;

import com.banking.entity.Customer;

public interface CustomerRemote 
{
	public String addNewCustomer(Customer customer);
	public int getMaxCustomerID();
	public Customer getCustomerDetails(int custId);
	public List<Customer> getAllCustomerIDS();
	public long getAllCustomersCount();
}
