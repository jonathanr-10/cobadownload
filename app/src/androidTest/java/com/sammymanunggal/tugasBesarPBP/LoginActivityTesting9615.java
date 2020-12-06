package com.sammymanunggal.tugasBesarPBP;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.sammymanunggal.tugasBesarPBP.model.SignUpIn.SignIn;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTesting9615 {

    @Rule
    public ActivityTestRule<SignIn> mActivityTestRule = new ActivityTestRule<>(SignIn.class);

    @Test
    public void loginActivityTesting9615() {


        ViewInteraction materialButton11 = onView(
                allOf(withId(R.id.buttonSignIn), withText("Sign In"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton11.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.editTextEmailAddress),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText2.perform(click());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.editTextEmailAddress),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText3.perform(replaceText("dimasprayoga2@gmail.com"), closeSoftKeyboard());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.buttonSignIn), withText("Sign In"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.editTextPassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextPassword_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText4.perform(replaceText("dimas1"), closeSoftKeyboard());

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.editTextEmailAddress), withText("dimasprayoga2@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText5.perform(replaceText(""));

        ViewInteraction textInputEditText6 = onView(
                allOf(withId(R.id.editTextEmailAddress),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText6.perform(closeSoftKeyboard());

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.buttonSignIn), withText("Sign In"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction textInputEditText7 = onView(
                allOf(withId(R.id.editTextEmailAddress),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText7.perform(click());

        ViewInteraction textInputEditText8 = onView(
                allOf(withId(R.id.editTextEmailAddress),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText8.perform(replaceText("dimasprayoga2@gmail.com"), closeSoftKeyboard());

        ViewInteraction textInputEditText9 = onView(
                allOf(withId(R.id.editTextPassword), withText("dimas1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextPassword_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText9.perform(replaceText("dimas11"));

        ViewInteraction textInputEditText10 = onView(
                allOf(withId(R.id.editTextPassword), withText("dimas11"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextPassword_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText10.perform(closeSoftKeyboard());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.buttonSignIn), withText("Sign In"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction textInputEditText11 = onView(
                allOf(withId(R.id.editTextPassword), withText("dimas11"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextPassword_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText11.perform(replaceText("dimas1"));

        ViewInteraction textInputEditText12 = onView(
                allOf(withId(R.id.editTextPassword), withText("dimas1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextPassword_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText12.perform(closeSoftKeyboard());

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.buttonSignIn), withText("Sign In"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton5.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
