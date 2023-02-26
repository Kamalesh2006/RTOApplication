package com.rtoapplication.searchvehicle;

import com.rtoapplication.dto.Vehicle;

public interface SearchVehicleViewCallBack {

	void printStatus(String msg,String userid);

	void printVehicleDetails(Vehicle vehicle,String userid);

	void goBackToUserView(String userid);

	void callToShowSearchView(String userid);

}
