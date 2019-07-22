package com.favio.mystudydriveapplication.studydrive.screens.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.favio.mystudydriveapplication.studydrive.model.MyItem;

import java.util.List;

import javax.inject.Inject;


public class MainViewModel extends ViewModel {//AndroidViewModel { do I need application context here?
    
    public MainRepository repository;


    @Inject
    public MainViewModel(MainRepository repository)  {
        this.repository = repository;

    }

    public LiveData<List<MyItem>> getRates(String type) {
        return this.repository.getLatestData(type);
    }


    public void onStop() {
    }

    public void onStart() {
    }


}