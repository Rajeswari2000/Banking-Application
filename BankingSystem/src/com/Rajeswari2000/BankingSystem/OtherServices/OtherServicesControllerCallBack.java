package com.Rajeswari2000.BankingSystem.OtherServices;
import com.Rajeswari2000.BankingSystem.dto.*;
import java.util.List;

import com.Rajeswari2000.BankingSystem.dto.Transaction;

public interface OtherServicesControllerCallBack {

	void viewAccountBalance(String firstName, long accountNumber, String accountType);

	void withdraw(String firstName, long accountNumber, String accountType,long amount);

	void deposit(String firstName, long accountNumber, String accountType,long amount);

	List<Transaction> checkHistory(String firstName, long accountNumber, String accountType);

	CustomerAccounts getAccountDetails(String firstName, String phoneNumber);


}
