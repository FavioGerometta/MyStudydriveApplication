package com.favio.mystudydriveapplication.core.base;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel<T extends BaseViewModel.IView> {

    protected CompositeDisposable compositeDisposable;
    T view;

    public BaseViewModel() {
        compositeDisposable = new CompositeDisposable();
    }

    public void attach(T view) {
        this.view = view;
    }

    public void detach() {
        view = null;
    }

    public void clearSubscriptions() {
        compositeDisposable.clear();
    }
    public interface IView {

        void error(Throwable e);

        void error();
    }
}