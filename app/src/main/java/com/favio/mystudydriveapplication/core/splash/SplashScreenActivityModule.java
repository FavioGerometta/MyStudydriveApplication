package com.favio.mystudydriveapplication.core.splash;

import androidx.lifecycle.ViewModelProvider;


import com.favio.mystudydriveapplication.studydrive.utils.ViewModelProviderFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class SplashScreenActivityModule {

    @Provides
    ViewModelProvider.Factory provideViewModelProvider(SplashScreenViewModel viewModel){
        return new ViewModelProviderFactory<>(viewModel);
    }
}
