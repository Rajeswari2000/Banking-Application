package com.Rajeswari2000.BankingSystem.CreateAccount;
import com.Rajeswari2000.BankingSystem.Login.*;
import com.Rajeswari2000.BankingSystem.dto.*;
import com.Rajeswari2000.BankingSystem.Login.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CreateAccountView implements CreateAccountViewCallBack {
	private LoginView loginView;
	private CreateAccountControllerCallBack createAccountController;
	private Scanner scanner = new Scanner(System.in);

	public CreateAccountView(LoginView loginView) {
		this.loginView=loginView;
		createAccountController = new CreateAccountController(this);
	}

	public void accountMenu() {
		System.out.println("Enter 1 to create savings account");
		System.out.println("Enter 2 to create NRI account");
		System.out.println("Enter 3 to go back");
		int option = scanner.nextInt();

		switch (option) {
		case (1):
			savingsAccountCreation();
			break;

		case (2):
			nriAccountCreation();
			break;

		case (3):
			loginView.menu();
		}
	}

	public void savingsAccountCreation() {
		SavingsAccount savings = new SavingsAccount();
		SavingsAccountRepository savingRepository = savings.subMenu();
		createAccountController.savingsAccount(savingRepository);
	}

	public void nriAccountCreation() {
		NRIaccount nri = new NRIaccount();
		NRIAccountRepository nriRepository = nri.subMenu();
		createAccountController.nriAccount(nriRepository);
	}

	public void savingsAdditionSuccessful() {
	     System.out.println("\n------------>Savings account created successfully<------------\n");      
	     loginView.menu();
	}

	public void savingsAccountExist() {
		System.out.println("\n---------->Account already exists<----------");
		System.out.println("-------->Please create a new account<--------\n");
		loginView.menu();
	}

	public void nriAdditionSuccess() {
		System.out.println("\n------------>NRI account created successfully<------------\n");
		loginView.menu();
	}

	public void nriAccountExist() {
		System.out.println("\n---------->Account already exists<----------");
		System.out.println("-------->Please create a new account<--------\n");
		loginView.menu();
	}

}
