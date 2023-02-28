package com.Rajeswari2000.BankingSystem.Transaction;

public interface TransactionModelCallBack {

	void moneyTransact(Long fromACnumber, String fromIFSC, Long toAcNumber, String toIFSC, long amount, String fromType, String toType);

}
