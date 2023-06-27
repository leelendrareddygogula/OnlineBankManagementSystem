package com.banking.modelremote;

import java.util.List;

import com.banking.entity.Account;

public interface AccountRemote 
{
	public String createCustomerAccount(Account account);
	public int getMaxAccountNumber();
	public List<Account> allAccounts(int custId);
	public boolean accountExists(long id);
	public double getAccountBalance(long accountNumber);
	public Account getAccountById(long id);
	public long getCountOfAccounts();
	public List<Account> getAllAccounts();
}
