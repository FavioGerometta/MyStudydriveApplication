package com.favio.mystudydriveapplication.studydrive.utils;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelProviderFactory<V> implements ViewModelProvider.Factory {
    private V viewModel;
    //could add here whatever repository or service I want to expose to all vms
    public ViewModelProviderFactory(V viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(viewModel.getClass())) {//any type of vm, could be custom
            return (T) viewModel;
        }
        throw new IllegalArgumentException("Unknown class name!");
    }
}