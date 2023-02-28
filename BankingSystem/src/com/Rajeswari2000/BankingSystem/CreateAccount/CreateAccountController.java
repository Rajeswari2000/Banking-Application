package com.Rajeswari2000.BankingSystem.CreateAccount;

import java.time.LocalDate;

import com.Rajeswari2000.BankingSystem.dto.NRIAccountRepository;
import com.Rajeswari2000.BankingSystem.dto.SavingsAccountRepository;

public class CreateAccountController implements  CreateAccountControllerCallBack, CreateAccountModelControllerCallBack{

	
	private CreateAccountViewCallBack createAccountView;
	private CreateAccountModelCallBack createAccountModel;

	public CreateAccountController(CreateAccountViewCallBack createAccountView) {
		this.createAccountView = createAccountView;
		this.createAccountModel = new CreateAccountModel(this);
	}
	
	public void savingsAccount(SavingsAccountRepository savingRepository) {
		createAccountModel.savingsDetails(savingRepository);
	}
	
	public void nriAccount(NRIAccountRepository nriRepository) {
		createAccountModel.nriDetails(nriRepository);
	}
	
	public void savingsAccountAdded(boolean flag) {
		if(flag)createAccountView.savingsAdditionSuccessful();
		else createAccountView.savingsAccountExist();
	}
	
	public void nriAccountAddition(boolean flag) {
		if(flag)createAccountView.nriAdditionSuccess();
		else createAccountView.nriAccountExist();
	}
	
	
}
