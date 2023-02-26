package com.rtoapplication.login;

public interface LoginModelControllerCallBack {

	void error(String msg);

	void userLoginFailed(String msg);

	void userLoginSuccessfull(String userid);

	void franchiseLoginSuccessfull(String franchiseid);

}
