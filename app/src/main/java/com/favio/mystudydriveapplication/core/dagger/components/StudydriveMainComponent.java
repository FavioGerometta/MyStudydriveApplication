package com.favio.mystudydriveapplication.core.dagger.components;

import com.favio.mystudydriveapplication.StudydriveMainApplication;
import com.favio.mystudydriveapplication.core.dagger.builders.ActivityBuilder;
import com.favio.mystudydriveapplication.core.dagger.modules.StudydriveAppModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        //NetworkModule.class, no network required on this project
        StudydriveAppModule.class,
        ActivityBuilder.class})
public interface StudydriveMainComponent extends AndroidInjector<StudydriveMainApplication> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<StudydriveMainApplication>{}

}
