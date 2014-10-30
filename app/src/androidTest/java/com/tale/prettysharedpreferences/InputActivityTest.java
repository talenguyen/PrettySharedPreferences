package com.tale.prettysharedpreferences;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.tale.prettysharedpreferences.sample.InputActivity;
import com.tale.prettysharedpreferences.sample.R;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

/**
 * Created by TALE on 10/30/2014.
 */
@LargeTest
public class InputActivityTest extends ActivityInstrumentationTestCase2<InputActivity> {

    @SuppressWarnings("deprecation")
    public InputActivityTest() {
        // This constructor was deprecated - but we want to support lower API levels.
        super("com.tale.prettysharedpreferences.sample", InputActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        // Espresso will not launch our activity for us, we must launch it via getActivity().
        getActivity();
    }

    public void testIntegerSaveAndLoad() {
        onView(withId(R.id.etInteger)).perform(typeText("12"));
        onView(withId(R.id.btSaveInteger)).perform(click());

        onView(withId(R.id.tvIntegerVal)).check(matches(withText("12")));
    }

}
