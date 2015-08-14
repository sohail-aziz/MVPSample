package aziz.sohail.MVPsample.presentation.view.activity;


import android.test.ActivityInstrumentationTestCase2;

import aziz.sohail.MVPsample.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

/**
 * Created by Sohail Aziz on 8/6/2015.
 */
public class LoginActivityTests extends ActivityInstrumentationTestCase2<LoginActivity> {

    private LoginActivity loginActivity;

    public LoginActivityTests() {
        super(LoginActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        loginActivity = getActivity();
    }

    public void testPreconditions() {
        assertNotNull("Activity is null", loginActivity);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSupportFragmentExists() {
        android.support.v4.app.Fragment loginFragment = loginActivity.getSupportFragmentManager().findFragmentById(R.id.login_fragment);
        assertNotNull("Support Login fragment is null", loginFragment);
    }

    public void testHappyCaseViews() {

        onView(withId(R.id.editTextUsernameFragmentLogin)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextPasswordFragmentLogin)).check(matches(isDisplayed()));
        onView(withId(R.id.buttonLoginFragmentLogin)).check(matches(isDisplayed()));

        onView(withId(R.id.progressBarFragmentLogin)).check(matches(not(isDisplayed())));
    }


}
