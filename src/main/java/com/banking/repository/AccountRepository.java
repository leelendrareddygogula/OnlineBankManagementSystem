package com.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banking.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer>
{
	@Query("select max(accountNumber) from Account a")
	public int getMaxAccountNumber();
	@Query("select a from Account a where customerId = ?1")
	public List<Account> allAccounts(int custId);
	@Query("select count(a) from Account a where a.accountNumber = ?1")
	public int getExistingStatusOfAccount(long num);
	@Query("select a.balance from Account a where a.accountNumber = ?1")
	public double getAccountBalance(long num);
	@Query("select a from Account a where a.accountNumber = ?1")
	public Account getAccountById(long id);
}
