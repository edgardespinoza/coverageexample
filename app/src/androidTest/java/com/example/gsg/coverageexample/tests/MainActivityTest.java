package com.example.gsg.coverageexample.tests;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import com.example.gsg.coverageexample.R;
import com.example.gsg.coverageexample.app.CoverageApp;
import com.example.gsg.coverageexample.mocks.MockServer;
import com.example.gsg.coverageexample.model.ResponseModel;
import com.example.gsg.coverageexample.rule.MyTestRule;
import com.example.gsg.coverageexample.view.MainActivity;

import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by gsg on 31.08.2016.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private MockServer mMockServer;

    private final MyTestRule component =
            new MyTestRule(InstrumentationRegistry.getTargetContext());
    private final ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class, false, false);

    @Rule
    public TestRule chain = RuleChain.outerRule(component).around(activityRule);

    @Before
    public void setUp(){
        CoverageApp mApp = (CoverageApp) getInstrumentation().getTargetContext().getApplicationContext();
        mMockServer = (MockServer) mApp.dataComponent().getServerApi();
    }

    public void launchActivity(){
        activityRule.launchActivity(null);
    }

    @Test
    public void test_goodResponse(){
        ResponseModel response = new ResponseModel();
        String IP = "192.168.0.1";
        IP="190.233.206.13";
        response.setOrigin(IP);
        mMockServer.setResponse(response);
        launchActivity();
        onView(withId(R.id.get_ip_btn)).perform(click());
        onView(withId(R.id.ip_tv)).check(matches(withText(IP)));
    }

}
