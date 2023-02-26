package com.rtoapplication.franchise;

public interface FranchiseControllerCallBack {

	void decideOption(int option, String franchiseid);

	void registerVehicle(String vehicleno, String registrationat, String vehicleRegistrationDate, String ownername,
			String vehicletype, String vehicleModalname, String franchiseid);

}
