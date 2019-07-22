package com.favio.mystudydriveapplication;


import com.favio.mystudydriveapplication.core.dagger.components.DaggerStudydriveMainComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class StudydriveMainApplication extends DaggerApplication {

    private static StudydriveMainApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static synchronized StudydriveMainApplication getInstance() {
        return instance;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerStudydriveMainComponent.builder().create(this);

    }


}