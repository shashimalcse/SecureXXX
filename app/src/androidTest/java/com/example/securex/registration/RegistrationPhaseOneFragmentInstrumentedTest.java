package com.example.securex.registration;



import android.content.Context;


import androidx.test.core.app.ApplicationProvider;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.securex.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static org.junit.Assert.*;
//@RunWith(AndroidJUnit4.class)
public class RegistrationPhaseOneFragmentInstrumentedTest {

    private static final String TEST_EMAIL = "shashimal@gmail.com";
    private static final String TEST_USERNAME = "shashimal4";

    @Rule
    public ActivityScenarioRule<MainActivity> activityActivityScenario = new ActivityScenarioRule<>(MainActivity.class);

    private Context context = ApplicationProvider.getApplicationContext();

    RegistrationPhaseOneFragment registrationPhaseOneFragment = new RegistrationPhaseOneFragment();

    @Test
    public void validateEmail(){
        boolean valid =registrationPhaseOneFragment.isValidEmail(TEST_EMAIL);
        assertEquals(valid,true);
    }
    @Test
    public void validateUsername(){
        boolean valid=registrationPhaseOneFragment.isValidUsername(TEST_USERNAME);
        assertEquals(valid,true);
    }

    @Test
    public void username_email_validation(){

        String result=registrationPhaseOneFragment.Validation(TEST_USERNAME,TEST_EMAIL);
        assertEquals(result,"valid");

    }
    @Test
    public void EdiTextTest(){
        onView(withId(R.id.username)).perform(typeText(TEST_USERNAME),closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText(TEST_EMAIL),closeSoftKeyboard());
        onView(withId(R.id.phase1next)).perform(click());
    }


}