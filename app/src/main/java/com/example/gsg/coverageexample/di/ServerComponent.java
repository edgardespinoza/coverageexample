package com.example.gsg.coverageexample.di;

import com.example.gsg.coverageexample.presenter.MainActivityPresenter;
import com.example.gsg.coverageexample.server.ServerApi;
import com.example.gsg.coverageexample.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by gsg on 31.08.2016.
 */
@Singleton
@Component(modules = ServerModule.class)
public interface ServerComponent {

    void inject(MainActivity activity);

    ServerApi getServerApi();
}
