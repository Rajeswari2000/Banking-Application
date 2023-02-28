package com.Rajeswari2000.BankingSystem.Transaction;

public interface TransactionControllerCallBack {

	void transactMoney(Long fromACnumber, String fromIFSC, Long toAcNumber, String toIFSC, long amount, String fromType, String toType);

}
