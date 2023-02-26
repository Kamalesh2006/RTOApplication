package com.rtoapplication.commonInterface;

import com.rtoapplication.login.LoginView;

public interface UserView{
	//this interface is implemented by citizenview and franchise view
	//so that the search vehicle module can decide where to go back based on the runtime object present
	void showFirstPage(LoginView login,String userid);
}