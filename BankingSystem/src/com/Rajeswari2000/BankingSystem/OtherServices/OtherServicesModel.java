package com.Rajeswari2000.BankingSystem.OtherServices;

import java.util.List;

import com.Rajeswari2000.BankingSystem.Repository.BankAccountsRepository;
import com.Rajeswari2000.BankingSystem.dto.CustomerAccounts;
import com.Rajeswari2000.BankingSystem.dto.Transaction;

public class OtherServicesModel implements OtherServicesModelCallBack {

	private OtherServicesModelControllerCallBack otherServicesController;
	// public OtherServicesModel(){}

	public OtherServicesModel(OtherServicesModelControllerCallBack otherServicesController) {
		this.otherServicesController = otherServicesController;
	}

	public CustomerAccounts viewBalance(String firstName, long accountNumber, String accountType) {

		return BankAccountsRepository.getInstance().viewAccountBalance(firstName, accountNumber, accountType);
	}

	public CustomerAccounts withrawMoney(String firstName, long accountNumber, String accountType, long amount) {

		return BankAccountsRepository.getInstance().withdrawAccountMoney(firstName, accountNumber, accountType, amount);
	}

	public CustomerAccounts depositMoney(String firstName, long accountNumber, String accountType, long amount) {

		return BankAccountsRepository.getInstance().depositAccountMoney(firstName, accountNumber, accountType, amount);
	}

	public void InsufficientBalance() {
		otherServicesController.lackOfBalance();
	}

	public List<Transaction> checkTransaction(String firstName, long accountNumber, String accountType) {
		return BankAccountsRepository.getInstance().getTranscationHistory(firstName, accountNumber, accountType);

	}

	public CustomerAccounts getAccount(String firstName, String phoneNumber) {
		return BankAccountsRepository.getInstance().getAccountDetails(firstName, phoneNumber);

	}

}
