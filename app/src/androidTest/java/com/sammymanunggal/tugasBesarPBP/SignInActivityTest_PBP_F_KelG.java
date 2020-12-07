package com.sammymanunggal.tugasBesarPBP;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

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
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SignInActivityTest_PBP_F_KelG {

    @Rule
    public ActivityTestRule<SplashActivity> mActivityTestRule = new ActivityTestRule<>(SplashActivity.class);

    @Test
    public void signInActivityTest_PBP_F_KelG() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.buttonSignIn), withText("Sign In"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.editTextEmailAddress),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(click());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.editTextEmailAddress),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("jonathanrocksea@gmail.com"), closeSoftKeyboard());

        pressBack();

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.buttonSignIn), withText("Sign In"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.editTextPassword),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextPassword_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText3.perform(replaceText("123456"), closeSoftKeyboard());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.editTextEmailAddress), withText("jonathanrocksea@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText4.perform(replaceText(""));

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.editTextEmailAddress),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText5.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.buttonSignIn), withText("Sign In"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction textInputEditText6 = onView(
                allOf(withId(R.id.editTextEmailAddress),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText6.perform(click());

        ViewInteraction textInputEditText7 = onView(
                allOf(withId(R.id.editTextEmailAddress),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText7.perform(replaceText("jonathanrocksea@gmail.com"), closeSoftKeyboard());

        ViewInteraction textInputEditText8 = onView(
                allOf(withId(R.id.editTextEmailAddress), withText("jonathanrocksea@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText8.perform(pressImeActionButton());

        ViewInteraction textInputEditText9 = onView(
                allOf(withId(R.id.editTextPassword), withText("123456"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextPassword_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText9.perform(replaceText("12345"));

        ViewInteraction textInputEditText10 = onView(
                allOf(withId(R.id.editTextPassword), withText("12345"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextPassword_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText10.perform(closeSoftKeyboard());

        pressBack();

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
                allOf(withId(R.id.editTextPassword), withText("12345"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextPassword_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText11.perform(click());

        ViewInteraction textInputEditText12 = onView(
                allOf(withId(R.id.editTextPassword), withText("12345"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextPassword_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText12.perform(replaceText("123456"));

        ViewInteraction textInputEditText13 = onView(
                allOf(withId(R.id.editTextPassword), withText("123456"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextPassword_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText13.perform(closeSoftKeyboard());

        ViewInteraction textInputEditText14 = onView(
                allOf(withId(R.id.editTextEmailAddress), withText("jonathanrocksea@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText14.perform(replaceText("a@gmail.com"));

        ViewInteraction textInputEditText15 = onView(
                allOf(withId(R.id.editTextEmailAddress), withText("a@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText15.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.buttonSignIn), withText("Sign In"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton5.perform(click());

        ViewInteraction textInputEditText16 = onView(
                allOf(withId(R.id.editTextEmailAddress), withText("a@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText16.perform(click());

        ViewInteraction textInputEditText17 = onView(
                allOf(withId(R.id.editTextEmailAddress), withText("a@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText17.perform(replaceText("jonathanrocksea@gmail.com"));

        ViewInteraction textInputEditText18 = onView(
                allOf(withId(R.id.editTextEmailAddress), withText("jonathanrocksea@gmail.com"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.editTextEmailAddress_layout),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText18.perform(closeSoftKeyboard());

        pressBack();

        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.buttonSignIn), withText("Sign In"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        3),
                                0),
                        isDisplayed()));
        materialButton6.perform(click());
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
