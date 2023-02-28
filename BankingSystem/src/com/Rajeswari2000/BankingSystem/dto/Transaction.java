package com.Rajeswari2000.BankingSystem.dto;

import java.time.LocalDate;

public class Transaction {
   public Transaction(Long fromACnumber, String fromIFSCcode, Long toAcNumber, String toIFSCcode,
			long amount, String fromType, String toType,LocalDate transactionDate) {
		super();
		this.fromAccountNumber = fromACnumber;
		this.fromIFSCcode = fromIFSCcode;
		this.toAccountNumber = toAcNumber;
		this.toIFSCcode = toIFSCcode;
		this.amount = amount;
		this.fromType = fromType;
		this.toType = toType;
		this.transactionDate=transactionDate;
	}
   private Long fromAccountNumber;
   private String fromIFSCcode;
   private Long toAccountNumber;
   private String toIFSCcode;
   private long amount;
   private String fromType;
   private String toType;
   private LocalDate transactionDate = LocalDate.now();
   
   public LocalDate getTransactionDate() {
	return transactionDate;
   }
public void setTransactionDate(LocalDate transactionDate) {
	this.transactionDate = transactionDate;
}
 public Long getFromAccountNumber() {
	return fromAccountNumber;
}
public void setFromAccountNumber(Long fromAccountNumber) {
	this.fromAccountNumber = fromAccountNumber;
}
public String getFromIFSCcode() {
	return fromIFSCcode;
}
public void setFromIFSCcode(String fromIFSCcode) {
	this.fromIFSCcode = fromIFSCcode;
}
public Long getToAccountNumber() {
	return toAccountNumber;
}
public void setToAccountNumber(Long toAccountNumber) {
	this.toAccountNumber = toAccountNumber;
}
public String getToIFSCcode() {
	return toIFSCcode;
}
public void setToIFSCcode(String toIFSCcode) {
	this.toIFSCcode = toIFSCcode;
}
public long getAmount() {
	return amount;
}
public void setAmount(long amount) {
	this.amount = amount;
}
public String getFromType() {
	return fromType;
}
public void setFromType(String fromType) {
	this.fromType = fromType;
}
public String getToType() {
	return toType;
}
public void setToType(String toType) {
	this.toType = toType;
}
@Override
public String toString() {
	return "------------>Transaction History<-----------\nAccount Number of sender: " + fromAccountNumber + "\n IFSC code of sender: " + fromIFSCcode
			+ "\n Account Number of beneficiary: " + toAccountNumber + "\n IFSC code of beneficiary: " + toIFSCcode + "\n Amount transfered: " + amount
			+ "\n transaction date: " + transactionDate ;
}


}
