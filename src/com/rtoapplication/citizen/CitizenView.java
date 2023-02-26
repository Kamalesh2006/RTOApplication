package com.rtoapplication.citizen;

import java.util.Scanner;

import com.rtoapplication.commonInterface.UserView;
import com.rtoapplication.dto.User;
import com.rtoapplication.login.LoginView;
import com.rtoapplication.searchvehicle.SearchVehicleView;

public class CitizenView implements CitizenViewCallBack,UserView{
	private Scanner scanner = new Scanner(System.in);
	private LoginView login;
	private CitizenControllerCallBack citizenController;
	public CitizenView() {
		this.citizenController = new CitizenController(this);
	}
	//this is the first page after the citizen login in the login page
	public void showFirstPage(LoginView login,String userid) {
		this.login = login;
		System.out.println("Choose 1 to view vehicle details");
		System.out.println("Choose 2 to view your own profile");
		System.out.println("Choose 3 to log out");
		int option = scanner.nextInt();
		citizenController.decideOptions(option,userid);
	}
	@Override
	public void callToSearchVehicle(String userid) {
		//calling search vehicle module from here
		SearchVehicleView search = new SearchVehicleView();
		search.searchVehicleNumber(this,login, userid);
	}
	@Override
	public void goBackToLogin() {
		//logging out of the application
		System.out.println("Successfully logged out");
		login.loginPage();
	}
	@Override
	public void printStatus(String msg,String userid) {
		System.out.println(msg);
		showFirstPage(login,userid);
	}
	@Override
	public void displayProfile(User user) {
		System.out.println("User ID:"+user.getUserid()+"\t\tUser name:"+user.getName());
		System.out.println("Email:"+user.getEmail()+"\t\tDate of birth"+user.getDob());
		System.out.println("Phone no:"+user.getPhoneno());
		showFirstPage(login, user.getUserid());
	}
}
