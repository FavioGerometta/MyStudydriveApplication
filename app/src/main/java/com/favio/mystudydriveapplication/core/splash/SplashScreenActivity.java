package com.favio.mystudydriveapplication.core.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.favio.mystudydriveapplication.core.base.BaseActivity;
import com.favio.mystudydriveapplication.studydrive.screens.main.MainActivity;

import javax.inject.Inject;


public class SplashScreenActivity extends BaseActivity<SplashScreenViewModel> {

    private final static long duration=1000L;

    SplashScreenViewModel viewModel;
    @Inject
    ViewModelProvider.Factory factory;

    @Override
    public SplashScreenViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, factory).get(SplashScreenViewModel.class);
        return viewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Checking for first time launch
        if (!viewModel.isFirstTimeLaunch()) {
            if (viewModel.isLoggedIn()) {
                scheduleSplashScreen(MainActivity.class);
                //finish();
            } else {
                scheduleSplashScreen(MainActivity.class);
                //LAUNCH LOGIN
                //finish();
            }
        } else {
            scheduleSplashScreen(MainActivity.class);
            //startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
            //LAUNCH ONBOARDING SCREENS
            //finish();
        }

    }

    private void scheduleSplashScreen(Class<?> cls) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, cls));
                finish();
            }
        }, duration * 2);
    }

}
