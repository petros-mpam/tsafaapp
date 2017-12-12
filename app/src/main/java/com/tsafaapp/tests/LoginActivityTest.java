package com.tsafaapp.tests;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.TextView;

import com.tsafaapp.LoginActivity;
import com.tsafaapp.R;

/**
 * Created by kosta on 12/12/2017.
 */

public class LoginActivityTest extends ActivityInstrumentationTestCase2<LoginActivity> {

    LoginActivity activity;

    public LoginActivityTest(){
        super(LoginActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        activity = getActivity();
    }

    @SmallTest
    public void testTextViewNotNull() {
        TextView textView = (TextView) activity.findViewById(R.id.signup);
        assertNotNull(textView);
    }
}
