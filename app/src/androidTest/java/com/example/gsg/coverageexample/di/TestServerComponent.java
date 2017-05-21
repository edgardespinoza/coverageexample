package com.example.gsg.coverageexample.di;

import com.example.gsg.coverageexample.server.ServerApi;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by gsg on 31.08.2016.
 */
@Singleton
@Component(modules = TestServerModule.class)
public interface TestServerComponent extends ServerComponent{

    @Singleton
    ServerApi getServerApi();
}
