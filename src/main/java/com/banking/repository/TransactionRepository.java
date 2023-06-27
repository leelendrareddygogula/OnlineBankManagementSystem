package com.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banking.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer>
{
	@Query("select max(transactionId) from Transaction t")
	public long getMaxTransactionId();
	@Query("select t from Transaction t where t.transactionTo = ?1 or t.transcationFrom =?2")
	public List<Transaction> getAllTransactionsOfAccount(long a, long b);
}