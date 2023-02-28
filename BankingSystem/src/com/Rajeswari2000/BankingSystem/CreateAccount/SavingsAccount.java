package com.Rajeswari2000.BankingSystem.CreateAccount;

import com.Rajeswari2000.BankingSystem.dto.*;
import java.util.*;

import com.Rajeswari2000.BankingSystem.dto.CustomerAccounts;

public class SavingsAccount extends AccountCreation {

	private Scanner scanner = new Scanner(System.in);

	public SavingsAccountRepository subMenu() {

		CustomerAccounts commonDetailsSavings = createAccount();

		System.out.println("Enter you voter Id");
		String voterId = scanner.next();
		System.out.println("Enter your driving license number");
		String drivingLicense = scanner.next();

		SavingsAccountRepository savingsDetails = new SavingsAccountRepository(commonDetailsSavings.getFirstName(),
				commonDetailsSavings.getLastName(), commonDetailsSavings.getGender(),
				commonDetailsSavings.getPhoneNumber(), commonDetailsSavings.getEmailId(),
				commonDetailsSavings.getAadharNumber(), commonDetailsSavings.getCreationDate(),
				commonDetailsSavings.getPanNumber(), commonDetailsSavings.getAddress(),
				commonDetailsSavings.getBranch(), commonDetailsSavings.getIFSCcode(),
				commonDetailsSavings.getAccountNumber(), commonDetailsSavings.getAccountBalance(), voterId,
				drivingLicense);

		return savingsDetails;

	}

}
