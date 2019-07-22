package com.favio.mystudydriveapplication.studydrive.screens.main;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    @Provides
    MainViewModel provideMainViewModel(MainRepository repository) {
        return new MainViewModel(repository);
    }


}
