package com.Rajeswari2000.BankingSystem.Login;

public interface LoginControllerCallBack {

	void checkcredentials(int userId, String password);

	void signUp(String firstName, String lastName, String emailId, String phoneNumber, int userId, String password);

}
