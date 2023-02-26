package com.rtoapplication.searchvehicle;

import com.rtoapplication.dto.Vehicle;
import com.rtoapplication.repository.Repository;

public class SearchVehicleModel implements SearchVehicleModelCallBack {
	private SearchVehicleModelControllerCallBack searchVehicleController;
	private Repository repositoryInstance = Repository.getInstance();
	public SearchVehicleModel(SearchVehicleController searchVehicleController) {
		this.searchVehicleController  = searchVehicleController;
	}
	@Override
	public void getVehicleDetails(String vehicleNo, String userid) {
		Vehicle vehicle = repositoryInstance.getVehicle(vehicleNo);
		if(vehicle==null) {
			searchVehicleController.error("Something went wrong",userid);
		}else {
			searchVehicleController.vehicle(vehicle,userid);
		}
	}

}
