package com.rtoapplication.franchise;

public interface FranchiseViewCallBack {

	void updateVehicle(String franchiseid);

	void callToSearchVehicle(String franchiseid);

	void printStatus(String msg, String franchiseid);

	void callToLoginPage();

}
