package com.rtoapplication.franchise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rtoapplication.dto.Vehicle;

public class FranchiseController implements FranchiseControllerCallBack, FranchiseModelControllerCallBack {
	private FranchiseViewCallBack franchiseView;
	private FranchiseModelCallBack franchiseModel;
	public FranchiseController(FranchiseView franchiseView) {
		this.franchiseView = franchiseView;
		this.franchiseModel = new FranchiseModel(this);
	}
	@Override
	public void decideOption(int option, String franchiseid) {
		switch(option) {
		case 1:
			//to update vehicle details 
			franchiseView.updateVehicle(franchiseid);
			break;
		case 2:
			franchiseView.callToSearchVehicle(franchiseid);
			break;
		case 3:
			franchiseView.callToLoginPage();
			break;
		}
	}
	@Override
	public void registerVehicle(String vehicleno, String registrationat, String vehicleRegistrationDate,
			String ownername, String vehicletype,String vehicleModalname,String franchiseid) {
		//checking the format of vehicle no TX09FF0XXX
		vehicleno = vehicleno.toUpperCase();
		Pattern p = Pattern.compile("[A-Z][A-Z][0-9][0-9][A-Z][A-Z][0-9][0-9][0-9][0-9]");
		Matcher m = p.matcher(vehicleno);
		if(m.find()) {
			franchiseModel.registerVehicle(new Vehicle(vehicleno,registrationat,vehicleRegistrationDate,ownername,vehicletype,vehicleModalname),franchiseid);	
		}else {
			franchiseView.printStatus("Enter the vehicle no in correct format [TX03FF0XXX",franchiseid);
		}
		
	}
	@Override
	public void error(String msg,String franchiseid) {
		franchiseView.printStatus(msg,franchiseid);
	}
	@Override
	public void success(String msg,String franchiseid) {
		franchiseView.printStatus(msg,franchiseid);
	}

}
