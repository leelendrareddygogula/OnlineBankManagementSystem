package com.banking.modeldata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.Account;
import com.banking.modelremote.AccountRemote;
import com.banking.repository.AccountRepository;

@Service
public class AccountData implements AccountRemote
{
	@Autowired
	private AccountRepository accountRepository;
	@Override
	public String createCustomerAccount(Account account) 
	{
		String s = null;
		try
		{
			accountRepository.save(account);
			s = "Account Created Successfully";
		}
		catch(Exception e)
		{
			s = "May be Duplicated or Entered Invalid Details";
			System.out.println(e);
		}
		return s;
	}

	@Override
	public int getMaxAccountNumber() 
	{
		return accountRepository.getMaxAccountNumber();
	}

	@Override
	public List<Account> allAccounts(int custId) 
	{
		return accountRepository.allAccounts(custId);
	}

	@Override
	public boolean accountExists(long id) 
	{
		if(accountRepository.getExistingStatusOfAccount(id) > 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public double getAccountBalance(long accountNumber) 
	{
		return accountRepository.getAccountBalance(accountNumber);
	}

	@Override
	public Account getAccountById(long id) 
	{
		Account account = accountRepository.getAccountById(id);
		return account;
	}

	@Override
	public long getCountOfAccounts() 
	{
		return accountRepository.count();
	}

	@Override
	public List<Account> getAllAccounts() 
	{
		return (List<Account>) accountRepository.findAll();
	}
	
}
