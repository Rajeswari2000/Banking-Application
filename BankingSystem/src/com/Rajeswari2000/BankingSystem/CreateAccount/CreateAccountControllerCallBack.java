package com.Rajeswari2000.BankingSystem.CreateAccount;

import com.Rajeswari2000.BankingSystem.dto.NRIAccountRepository;
import com.Rajeswari2000.BankingSystem.dto.SavingsAccountRepository;

public interface CreateAccountControllerCallBack {

	void savingsAccount(SavingsAccountRepository savingRepository);

	void nriAccount(NRIAccountRepository nriRepository);

}
