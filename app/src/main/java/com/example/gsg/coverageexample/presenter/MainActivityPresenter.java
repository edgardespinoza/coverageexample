package com.example.gsg.coverageexample.presenter;

import com.example.gsg.coverageexample.contract.MainActivityContract;
import com.example.gsg.coverageexample.helpers.AppSchedulers;
import com.example.gsg.coverageexample.server.ServerApi;

/**
 * Created by gsg on 31.08.2016.
 */

public class MainActivityPresenter {

    private ServerApi mServerApi;
    private MainActivityContract mCallBack;

    public MainActivityPresenter(ServerApi serverApi, MainActivityContract callBack) {
        this.mCallBack = callBack;
        this.mServerApi = serverApi;
    }


    public void getIp() {
        mServerApi.getIp()
                .subscribeOn(AppSchedulers.io())
                .observeOn(AppSchedulers.mainThread())
                .subscribe(ResponseModel -> {
                    if (null != ResponseModel.getOrigin() && !ResponseModel.getOrigin().isEmpty()) {
                        mCallBack.onSuccess(ResponseModel.getOrigin());
                    } else {
                        mCallBack.onError("Error");
                    }
                }, error -> mCallBack.onError(error.getMessage()));
    }
}
