package com.Rajeswari2000.BankingSystem.OtherServices;

import java.util.List;

import com.Rajeswari2000.BankingSystem.dto.CustomerAccounts;
import com.Rajeswari2000.BankingSystem.dto.Transaction;

public interface OtherServicesViewCallBack {

	void InvalidDetails();

	void notEnoughBalance();

	void accountSummary(CustomerAccounts account);

	void noPreviousTransactions();

	void printTransactionHistory(List<Transaction> transaction);


}
