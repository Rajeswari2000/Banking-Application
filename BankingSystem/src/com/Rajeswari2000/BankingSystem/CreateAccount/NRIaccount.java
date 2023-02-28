package com.Rajeswari2000.BankingSystem.CreateAccount;

import com.Rajeswari2000.BankingSystem.dto.*;

import java.util.*;

public class NRIaccount extends AccountCreation {

	private Scanner scanner = new Scanner(System.in);

	public NRIAccountRepository subMenu() {
		CustomerAccounts commonDetails = createAccount();

		System.out.println("Enter your passport Id");
		String passportId = scanner.next();
		System.out.println("Enter your address in india");
		String addressInIndia = scanner.nextLine();

		NRIAccountRepository nriDetails = new NRIAccountRepository(commonDetails.getFirstName(),
				commonDetails.getLastName(), commonDetails.getGender(), commonDetails.getPhoneNumber(),
				commonDetails.getEmailId(), commonDetails.getAadharNumber(), commonDetails.getCreationDate(),
				commonDetails.getPanNumber(), commonDetails.getAddress(), commonDetails.getBranch(),
				commonDetails.getIFSCcode(), commonDetails.getAccountNumber(), commonDetails.getAccountBalance(),
				passportId, addressInIndia);

		return nriDetails;

	}

}
