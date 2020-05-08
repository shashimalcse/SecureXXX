package com.example.securex.registration;



import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.navigation.Navigation;
import androidx.navigation.testing.TestNavHostController;
import androidx.test.core.app.ActivityScenario;
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
public class RegistrationPhaseOneFragmentTest {

    private static final String TEST_EMAIL = "shashimal@gmail.com";
    private static final String TEST_USERNAME = "shashimal4";

    @Rule
    public ActivityScenarioRule<MainActivity> activityActivityScenario = new ActivityScenarioRule<>(MainActivity.class);

    private Context context = ApplicationProvider.getApplicationContext();

    RegistrationPhaseOneFragment registrationPhaseOneFragment = new RegistrationPhaseOneFragment();


    @Test
    public void editUsername(){
        onView(withId(R.id.username)).perform(typeText(TEST_USERNAME),closeSoftKeyboard());
    }


}