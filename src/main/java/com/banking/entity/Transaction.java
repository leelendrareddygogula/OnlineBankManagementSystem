package com.banking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_details")
public class Transaction 
{
	@Id
	@GeneratedValue(generator = "transaction_id_generator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "transaction_id_generator", allocationSize = 1, initialValue = 100)
	private long transactionId;
	@Column(precision = 10, scale = 4, nullable = false)
	private double transactionAmount;
	@Column(nullable = false)
	private long transcationFrom;
	@Column(nullable = false)
	private long transactionTo;
	
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionAmount=" + transactionAmount
				+ ", transcationFrom=" + transcationFrom + ", transactionTo=" + transactionTo + "]";
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public long getTranscationFrom() {
		return transcationFrom;
	}
	public void setTranscationFrom(long transcationFrom) {
		this.transcationFrom = transcationFrom;
	}
	public long getTransactionTo() {
		return transactionTo;
	}
	public void setTransactionTo(long transactionTo) {
		this.transactionTo = transactionTo;
	}
	
	
}
