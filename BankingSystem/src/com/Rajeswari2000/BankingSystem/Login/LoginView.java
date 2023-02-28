package com.Rajeswari2000.BankingSystem.Login;

import com.Rajeswari2000.BankingSystem.CreateAccount.*;
import com.Rajeswari2000.BankingSystem.OtherServices.*;
import com.Rajeswari2000.BankingSystem.Transaction.*;
import java.util.Scanner;

public class LoginView implements LoginViewCallBack {

	private LoginControllerCallBack loginController;
	private Scanner scanner = new Scanner(System.in);

	public LoginView() {
		loginController = new LoginController(this);
	}

	public static void main(String args[]) {
		LoginView loginView = new LoginView();
		loginView.loginOption();

	}

	public void loginOption() {

		System.out.println("\n\n------>Welcome to Pamban Bank<------");

		System.out.println("Enter 1 to login ");
		System.out.println("Enter 2 to sign up");
		System.out.println("Enter 3 to exit");

		int option = scanner.nextInt();

		switch (option) {
		case (1):
			checkLoginCredentials();
			break;

		case (2):
			signUpUser();
			break;

		case (3):
			System.exit(0);

		}

	}

	public void checkLoginCredentials() {

		int userId = 0;
		System.out.println("Enter user id(any digit between 0-9): ");
		try {
			userId = scanner.nextInt();
		} catch (Exception e) {

			System.out.println("\nInvalid input\n");
			System.out.println("Enter your details again\n");
			scanner.next();
			checkLoginCredentials();
		}

		System.out.println("Enter password: ");
		String password = scanner.next();

		loginController.checkcredentials(userId, password);

	}

	public void loginSuccesful() {
		System.out.println("\n------------ > You have logged in successfully < ---------------\n");
		menu();
	}

	public void loginFailure() {
		System.out.println("Invalid credentials");
		System.out.println("Please enter correct user id and password. ");
		System.out.println();
		loginOption();

	}

	public void signUpUser() {

		System.out.println("Enter first name: ");
		String firstName = scanner.next();
		System.out.println("Enter last name: ");
		String lastName = scanner.next();
		System.out.println("Enter email id: ");
		String emailId = scanner.next();
		System.out.println("Enter phone number: ");
		String phoneNumber = scanner.next();

		int userId = 0;
		System.out.println("Enter user id(any digit between 0-9): ");
		try {
			userId = scanner.nextInt();
		} catch (Exception e) {

			System.out.println("\nInvalid input\n");
			scanner.next();
			signUpUser();
		}

		System.out.println("Enter password: ");
		String password = scanner.next();
		System.out.println("Confirm password: ");
		String confirmPassword = scanner.next();
		if (!password.equals(confirmPassword)) {
			System.out.println("Passwords do not match. Enter your details again: ");
			System.out.println();
			signUpUser();
		}

		loginController.signUp(firstName, lastName, emailId, phoneNumber, userId, password);
	}

	public void signUpDone() {

		System.out.println("\nSign up successfully done");
		System.out.println("Please login to continue\n");

		checkLoginCredentials();
	}

	public void signUpFailed() {

		System.out.println("\nUser id already exist, please login\n");

		checkLoginCredentials();
	}

	public void menu() {
		System.out.println("Enter 1 for creating new account");
		System.out.println("Enter 2 for money transaction");
		System.out.println("Enter 3 to view other services");
		System.out.println("Enter 4 to view account details");
		System.out.println("Enter 5 to exit");

		int option = scanner.nextInt();

		switch (option) {
		case (1):
			CreateAccountView accountView = new CreateAccountView(this);
			accountView.accountMenu();
			break;

		case (2):
			TransactionView transactionView = new TransactionView(this);
			transactionView.viewMenu();
			break;

		case (3):
			OtherServicesView otherServicesView = new OtherServicesView();
			otherServicesView.printMenu();
			break;

		case (4):
			OtherServicesView otherServices = new OtherServicesView();
			otherServices.getdetails();
			break;

		case (5):
			System.out.println("------------>Thankyou<------------");
			System.exit(0);
		}

	}

}
