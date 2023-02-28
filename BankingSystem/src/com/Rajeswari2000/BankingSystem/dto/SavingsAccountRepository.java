package com.Rajeswari2000.BankingSystem.dto;

import java.time.LocalDate;

public class SavingsAccountRepository extends CustomerAccounts{
	
	private String voterId;
	 private String drivingLicense;

	 public String getVoterId() {
		return voterId;
	}
	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}
	public String getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	public SavingsAccountRepository(String firstName, String lastName, String gender, String phoneNumber,
			String emailId, long aadharNumber, LocalDate creationDate, String panNumber, String address, String branch,
			String IFSCcode, long accountNumber, long accountBalance, String voterId, String drivingLicense) {
		super(firstName, lastName, gender, phoneNumber, emailId, aadharNumber, creationDate, panNumber, address, branch,
				IFSCcode, accountNumber, accountBalance);
		this.voterId = voterId;
		this.drivingLicense = drivingLicense;
	}
	
	
	 
	 
	
	 
}
