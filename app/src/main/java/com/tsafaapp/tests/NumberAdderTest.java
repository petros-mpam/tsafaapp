package com.tsafaapp.tests;

import android.test.suitebuilder.annotation.SmallTest;

import com.tsafaapp.NumberAdder;

import junit.framework.TestCase;

/**
 * Created by kosta on 12/12/2017.
 */

public class NumberAdderTest extends TestCase {

    @Override
    protected void setUp() throws Exception{    //Used in more complex activities
        super.setUp();
    }

    @SmallTest
    public void testNumberAdder(){
        int result = NumberAdder.addNumbers(2, 3);
        assertEquals(5, result);
    }

    @Override
    protected void tearDown() throws Exception{ // Used in more complex activities
        super.tearDown();
    }
}
