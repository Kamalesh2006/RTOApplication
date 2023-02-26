package com.rtoapplication.franchise;

import com.rtoapplication.dto.Vehicle;
import com.rtoapplication.repository.Repository;

public class FranchiseModel implements FranchiseModelCallBack {
	private FranchiseModelControllerCallBack franchiseController;
	private Repository repositoryInstance = Repository.getInstance();
	public FranchiseModel(FranchiseController franchiseController) {
		this.franchiseController = franchiseController;
	}
	@Override
	public void registerVehicle(Vehicle vehicle,String franchiseid) {
		//Checking if the vehicle registration no and the city at which the registration is handled are the same
		String city = repositoryInstance.getCity(franchiseid);
		//checking if the vehicle has already been registed 
		Vehicle checkVehicle= repositoryInstance.getVehicle(vehicle.getVehicleNumber());
		if(city==null ) {
			franchiseController.error("Something went wrong",franchiseid);
		}
		else if(checkVehicle!=null) {
			franchiseController.error("Vehicle is already registered with us",franchiseid);
		}
		else {
			//if the city of franchise and vehicle registration matches
			if(city.equalsIgnoreCase(vehicle.getRegistrationAt())) {
				boolean updated = repositoryInstance.updateVehicle(vehicle);
				if(updated) {
					franchiseController.success("Updated successfully",franchiseid);
				}
				else {
					franchiseController.error("Vehicle updation failed",franchiseid);
				}
			}
			else {
				franchiseController.error("Vehicle number is associated with different location",franchiseid);
			}
		}
	}

}
