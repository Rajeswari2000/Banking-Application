package com.Rajeswari2000.BankingSystem.CreateAccount;

import com.Rajeswari2000.BankingSystem.Repository.BankAccountsRepository;
import com.Rajeswari2000.BankingSystem.dto.NRIAccountRepository;
import com.Rajeswari2000.BankingSystem.dto.SavingsAccountRepository;

public class CreateAccountModel implements CreateAccountModelCallBack{
	
	private CreateAccountModelControllerCallBack createAccountController;

	public CreateAccountModel(CreateAccountModelControllerCallBack createAccountController) {
		this.createAccountController = createAccountController;
	}
	
	
	public void savingsDetails(SavingsAccountRepository savingRepository) {
		if(BankAccountsRepository.getInstance().createNewSavingsAccount(savingRepository)) {
			createAccountController.savingsAccountAdded(true);
		}
		else createAccountController.savingsAccountAdded(false);
			
		
	}
	
	public void nriDetails(NRIAccountRepository nriRepository) {
		if(BankAccountsRepository.getInstance().createNewNRIAccount(nriRepository)) {
			createAccountController.nriAccountAddition(true);
		}
		else createAccountController.nriAccountAddition(false);
	}

}
