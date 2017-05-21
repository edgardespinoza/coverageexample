package com.example.gsg.coverageexample.di;

import com.example.gsg.coverageexample.BuildConfig;
import com.example.gsg.coverageexample.server.ServerApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gsg on 31.08.2016.
 */
@Module
public class ServerModule {

    private static final String BASE_URL = "http://httpbin.org";

    @Provides
    @Singleton
    public ServerApi provideServerApi(){
        return getServerApi();
    }

    protected ServerApi getServerApi() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        return mRetrofit.create(ServerApi.class);
    }

}
