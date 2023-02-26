package com.rtoapplication.citizen;

import com.rtoapplication.dto.User;
import com.rtoapplication.repository.Repository;

public class CitizenModel implements CitizenModelCallBack {
	private CitizenModelControllerCallBack citizenController;
	private Repository repositoryInstance = Repository.getInstance();
	public CitizenModel(CitizenController citizenController) {
		this.citizenController = citizenController;
	}
	@Override
	public void showProfile(String userid) {
		User user = repositoryInstance.getUser(userid);
		if(user==null) {
			//user is null if exception got raised in the repository or user details doesn't in the database
			citizenController.error("Something went wrong",userid);
		}else {
			citizenController.userProfile(user);
		}
	}

}
