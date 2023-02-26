package com.rtoapplication.franchise;

import java.time.LocalDate;
import java.util.Scanner;

import com.rtoapplication.commonInterface.UserView;
import com.rtoapplication.login.LoginView;
import com.rtoapplication.searchvehicle.SearchVehicleView;

public class FranchiseView implements FranchiseViewCallBack,UserView{
	private FranchiseControllerCallBack franchiseController;
	private LoginView login;
	private Scanner scanner = new Scanner(System.in);
	public FranchiseView() {
		this.franchiseController = new FranchiseController(this);
	}
	
	//this is the first page after franchise user logged in
	public void showFirstPage(LoginView login, String franchiseid) {
		this.login = login;
		System.out.println("1) To update Vehicle details");
		System.out.println("2) To view vehicle details");
		System.out.println("3) To log out");
		int option = scanner.nextInt();
		franchiseController.decideOption(option,franchiseid);
	}

	@Override
	public void updateVehicle(String franchiseid) {
		System.out.println("Enter the Vehicle number:");
		String vehicleno = scanner.next();
		System.out.println("Enter the Registration At:");
		String registrationat = scanner.next();
		//registration date has to be the same date when the admin entered the vehicle details
		String vehicleRegistrationDate =LocalDate.now().toString();
		System.out.println("Enter the Owner name:");
		String ownername = scanner.next();
		scanner.nextLine();
		System.out.println("Enter the Vehicle type:");
		String vehicletype = scanner.nextLine();
		System.out.println("Enter the vehicle modal name");
		String vehicleModal = scanner.nextLine();
		franchiseController.registerVehicle(vehicleno,registrationat,vehicleRegistrationDate,ownername,vehicletype,vehicleModal,franchiseid);
	}

	@Override
	public void callToSearchVehicle(String franchiseid) {
		//calling search vehicle module
		SearchVehicleView search = new SearchVehicleView();
		search.searchVehicleNumber(this,login, franchiseid);
	}

	@Override
	public void printStatus(String msg, String franchiseid) {
		System.out.println(msg);
		showFirstPage(login, franchiseid);
	}

	@Override
	public void callToLoginPage() {
		System.out.println("Successfully logged out");
		login.loginPage();
	}
}
