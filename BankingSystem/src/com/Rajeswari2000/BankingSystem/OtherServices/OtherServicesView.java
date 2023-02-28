package com.Rajeswari2000.BankingSystem.OtherServices;

import com.Rajeswari2000.BankingSystem.Login.LoginView;
import com.Rajeswari2000.BankingSystem.dto.*;

import java.util.List;
import java.util.Scanner;

public class OtherServicesView implements OtherServicesViewCallBack {
	private OtherServicesControllerCallBack otherServicesController;
	private Scanner scanner = new Scanner(System.in);
	private LoginView loginView = new LoginView();

	public OtherServicesView() {
		this.loginView = loginView;
		otherServicesController = new OtherServicesController(this);
	}

	public void printMenu() {
		System.out.println("Enter 1 to view account balance");
		System.out.println("Enter 2 to withdraw money");
		System.out.println("Enter 3 to deposit  money");
		System.out.println("Enter 4 to view transaction history");
		System.out.println("Enter 5 to go back");

		int userOption = scanner.nextInt();

		switch (userOption) {
		case (1):
			fetchCommonDetails(1);
			break;

		case (2):
			fetchCommonDetails(2);
			break;

		case (3):
			fetchCommonDetails(3);
			break;

		case (4):
			fetchCommonDetails(4);
			break;

		case (5):
			loginView.menu();
			break;

		}
	}

	public void fetchCommonDetails(int option) {
		System.out.println("Enter your FirstName");
		String firstName = scanner.next();
		System.out.println("Enter your account number: ");
		long accountNumber = scanner.nextLong();
		System.out.println("Enter account type (savings/NRI)");
		String accountType = scanner.next();

		if (option == 1)
			viewBalance(firstName, accountNumber, accountType);
		else if (option == 2)
			withdrawMoney(firstName, accountNumber, accountType);
		else if (option == 3)
			depositMoney(firstName, accountNumber, accountType);
		else if (option == 4)
			viewTransactionHistory(firstName, accountNumber, accountType);

	}

	public void viewBalance(String firstName, long accountNumber, String accountType) {
		otherServicesController.viewAccountBalance(firstName, accountNumber, accountType);

	}

	public void withdrawMoney(String firstName, long accountNumber, String accountType) {
		System.out.println("Enter the amount to be withdrawn");
		long amount = scanner.nextLong();
		otherServicesController.withdraw(firstName, accountNumber, accountType, amount);
	}

	public void depositMoney(String firstName, long accountNumber, String accountType) {
		System.out.println("Enter the amount to be deposited");
		long amount = scanner.nextLong();
		otherServicesController.deposit(firstName, accountNumber, accountType, amount);
	}

	public void InvalidDetails() {
		System.out.println("\n----------->Invalid credentials<-----------");
		System.out.println("----------->Enter correct details<-----------\n");
		printMenu();
	}

	public void notEnoughBalance() {
		System.out.println("\n---------->Insufficient balance.Cannot withdraw money<----------\n");
		printMenu();
	}

	public void accountSummary(CustomerAccounts account) {

		System.out.println("\n------------>Process successful<-----------\n");
		System.out.println("------------>Account Summary<------------\n");

		System.out.println("First Name: " + account.getFirstName());
		System.out.println("Last Name: " + account.getLastName());
		System.out.println("Account Number: " + account.getAccountNumber());
		System.out.println("Account Balance: " + account.getAccountBalance());
		System.out.println("IFSC Code: " + account.getIFSCcode() + "\n\n");

		printMenu();
	}

	public void viewTransactionHistory(String firstName, long accountNumber, String accountType) {
		otherServicesController.checkHistory(firstName, accountNumber, accountType);
	}

	public void noPreviousTransactions() {
		System.out.println("\nNo previous transactions are found for the requested account\n");
		printMenu();

	}

	public void printTransactionHistory(List<Transaction> transaction) {
		for(Transaction t : transaction) {
			System.out.println(transaction);
			
		}
		
		printMenu();

	}

	public void getdetails() {
		System.out.println("Enter your first name");
		String firstName = scanner.next();
		System.out.println("Enter your phone number");
		String phoneNumber = scanner.next();
		otherServicesController.getAccountDetails(firstName, phoneNumber);
	}

}
