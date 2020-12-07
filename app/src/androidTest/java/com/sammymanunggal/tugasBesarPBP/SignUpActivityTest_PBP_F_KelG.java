package com.sammymanunggal.tugasBesarPBP;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.sammymanunggal.tugasBesarPBP.model.SignUpIn.SignUp;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
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
public class SignUpActivityTest_PBP_F_KelG {

    @Rule
    public ActivityTestRule<SignUp> mActivityTestRule = new ActivityTestRule<>(SignUp.class);

    @Test
    public void signUpActivityTest_PBP_F_KelG() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.buttonSignUp), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        6),
                                0),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.editTextTextEmailAddress),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.editTextTextEmailAddress),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("jonathan@gmail.com"), closeSoftKeyboard());



        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.buttonSignUp), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        6),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.editTextTextPassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextPassword_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText3.perform(replaceText("123"), closeSoftKeyboard());



        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.buttonSignUp), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        6),
                                0),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.editTextTextPassword), withText("123"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextPassword_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText4.perform(click());

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.editTextTextPassword), withText("123"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextPassword_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText5.perform(replaceText("123456"));

        ViewInteraction textInputEditText6 = onView(
                allOf(withId(R.id.editTextTextPassword), withText("123456"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextPassword_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText6.perform(closeSoftKeyboard());



        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.buttonSignUp), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        6),
                                0),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction textInputEditText7 = onView(
                allOf(withId(R.id.editTextName),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextName_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText7.perform(replaceText("jo"), closeSoftKeyboard());



        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.buttonSignUp), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        6),
                                0),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction textInputEditText8 = onView(
                allOf(withId(R.id.editTextTextAddress),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextAddress_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText8.perform(replaceText("jalan"), closeSoftKeyboard());



        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.buttonSignUp), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        6),
                                0),
                        isDisplayed()));
        materialButton6.perform(click());

        ViewInteraction textInputEditText9 = onView(
                allOf(withId(R.id.editTextTextNumber),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextNumber_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText9.perform(replaceText("08"), closeSoftKeyboard());



        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.buttonSignUp), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        6),
                                0),
                        isDisplayed()));
        materialButton7.perform(click());

        ViewInteraction textInputEditText10 = onView(
                allOf(withId(R.id.editTextTextNumber), withText("08"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextNumber_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText10.perform(click());

        ViewInteraction textInputEditText11 = onView(
                allOf(withId(R.id.editTextTextNumber), withText("08"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextNumber_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText11.perform(replaceText("085274681841"));

        ViewInteraction textInputEditText12 = onView(
                allOf(withId(R.id.editTextTextNumber), withText("085274681841"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextNumber_layout),
                                        0),
                                1),
                        isDisplayed()));
        textInputEditText12.perform(closeSoftKeyboard());



        ViewInteraction textInputEditText13 = onView(
                allOf(withId(R.id.editTextTextEmailAddress), withText("jonathan@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText13.perform(replaceText("jonathanrocksea@gmail.com"));

        ViewInteraction textInputEditText14 = onView(
                allOf(withId(R.id.editTextTextEmailAddress), withText("jonathanrocksea@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText14.perform(closeSoftKeyboard());



        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.buttonSignUp), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        6),
                                0),
                        isDisplayed()));
        materialButton8.perform(click());

        ViewInteraction textInputEditText15 = onView(
                allOf(withId(R.id.editTextTextEmailAddress), withText("jonathanrocksea@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText15.perform(click());

        ViewInteraction textInputEditText16 = onView(
                allOf(withId(R.id.editTextTextEmailAddress), withText("jonathanrocksea@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText16.perform(replaceText("jonathaa@gmail.com"));

        ViewInteraction textInputEditText17 = onView(
                allOf(withId(R.id.editTextTextEmailAddress), withText("jonathaa@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText17.perform(closeSoftKeyboard());



        ViewInteraction materialButton9 = onView(
                allOf(withId(R.id.buttonSignUp), withText("Register"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        6),
                                0),
                        isDisplayed()));
        materialButton9.perform(click());
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
