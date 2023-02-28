package com.Rajeswari2000.BankingSystem.Login;

public interface LoginModelCallBack {

	void checkValidUser(int userId, String password);

	void signUpDb(String firstName, String lastName, String emailId, String phoneNumber, int userId, String password);

}
