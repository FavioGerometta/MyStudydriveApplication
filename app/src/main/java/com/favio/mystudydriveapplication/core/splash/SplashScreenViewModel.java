package com.favio.mystudydriveapplication.core.splash;

import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

public class SplashScreenViewModel extends ViewModel {

    @Inject
    public SplashScreenViewModel() { }
    //not using login nor launch now
    public boolean isFirstTimeLaunch() {
        return true;//isFirstTimeLaunch();
    }

    public boolean isLoggedIn() {
        return true;//isLoggedIn();
    }
}

