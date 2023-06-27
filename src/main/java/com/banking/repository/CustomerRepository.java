package com.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banking.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>
{
	@Query("select max(customerId) from Customer c")
	public int getNewCustomerID();
	@Query("select c from Customer c where customerId = ?1")
	public Customer getCustomerDetails(int custId);
	@Query("select c from Customer c")
	public List<Customer> getAllCustIds();
}
