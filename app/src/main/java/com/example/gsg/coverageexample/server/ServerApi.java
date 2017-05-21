package com.example.gsg.coverageexample.server;

import com.example.gsg.coverageexample.model.ResponseModel;

import retrofit2.http.GET;
import rx.Single;

/**
 * Created by gsg on 31.08.2016.
 */

public interface ServerApi {

    @GET("/ip")
    Single<ResponseModel> getIp();
}
