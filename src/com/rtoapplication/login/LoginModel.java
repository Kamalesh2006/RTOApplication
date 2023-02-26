package com.rtoapplication.login;

import com.rtoapplication.repository.Repository;

public class LoginModel implements LoginModelCallBack {
	private LoginModelControllerCallBack loginController;
	private Repository repositoryInstance = Repository.getInstance();
	public LoginModel(LoginController loginController) {
		this.loginController = loginController;
	}
	@Override
	public void checkUser(String email, String password) {
		String userid = repositoryInstance.checkUser(email,password);
		if(userid==null) {
			loginController.error("Connection failed 1");
		}
		else if(userid.equals("")) {
			loginController.userLoginFailed("Invalid credentials");
		}
		else {
			//to check if the user id is franchise login or citizen login
			String franchiseid= repositoryInstance.checkFranchise(userid);
			if(franchiseid==null) {
				loginController.error("Connection failed 2");
			}
			else if(franchiseid.equals("")) {
				//he is not a franchise login
				loginController.userLoginSuccessfull(userid);
			}
			else {
				//he is a franchise login user
				loginController.franchiseLoginSuccessfull(franchiseid);
			}
		}
	}

}
