package com.favio.mystudydriveapplication.studydrive.screens.main;

import androidx.lifecycle.MutableLiveData;

import com.favio.mystudydriveapplication.studydrive.model.MyItem;
import com.favio.mystudydriveapplication.studydrive.utils.Constants;
import com.favio.mystudydriveapplication.studydrive.utils.CountHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainRepository {

    private MutableLiveData<List<MyItem>> mutableLiveData = new MutableLiveData<>();
    private List<MyItem> list = new ArrayList<>();
    int observableCount = 0;
    @Inject
    public MainRepository() {}

    public void fetchLatest(String type) {
        observableCount++;
        Observable<List<MyItem>> observable = Observable.fromArray(list);
        int seconds = 3;
        if(Constants.CONSUMER.equals(type)){
            seconds = 4;
        }
        observable.subscribeOn(Schedulers.io())
                .delay(seconds, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .repeat()
                .subscribe(new Observer<List<MyItem>>() {
                    Integer number = observableCount;
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<MyItem> modifiedItems) {
                        if(Constants.PRODUCER.equals(type)) {

                            modifiedItems.add(new MyItem("Item: "+CountHelper.getLast() + " Observable: " + number.toString()));
                        }
                        else if(modifiedItems.size()>0){
                            modifiedItems.remove(0);
                        }
                        mutableLiveData.postValue(modifiedItems);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public MutableLiveData<List<MyItem>> getLatestData(String type) {
        fetchLatest(type);
        return mutableLiveData;
    }

}
