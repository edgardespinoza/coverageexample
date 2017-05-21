package com.example.gsg.coverageexample.app;

import android.app.Application;
import android.content.Context;

import com.example.gsg.coverageexample.di.DaggerServerComponent;
import com.example.gsg.coverageexample.di.ServerComponent;
import com.example.gsg.coverageexample.di.ServerModule;

/**
 * Created by gsg on 31.08.2016.
 */

public class CoverageApp extends Application{

    private ServerComponent mServerComponent;

    private static Context mContext;

    public static void setContext(Context mContext) {
        CoverageApp.mContext = mContext;
    }

    public static Context provideAppContext(){
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setContext(getApplicationContext());
        initializeDaggerGraph();
    }

    private void initializeDaggerGraph() {
        mServerComponent = DaggerServerComponent.builder()
                .serverModule(new ServerModule())
                .build();
    }

    public void setServerComponent(ServerComponent mServerComponent) {
        this.mServerComponent = mServerComponent;
    }

    public ServerComponent dataComponent(){
        return mServerComponent;
    }
}
