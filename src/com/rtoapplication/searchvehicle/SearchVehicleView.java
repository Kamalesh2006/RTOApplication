package com.rtoapplication.searchvehicle;

import java.util.Scanner;

import com.rtoapplication.citizen.CitizenView;
import com.rtoapplication.commonInterface.UserView;
import com.rtoapplication.dto.Vehicle;
import com.rtoapplication.login.LoginView;

public class SearchVehicleView implements SearchVehicleViewCallBack{
	private Scanner scanner = new Scanner(System.in);
	private UserView userView;
	private LoginView login;
	private SearchVehicleControllerCallBack searchVehicleController;
	public SearchVehicleView() {
		this.searchVehicleController = new SearchVehicleController(this);
	}
	public void searchVehicleNumber(UserView userView,LoginView login,String userid) {
		this.userView = userView;
		this.login = login;
		System.out.println("Enter Vehicle number to know the details (TS09EFXXXX):");
		String vehicleNo = scanner.next();
		searchVehicleController.getVehicleDetails(vehicleNo,userid);
	}
	@Override
	public void printStatus(String msg,String userid) {
		System.out.println(msg);
		System.out.println("1) To search Vehicle number again");
		System.out.println("2) To go back");
		int option = scanner.nextInt();
		searchVehicleController.decideWhereToGo(option,userid);
	}
	@Override
	public void printVehicleDetails(Vehicle vehicle,String userid) {
		System.out.println("Vehicle Number"+vehicle.getVehicleNumber()+"\t\tRegistration At:"+vehicle.getRegistrationAt());
		System.out.println("Registration Date:"+vehicle.getRegistrationDate()+"\t\tOwner name:"+vehicle.getOwnerName());
		System.out.println("Vehicle type:"+vehicle.getVehicleType()+"\t\tModal name:"+vehicle.getModalName());
		printStatus("Thanks for searching",userid);
	}
	@Override
	public void goBackToUserView(String userid) {
		this.userView.showFirstPage(login, userid);
	}
	@Override
	public void callToShowSearchView(String userid) {
		//if the user decided to search vehicle once again
		searchVehicleNumber(userView, login, userid);
	}
}
