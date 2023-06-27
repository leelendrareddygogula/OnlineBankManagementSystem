package com.banking.modelremote;

import java.util.List;

import com.banking.entity.Transaction;

public interface TransactionRemote 
{	
	public String makeTransaction(long fromAccount, long toAccount, double balance);
	public List<Transaction> getAllTransactionsOfAccount(long acnum);
	public long getAllTransactionsCount();
}
