package com.rtoapplication;

import com.rtoapplication.login.LoginView;

public class RTOApplication {
	public static void main(String[] args) {
		System.out.println("Welcome to RTO application");
		LoginView login = new LoginView();
		login.loginPage();
	}
}
