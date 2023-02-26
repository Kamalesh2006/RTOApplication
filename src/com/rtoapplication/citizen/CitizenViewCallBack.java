package com.rtoapplication.citizen;

import com.rtoapplication.dto.User;

public interface CitizenViewCallBack {

	void callToSearchVehicle(String userid);

	void goBackToLogin();

	void printStatus(String msg,String userid);

	void displayProfile(User user);

}
