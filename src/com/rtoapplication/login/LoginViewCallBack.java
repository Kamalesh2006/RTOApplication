package com.rtoapplication.login;

public interface LoginViewCallBack {

	void printStatus(String msg);

	void callToCitizenPage(String userid);

	void franchisePage(String franchiseid);

}
