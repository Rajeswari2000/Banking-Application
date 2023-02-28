package com.Rajeswari2000.BankingSystem.CreateAccount;

import com.Rajeswari2000.BankingSystem.dto.NRIAccountRepository;
import com.Rajeswari2000.BankingSystem.dto.SavingsAccountRepository;

public interface CreateAccountModelCallBack {

	void savingsDetails(SavingsAccountRepository savingRepository);

	void nriDetails(NRIAccountRepository nriRepository);

}
