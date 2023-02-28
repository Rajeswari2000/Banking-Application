package com.Rajeswari2000.BankingSystem.CreateAccount;

import com.Rajeswari2000.BankingSystem.dto.CustomerAccounts;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AccountCreation {
     
	private Scanner scanner = new Scanner(System.in);

	public CustomerAccounts createAccount() {

		System.out.println("Enter your first name: ");
		String firstName = scanner.next();
		System.out.println("Enter your last name: ");
		String lastName = scanner.next();
		System.out.println("Enter your gender(M/F): ");
		String gender = scanner.next();

		String phoneNumber = setPhNumber();

		String emailId = setEmail();

		Long aadharNumber = setAadhar();

		LocalDate creationDate = LocalDate.now();

		System.out.println("Enter your pan number: ");
		String panNumber = scanner.next();

		System.out.println("Enter your branch: ");
		String branch = scanner.next();

		System.out.println("Enter amount to be deposited");
		long accountBalance = scanner.nextLong();

		System.out.println("Enter your address: ");
		String address = scanner.next();
		
		

		Long accountNumber =(long)(999999999+Math.random()*999999999);
		
		

		String IFSCcode = "PAM" + branch.toUpperCase().substring(0, 3) + "10180";

		CustomerAccounts accounts = new CustomerAccounts(firstName, lastName, gender, phoneNumber, emailId,
				aadharNumber, creationDate, panNumber, address, branch, IFSCcode, accountNumber, accountBalance);

		return accounts;
	}

	public abstract CustomerAccounts subMenu();

	public String setPhNumber() {
		System.out.println("Enter your phone number: ");
		String phNumber = scanner.next();

		Pattern pattern = Pattern.compile("[7-9][0-9]{9}");
		Matcher match = pattern.matcher(phNumber);
		if (match.find() && phNumber.length() == 10) {
			return phNumber;
		} else {
			System.out.println("Invalid phone number");
			setPhNumber();
		}

		return "";
	}

	public String setEmail() {
		System.out.println("Enter your email id");
		String mailId = scanner.next();

		Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9]*@[a-zA-Z0-9]+[.][c][o][m]");
		Matcher m = p.matcher(mailId);
		if (!(m.find())) {
			System.out.println("Invalid email id.");
			setEmail();
		} else
			return mailId;

		return "";
	}

	public long setAadhar() {
		System.out.println("Enter Aadhar number: ");
		long aadhar = scanner.nextLong();

		Pattern pat = Pattern.compile("[2-9][0-9]{11}");
		String check = String.valueOf(aadhar);
		Matcher mat = pat.matcher(check);
		if (mat.find()) {
			return aadhar;
		} else {
			System.out.println("Invalid Aadhar number");
			setAadhar();
			
		}
		return 0;
	}

}
