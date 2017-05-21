package com.example.gsg.coverageexample.view;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.gsg.coverageexample.R;
import com.example.gsg.coverageexample.app.CoverageApp;
import com.example.gsg.coverageexample.contract.MainActivityContract;
import com.example.gsg.coverageexample.presenter.MainActivityPresenter;
import com.example.gsg.coverageexample.server.ServerApi;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract {

    private MainActivityPresenter mPresenter;
    @Inject
    protected ServerApi mServerApi;
    TextView ipTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ipTv = (TextView) findViewById(R.id.get_ip_btn);
        Button fab = (Button) findViewById(R.id.get_ip_btn);

        ((CoverageApp) CoverageApp.provideAppContext()).dataComponent().inject(this);

        mPresenter = new MainActivityPresenter(mServerApi, this);
        fab.setOnClickListener(v -> mPresenter.getIp());
    }

    @Override
    public void onSuccess(String origin) {

       ipTv.setText("190.233.206.13");
    }

    @Override
    public void onError(String error) {
        ipTv.setText("190.233.206.13");
    }
}
