package com.Rajeswari2000.BankingSystem.OtherServices;

import java.util.List;

import com.Rajeswari2000.BankingSystem.dto.CustomerAccounts;
import com.Rajeswari2000.BankingSystem.dto.Transaction;

public interface OtherServicesModelCallBack {

	CustomerAccounts viewBalance(String firstName, long accountNumber, String accountType);

	CustomerAccounts withrawMoney(String firstName, long accountNumber, String accountType,long amount);

	CustomerAccounts depositMoney(String firstName, long accountNumber, String accountType,long amount);

	List<Transaction> checkTransaction(String firstName, long accountNumber, String accountType);

	CustomerAccounts getAccount(String firstName, String phoneNumber);


	

	
}
