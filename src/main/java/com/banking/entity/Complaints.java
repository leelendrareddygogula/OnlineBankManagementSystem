package com.banking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Complaints 
{
	@Id
	@Column
	@GeneratedValue(generator = "compaintIDGenerator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "compaintIDGenerator", initialValue = 100, allocationSize = 1)
	private int id;
	@Column(nullable = false, length = 50)
	private String issueRelatedTo;
	@Column(nullable = false, columnDefinition = "text")
	private String subject;
	@Column(nullable = false, columnDefinition = "text")
	private String description;
	@Column(nullable = false, columnDefinition = "text")
	private String issueRaisedBy;
	@Column(nullable = false, columnDefinition = "text")
	private String mailid;
	@Column(nullable = false, length = 50)
	private String statusOfComplaint;
	@Column(nullable = false, length=10)
	private long mobileNumber;
	
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getStatusOfComplaint() {
		return statusOfComplaint;
	}
	public void setStatusOfComplaint(String statusOfComplaint) {
		this.statusOfComplaint = statusOfComplaint;
	}
	public String getIssueRaisedBy() {
		return issueRaisedBy;
	}
	public void setIssueRaisedBy(String issueRaisedBy) {
		this.issueRaisedBy = issueRaisedBy;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIssueRelatedTo() {
		return issueRelatedTo;
	}
	public void setIssueRelatedTo(String issueRelatedTo) {
		this.issueRelatedTo = issueRelatedTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
