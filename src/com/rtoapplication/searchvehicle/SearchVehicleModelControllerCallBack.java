package com.rtoapplication.searchvehicle;

import com.rtoapplication.dto.Vehicle;

public interface SearchVehicleModelControllerCallBack {

	void error(String msg, String userid);

	void vehicle(Vehicle vehicle,String userid);

}
