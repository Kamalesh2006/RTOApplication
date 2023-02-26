package com.rtoapplication.citizen;

import com.rtoapplication.dto.User;

public class CitizenController implements CitizenControllerCallBack, CitizenModelControllerCallBack {
	private CitizenViewCallBack citizenView;
	private CitizenModelCallBack citizenModel;
	public CitizenController(CitizenView citizenView) {
		this.citizenView = citizenView;
		this.citizenModel = new CitizenModel(this);
	}
	@Override
	public void decideOptions(int option,String userid) {
		switch(option) {
		case 1:
			//the citizen has chosen to view vehicle details
			citizenView.callToSearchVehicle(userid);
			break;
		case 2:
			//the citizen has chosen to view his own profile
			citizenModel.showProfile(userid);
			break;
		case 3:
			//the citizen has chosen to log out
			citizenView.goBackToLogin();
			break;
		}
	}
	@Override
	public void error(String msg,String userid) {
		citizenView.printStatus(msg,userid);
	}
	@Override
	public void userProfile(User user) {
		citizenView.displayProfile(user);
	}

}
