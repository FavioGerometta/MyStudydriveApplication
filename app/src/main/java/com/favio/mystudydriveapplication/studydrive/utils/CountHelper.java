package com.favio.mystudydriveapplication.studydrive.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class CountHelper {
    private static final AtomicInteger counter = new AtomicInteger();

    public static int getLast()
    {
        return counter.incrementAndGet();
    }
}
