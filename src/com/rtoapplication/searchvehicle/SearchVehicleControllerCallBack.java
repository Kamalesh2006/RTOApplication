package com.rtoapplication.searchvehicle;

public interface SearchVehicleControllerCallBack {

	void getVehicleDetails(String vehicleNo, String userid);

	void decideWhereToGo(int option, String userid);

}
