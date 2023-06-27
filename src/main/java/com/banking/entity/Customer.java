package com.banking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customer_details")
public class Customer 
{
	@Id
	@GeneratedValue(generator = "customer_id_generator", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "customer_id_generator", initialValue = 10000, allocationSize = 1)
	private int customerId;
	@Column(length = 100, nullable = false)
	private String name;
	@Column(length = 100, nullable = false)
	private String city;
	@Column(length = 100, nullable = false)
	private String doorNo;
	@Column(length = 100, nullable = false)
	private String landmark;
	@Column(length = 100, nullable = false)
	private String pincode;
	@Column(length = 12, nullable = false, unique = true)
	private String aadharNumber;
	@Column(length = 100, nullable = false, unique = true)
	private String panCardNumber;
	@Column(nullable = false, length = 10, unique = true)
	private String contactNumber;
	@Column(nullable = false, length = 20)
	private String password;
	@Column(nullable = false, length = 10)
	private String gender;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", city=" + city + ", doorNo=" + doorNo
				+ ", landmark=" + landmark + ", pincode=" + pincode + ", aadharNumber=" + aadharNumber
				+ ", panCardNumber=" + panCardNumber + ", contactNumber=" + contactNumber + ", password=" + password
				+ ", gender=" + gender + "]";
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDoorNo() {
		return doorNo;
	}
	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getPanCardNumber() {
		return panCardNumber;
	}
	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
}
