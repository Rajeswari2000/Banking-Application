package com.Rajeswari2000.BankingSystem.Login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController implements LoginControllerCallBack, LoginModelControllerCallBack {

	private LoginViewCallBack loginView;
	private LoginModelCallBack loginModel;

	public LoginController(LoginViewCallBack loginView) {
		this.loginView = loginView;
		this.loginModel = new LoginModel(this);
	}

	public void checkcredentials(int userId, String password) {
		loginModel.checkValidUser(userId, password);
	}

	public void loginSuccess() {
		loginView.loginSuccesful();
	}

	public void loginFailure() {
		loginView.loginFailure();
	}

	public void signUp(String firstName, String lastName, String emailId, String phoneNumber, int userId,
			String password) {

		boolean number;
		boolean email;

		Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9]*@[a-zA-Z0-9]+[.][c][o][m]");
		Matcher m = p.matcher(emailId);
		if (!(m.find())) {
			System.out.println("Invalid email id");
			email = false;
		} else
			email = true;

		Pattern pattern = Pattern.compile("[7-9][0-9]{9}");
		Matcher match = pattern.matcher(phoneNumber);
		if (match.find() && phoneNumber.length() == 10) {
			number = true;
		} else {
			System.out.println("Invalid phone number");
			number = false;
		}

		if (email && number)
			loginModel.signUpDb(firstName, lastName, emailId, phoneNumber, userId, password);
		else {
			System.out.println("Please enter your details again\n");
			loginView.signUpUser();
		}
	}

	public void signUpSuccess() {
		loginView.signUpDone();
	}

	public void signUpFailure() {
		loginView.signUpFailed();
	}

}
