package com.rtoapplication.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController implements LoginControllerCallBack, LoginModelControllerCallBack {
	private LoginViewCallBack loginView;
	private LoginModelCallBack loginModel;
	public LoginController(LoginView loginView) {
		this.loginView = loginView;
		this.loginModel = new LoginModel(this);
	}
	@Override
	public void validateLogin(String email, String password) {
		//email should contain the format as yyyy@yyy.yyy 
		//atleast there should be one character before @ 
		//atleast one character should be present after [.]
		Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9]*@[a-zA-Z0-9]+[.][a-zA-Z]");
		Matcher m = p.matcher(email);
		if(m.find()) {
			loginModel.checkUser(email,password);
		}
		else {
			loginView.printStatus("Enter email in correct format");
		}
	}
	@Override
	public void error(String msg) {
		loginView.printStatus(msg);
	}
	@Override
	public void userLoginFailed(String msg) {
		loginView.printStatus(msg);
	}
	@Override
	public void userLoginSuccessfull(String userid) {
		loginView.callToCitizenPage(userid);
	}
	@Override
	public void franchiseLoginSuccessfull(String franchiseid) {
		loginView.franchisePage(franchiseid);
	}

}
