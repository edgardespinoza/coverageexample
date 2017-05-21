package com.example.gsg.coverageexample.rule;

import android.content.Context;

import com.example.gsg.coverageexample.app.CoverageApp;
import com.example.gsg.coverageexample.di.DaggerTestServerComponent;
import com.example.gsg.coverageexample.di.TestServerComponent;
import com.example.gsg.coverageexample.di.TestServerModule;
import com.example.gsg.coverageexample.server.ServerApi;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Created by Sergey on 26.07.2016.
 */

public class MyTestRule implements TestRule {

    private final TestServerComponent mTestComponent;
    private final Context mContext;

    public MyTestRule(Context context) {
        mContext = context;
        CoverageApp application = (CoverageApp) context.getApplicationContext();
        mTestComponent = DaggerTestServerComponent.builder()
                .testServerModule(new TestServerModule())
                .build();
    }


    public ServerApi getMockDataManager() {
        return mTestComponent.getServerApi();
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                CoverageApp application = (CoverageApp) mContext.getApplicationContext();
                // Set the TestComponent before the test runs
                application.setServerComponent(mTestComponent);
                base.evaluate();
                // Clears the component once the tets finishes so it would use the default one.
                application.setServerComponent(null);
            }
        };
    }
}
