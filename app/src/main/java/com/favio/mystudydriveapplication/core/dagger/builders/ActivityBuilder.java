package com.favio.mystudydriveapplication.core.dagger.builders;

import com.favio.mystudydriveapplication.core.dagger.modules.StudydriveAppModule;
import com.favio.mystudydriveapplication.core.splash.SplashScreenActivity;
import com.favio.mystudydriveapplication.core.splash.SplashScreenActivityModule;
import com.favio.mystudydriveapplication.studydrive.screens.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = SplashScreenActivityModule.class)
    abstract SplashScreenActivity contributeSplashScreenActivity();

    @ContributesAndroidInjector(modules = {
            StudydriveAppModule.class})
    abstract MainActivity contributeMainActivity();
}
