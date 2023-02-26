package com.rtoapplication.login;

import java.util.Scanner;

import com.rtoapplication.citizen.CitizenView;
import com.rtoapplication.commonInterface.UserView;
import com.rtoapplication.franchise.FranchiseView;

public class LoginView implements LoginViewCallBack{
	private Scanner scanner = new Scanner(System.in);
	private LoginControllerCallBack loginController;
	public LoginView() {
		this.loginController = new LoginController(this);
	}
	public void loginPage() {
		System.out.println("Enter your registered email id");
		String email = scanner.next();
		System.out.println("Enter your password");
		String password = scanner.next();
		loginController.validateLogin(email,password);
	}
	@Override
	public void printStatus(String msg) {
		System.out.println(msg);
		loginPage();
	}
	@Override
	public void callToCitizenPage(String userid) {
		System.out.println("Welcome "+userid);
		CitizenView citizen = new CitizenView();
		citizen.showFirstPage(this, userid);
	}
	@Override
	public void franchisePage(String franchiseid) {
		System.out.println("Welcome "+franchiseid);
		UserView franchise = new FranchiseView();
		franchise.showFirstPage(this, franchiseid);
	}
}
