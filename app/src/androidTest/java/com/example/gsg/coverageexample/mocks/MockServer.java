package com.example.gsg.coverageexample.mocks;

import com.example.gsg.coverageexample.model.ResponseModel;
import com.example.gsg.coverageexample.server.ServerApi;

import rx.Single;

/**
 * Created by gsg on 31.08.2016.
 */

public class MockServer implements ServerApi {

    private ResponseModel mResponse;

    public MockServer(){
    }

    public ResponseModel getResponse() {
        return mResponse;
    }

    public void setResponse(ResponseModel mResponse) {
        this.mResponse = mResponse;
    }

    @Override
    public Single<ResponseModel> getIp() {
        return Single.just(mResponse);
    }
}
