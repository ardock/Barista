package com.schibsted.spain.barista.sample;

import android.support.test.runner.AndroidJUnit4;
import com.schibsted.spain.barista.flakyespresso.FlakyActivityTestRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.schibsted.spain.barista.BaristaAssertions.assertDisplayed;
import static com.schibsted.spain.barista.BaristaAssertions.assertHint;
import static com.schibsted.spain.barista.BaristaEditTextActions.writeToEditText;

@RunWith(AndroidJUnit4.class)
public class EditTextTest {

  @Rule
  public FlakyActivityTestRule<EditTextActivity> activityRule =
      new FlakyActivityTestRule<>(EditTextActivity.class)
          .allowFlakyAttemptsByDefault(10);

  @Test
  public void checkWriteOnEditText_whenEditTextIsVisible() {
    writeToEditText(R.id.edittext, "Hello!");
    assertDisplayed("Hello!");
  }

  @Test
  public void checkWriteOnEditText_whenScrollIsNeeded() {
    writeToEditText(R.id.edittext_very_far_away, "Hello!");
    assertDisplayed("Hello!");
  }

  @Test
  public void checkWriteOnEditText_whenParentIsNotAScrollView() {
    writeToEditText(R.id.edittext_centered, "Hello!");
    assertDisplayed("Hello!");
  }

  @Test
  public void assertHintById() {
    assertHint(R.id.edittext_centered, R.string.centered_edittext);
  }

  @Test
  public void assertHintByString() {
    assertHint(R.id.edittext_centered, "I'm a centered edittext!");
  }
}
