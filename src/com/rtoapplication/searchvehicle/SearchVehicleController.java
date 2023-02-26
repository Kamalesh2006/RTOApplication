package com.rtoapplication.searchvehicle;

import com.rtoapplication.dto.Vehicle;

public class SearchVehicleController implements SearchVehicleControllerCallBack, SearchVehicleModelControllerCallBack {
	private SearchVehicleViewCallBack searchVehicleView;
	private SearchVehicleModelCallBack searchVehicleModel;
	public SearchVehicleController(SearchVehicleView searchVehicleView) {
		this.searchVehicleView = searchVehicleView;
		searchVehicleModel = new SearchVehicleModel(this);
	}
	@Override
	public void getVehicleDetails(String vehicleNo, String userid) {
		//if the user has entered lower case no 
		vehicleNo = vehicleNo.toUpperCase();
		searchVehicleModel.getVehicleDetails(vehicleNo,userid);
	}
	@Override
	public void error(String msg,String userid) {
		searchVehicleView.printStatus(msg,userid);
	}
	@Override
	public void vehicle(Vehicle vehicle,String userid) {
		searchVehicleView.printVehicleDetails(vehicle,userid);
	}
	@Override
	public void decideWhereToGo(int option, String userid) {
		switch(option) {
		case 1:
			//chose to view vehicle once again
			searchVehicleView.callToShowSearchView(userid);
			break;
		case 2:
			//chose to go back to previous page
			searchVehicleView.goBackToUserView(userid);
		}
	}

}
