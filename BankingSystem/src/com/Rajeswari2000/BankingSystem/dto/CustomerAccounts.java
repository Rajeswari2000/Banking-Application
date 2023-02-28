package com.Rajeswari2000.BankingSystem.dto;

import java.time.LocalDate;

public class CustomerAccounts {
	private String firstName;
	private String lastName;
	private String gender;
	private String phoneNumber;
	private String emailId;
	private Long aadharNumber;
	private LocalDate creationDate;
	private String panNumber;
	private String address;
	private String branch;
	private String IFSCcode;
	private long accountNumber;
	private long accountBalance;
	 
	
    CustomerAccounts(){
		
	}

	public String getIFSCcode() {
		return IFSCcode;
	}
	public void setIFSCcode(String iFSCcode) {
		IFSCcode = iFSCcode;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(long accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(Long aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public LocalDate getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public CustomerAccounts(String firstName, String lastName, String gender, String phoneNumber, String emailId,
			long aadharNumber, LocalDate creationDate, String panNumber, String address, String branch,String IFSCcode,long accountNumber, long accountBalance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;                                                                                                                                                                                                                                                                                                                                                                                                                                                               
		this.aadharNumber = aadharNumber;
		this.creationDate = creationDate;
		this.panNumber = panNumber;
		this.address = address;
		this.branch  =branch;
		this.IFSCcode=IFSCcode;
		this.accountNumber=accountNumber;
		this.accountBalance=accountBalance;
	}
	
	
    
    
}
