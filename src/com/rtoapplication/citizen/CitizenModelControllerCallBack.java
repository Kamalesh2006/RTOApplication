package com.rtoapplication.citizen;

import com.rtoapplication.dto.User;

public interface CitizenModelControllerCallBack {

	void error(String msg,String userid);

	void userProfile(User user);

}
