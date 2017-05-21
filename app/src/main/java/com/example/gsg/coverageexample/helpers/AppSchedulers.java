package com.example.gsg.coverageexample.helpers;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Sergey on 01.08.2016.
 */

public class AppSchedulers {
    public interface SchedulerProvider {
        Scheduler mainThread();
        Scheduler io();
    }

    private static SchedulerProvider instance = new DefaultSchedulerProvider();

    public static void setInstance(SchedulerProvider instance) {
        AppSchedulers.instance = instance;
    }

    public static Scheduler mainThread(){
        return instance.mainThread();
    }

    public static Scheduler io(){
        return instance.io();
    }

    public static class DefaultSchedulerProvider implements SchedulerProvider {
        @Override
        public Scheduler mainThread() {
            return AndroidSchedulers.mainThread();
        }

        @Override
        public Scheduler io() {
            return Schedulers.io();
        }
    }
}
