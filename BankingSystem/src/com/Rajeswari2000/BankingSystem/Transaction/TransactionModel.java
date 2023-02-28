package com.Rajeswari2000.BankingSystem.Transaction;

import com.Rajeswari2000.BankingSystem.Repository.BankAccountsRepository;

public class TransactionModel implements TransactionModelCallBack{
	
	private TransactionModelControllerCallBack transactionController;

	public TransactionModel(TransactionModelControllerCallBack transactionController) {
		this.transactionController = transactionController;
	}

	
	public void moneyTransact(Long fromACnumber, String fromIFSC, Long toAcNumber, String toIFSC, long amount,String fromType, String toType) {
		if(BankAccountsRepository.getInstance().moneyTransfer(fromACnumber, fromIFSC, toAcNumber, toIFSC, amount,fromType,toType)) {
			transactionController.transactionDone();
		}
		else {
			transactionController.InvalidCredentials();
		}
	}

}
