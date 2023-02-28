package com.Rajeswari2000.BankingSystem.Login;

import com.Rajeswari2000.BankingSystem.Repository.*;
public class LoginModel implements LoginModelCallBack{

	private LoginModelControllerCallBack loginController;

	public LoginModel(LoginModelControllerCallBack loginController) {
		this.loginController = loginController;
	}

	public void checkValidUser(int userId, String password) {
		if (BankAccountsRepository.getInstance().verifyUser(userId, password)) {
			loginController.loginSuccess();
		} else {
			loginController.loginFailure();
			
		}
	}

	public void signUpDb(String firstName, String lastName, String emailId, String phoneNumber, int userId,
			String password) {
		if (BankAccountsRepository.getInstance().addUser(firstName, lastName, emailId, phoneNumber, userId,
				password)) {
			loginController.signUpSuccess();
		} else {
			loginController.signUpFailure();
		}
	}

}
