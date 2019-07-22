package com.favio.mystudydriveapplication.core.dagger.modules;

import android.content.Context;

import com.favio.mystudydriveapplication.StudydriveMainApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StudydriveAppModule {

    @Singleton
    @Provides
    Context provideContext(StudydriveMainApplication application){
        return application;
    }


}
