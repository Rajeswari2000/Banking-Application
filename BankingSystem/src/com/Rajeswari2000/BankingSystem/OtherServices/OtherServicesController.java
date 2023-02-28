package com.Rajeswari2000.BankingSystem.OtherServices;

import java.util.List;

import com.Rajeswari2000.BankingSystem.dto.CustomerAccounts;
import com.Rajeswari2000.BankingSystem.dto.Transaction;

public class OtherServicesController implements OtherServicesControllerCallBack, OtherServicesModelControllerCallBack {

	private OtherServicesViewCallBack otherServicesView;
	private OtherServicesModelCallBack otherServicesModel;

	public OtherServicesController(OtherServicesViewCallBack otherServicesView) {
		this.otherServicesView = otherServicesView;
		this.otherServicesModel = new OtherServicesModel(this);
	}

	public void viewAccountBalance(String firstName, long accountNumber, String accountType) {
		CustomerAccounts balance = otherServicesModel.viewBalance(firstName, accountNumber, accountType);
		if (balance != null)
			otherServicesView.accountSummary(balance);
		else
			otherServicesView.InvalidDetails();

	}

	public void withdraw(String firstName, long accountNumber, String accountType, long amount) {
		CustomerAccounts withdrawal = otherServicesModel.withrawMoney(firstName, accountNumber, accountType, amount);
		if (withdrawal != null)
			otherServicesView.accountSummary(withdrawal);
		else
			otherServicesView.InvalidDetails();

	}

	public void deposit(String firstName, long accountNumber, String accountType, long amount) {
		CustomerAccounts deposit = otherServicesModel.depositMoney(firstName, accountNumber, accountType, amount);
		if (deposit != null)
			otherServicesView.accountSummary(deposit);
		else
			otherServicesView.InvalidDetails();
	}

	public void lackOfBalance() {
		otherServicesView.notEnoughBalance();

	}

	public List<Transaction> checkHistory(String firstName, long accountNumber, String accountType) {

		List<Transaction> transaction = otherServicesModel.checkTransaction(firstName, accountNumber, accountType);
		if (transaction.isEmpty())
			otherServicesView.noPreviousTransactions();
		else
			otherServicesView.printTransactionHistory(transaction);
		return transaction;

	}

	public CustomerAccounts getAccountDetails(String firstName, String phoneNumber) {
		CustomerAccounts accountDetails = otherServicesModel.getAccount(firstName, phoneNumber);
		if (accountDetails != null)
			otherServicesView.accountSummary(accountDetails);
		else
			otherServicesView.InvalidDetails();
		return null;
	}

}
