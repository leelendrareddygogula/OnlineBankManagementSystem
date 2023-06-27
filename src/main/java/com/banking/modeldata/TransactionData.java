package com.banking.modeldata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entity.Account;
import com.banking.entity.Transaction;
import com.banking.modelremote.AccountRemote;
import com.banking.modelremote.TransactionRemote;
import com.banking.repository.AccountRepository;
import com.banking.repository.TransactionRepository;

@Service
public class TransactionData implements TransactionRemote
{
	@Autowired
	private AccountRemote accountRemote;
	@Autowired
	private TransactionRepository transactionRepository;
	@Override
	public String makeTransaction(long fromAccount, long toAccount, double balance) 
	{
		String s = "";
		if(accountRemote.accountExists(fromAccount))
		{
			if(accountRemote.accountExists(toAccount))
			{
				if((accountRemote.getAccountBalance(fromAccount) - balance) >= 0)
				{
					Transaction transaction = new Transaction();
					transaction.setTransactionAmount(balance);
					transaction.setTranscationFrom(fromAccount);
					transaction.setTransactionTo(toAccount);
					transactionRepository.save(transaction);
					Account account = accountRemote.getAccountById(fromAccount);
					Account account2 = accountRemote.getAccountById(toAccount);
					account.setBalance((accountRemote.getAccountBalance(fromAccount) - balance));
					account2.setBalance((accountRemote.getAccountBalance(toAccount) + balance));
//					accountRepository.save(account);
					accountRemote.createCustomerAccount(account);
					accountRemote.createCustomerAccount(account2);
					long maxId = transactionRepository.getMaxTransactionId();
					s = "Transaction Successful with transaction ID: " + maxId;
				}
				else
				{
					s = "Insufficient Balance to make a transaction!";
				}
			}
			else
			{
				s = "To Account Does not exist, please check the entered to account number of to transfer account and try again";
			}
		}
		else
		{
			s = "From Account Does not exist, , please check the entered to account number of to transfer account and try again";
		}
		return s;
	}
	@Override
	public List<Transaction> getAllTransactionsOfAccount(long acnum) 
	{
		List<Transaction> transactions = transactionRepository.getAllTransactionsOfAccount(acnum, acnum);
		return transactions;
	}
	
	@Override
	public long getAllTransactionsCount() 
	{
		return transactionRepository.count();
	}
	
}
