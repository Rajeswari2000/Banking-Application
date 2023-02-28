package com.Rajeswari2000.BankingSystem.Transaction;
import com.Rajeswari2000.BankingSystem.Login.*;
import com.Rajeswari2000.BankingSystem.OtherServices.*;
import java.util.Scanner;


public class TransactionView implements TransactionViewCallBack{

	
	private TransactionControllerCallBack transactionController;
	private Scanner scanner = new Scanner(System.in);
	private LoginView loginView;

	public TransactionView(LoginView loginView) {
		this.loginView = loginView;
		this.transactionController = new TransactionController(this);
	}
	
	
	public void viewMenu() {
		System.out.println("Enter your account number");
		Long fromACnumber = scanner.nextLong();
		System.out.println("Enter your IFSCode");
		String fromIFSC = scanner.next();
		System.out.println("Enter sender account type(savings/NRI): ");
		String fromType = scanner.next();
		System.out.println("Enter the account number of beneficiary");
		Long toAcNumber = scanner.nextLong();
		System.out.println("Enter the IFSC code of beneficiary");
		String toIFSC = scanner.next();
		System.out.println("Enter beneficiary account type(savings/NRI): ");
		String toType = scanner.next();
		
		
		System.out.println("Enter the amount to be transfered: ");
		long amount = scanner.nextLong();
		
		transactionController.transactMoney(fromACnumber,fromIFSC,toAcNumber,toIFSC,amount,fromType,toType);
		
		
	}
	
	public void transactionSuccessful() {
		System.out.println("Transcation done successfully");
		
		System.out.println("Enter 1 to view transaction history");
		System.out.println("Enter 2 to go back to main menu");
		int userOption = scanner.nextInt();
		if(userOption==1) {
			OtherServicesView otherServicesView = new OtherServicesView();
			otherServicesView.fetchCommonDetails(4);
		}
		else if(userOption==2) {
			loginView.menu();
		}
	}

	public void transactionFailure() {
	    System.out.println("\nTransaction failure. Invalid credentials. Please enter correct details.\n");
	    
	    System.out.println("Enter 1 to repeat the process");
		System.out.println("Enter 2 to go back to main menu");
		int userOption = scanner.nextInt();
		if(userOption==1) {
			viewMenu();
		}
		else if(userOption==2) {
			loginView.menu();
		}
	}
}
