package com.Rajeswari2000.BankingSystem.Transaction;

public class TransactionController implements TransactionControllerCallBack,TransactionModelControllerCallBack{

	private TransactionViewCallBack transactionView;
	private TransactionModelCallBack transactionModel;

	public TransactionController(TransactionViewCallBack transactionView) {
		this.transactionView = transactionView;
		this.transactionModel = new TransactionModel(this);
	}

	
	public void transactMoney(Long fromACnumber, String fromIFSC, Long toAcNumber, String toIFSC, long amount,String fromType, String toType) {
		transactionModel.moneyTransact(fromACnumber,fromIFSC,toAcNumber,toIFSC,amount,fromType,toType);		
	}


	public void transactionDone() {
		transactionView.transactionSuccessful();
	}

	public void InvalidCredentials() {
		transactionView.transactionFailure();
	}
		
	
	
	
	
	
}
