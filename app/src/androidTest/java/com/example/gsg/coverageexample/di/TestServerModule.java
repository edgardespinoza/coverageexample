package com.example.gsg.coverageexample.di;

import com.example.gsg.coverageexample.mocks.MockServer;
import com.example.gsg.coverageexample.server.ServerApi;

import dagger.Module;

/**
 * Created by gsg on 31.08.2016.
 */
@Module
public class TestServerModule extends ServerModule{

    public TestServerModule() {super();}

    @Override
    protected ServerApi getServerApi() {
        return new MockServer();
    }
}
