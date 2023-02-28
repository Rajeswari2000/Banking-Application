package com.Rajeswari2000.BankingSystem.dto;

import java.time.LocalDate;

public class NRIAccountRepository extends CustomerAccounts{

	
	private String passportId;
	private String addressInIndia;

	public String getPassportId() {
		return passportId;
	}
	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}
	public String getAddressInIndia() {
		return addressInIndia;
	}
	public void setAddressInIndia(String addressInIndia) {
		this.addressInIndia = addressInIndia;
	}
	public NRIAccountRepository(String firstName, String lastName, String gender, String phoneNumber, String emailId,
			long aadharNumber, LocalDate creationDate, String panNumber, String address, String branch, String IFSCcode,
			long accountNumber, long accountBalance, String passportId, String addressInIndia) {
		super(firstName, lastName, gender, phoneNumber, emailId, aadharNumber, creationDate, panNumber, address, branch,
				IFSCcode, accountNumber, accountBalance);
		this.passportId = passportId;
		this.addressInIndia = addressInIndia;
	}

	
	
	
	
	
}
