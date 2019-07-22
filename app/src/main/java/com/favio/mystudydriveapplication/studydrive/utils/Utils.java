package com.favio.mystudydriveapplication.studydrive.utils;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Utils {
    public Context context;

    @Inject
    public Utils(Context context) {
        this.context = context;
    }



}

