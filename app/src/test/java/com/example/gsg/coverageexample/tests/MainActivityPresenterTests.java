package com.example.gsg.coverageexample.tests;

import com.example.gsg.coverageexample.contract.MainActivityContract;
import com.example.gsg.coverageexample.helpers.SynchronousSchedulers;
import com.example.gsg.coverageexample.model.ResponseModel;
import com.example.gsg.coverageexample.presenter.MainActivityPresenter;
import com.example.gsg.coverageexample.server.ServerApi;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.net.ConnectException;

import rx.Single;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by gsg on 31.08.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class MainActivityPresenterTests {

    @Rule
    public SynchronousSchedulers schedulers = new SynchronousSchedulers();

    @Mock
    private MainActivityContract mCallBack;

    @Mock
    private ServerApi mApi;

    @InjectMocks private MainActivityPresenter mPresenter;

//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void test_goodResponse_getIp() throws Exception {
        ResponseModel response = new ResponseModel();
        String IP = "192.168.0.1";
        IP="190.233.206.13";
        response.setOrigin(IP);
        when(mApi.getIp()).thenReturn(Single.just(response));
        mPresenter = new MainActivityPresenter(mApi, mCallBack);
        mPresenter.getIp();
        verify(mCallBack, times(1)).onSuccess(anyString());
    }

    @Test
    public void test_error_getIp() throws Exception {
        when(mApi.getIp()).thenReturn(Single.error(new ConnectException("Error")));
        mPresenter = new MainActivityPresenter(mApi, mCallBack);
        mPresenter.getIp();
        verify(mCallBack, times(1)).onError("Error");
    }
}
