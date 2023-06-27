package com.banking.modeldata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.Customer;
import com.banking.modelremote.CustomerRemote;
import com.banking.repository.CustomerRepository;

@Service
public class CustomerData implements CustomerRemote
{
	@Autowired
	private CustomerRepository customerRepository;
	@Override
	public String addNewCustomer(Customer customer) 
	{
		String s = null;
		try
		{
			customerRepository.save(customer);
			s = "Customer Record Added Successfully";
		}
		catch (Exception e) 
		{
			s = "Unsuccessfull, Check for aadhar, pan, contact numbers";
			System.out.println(e);
		}
		return s;
	}
	@Override
	public int getMaxCustomerID() 
	{
		return customerRepository.getNewCustomerID();
	}
	@Override
	public Customer getCustomerDetails(int custId) 
	{
		Customer customer = new Customer();
		customer = customerRepository.getCustomerDetails(custId);
		return customer;
	}
	@Override
	public List<Customer> getAllCustomerIDS() 
	{
		List<Customer> integers = customerRepository.getAllCustIds();
		return integers;
	}
	@Override
	public long getAllCustomersCount() 
	{
		return customerRepository.count();
	}
	
}
