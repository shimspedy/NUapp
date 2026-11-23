package code.android.abdulrahman.com.lifecyleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

/**
 * The main screen of the life cycle example. Every life cycle method adds a line to a message
 * saying that it was called, together with a counter that shows the order of the calls.
 */
public class MainActivity extends AppCompatActivity {

  public static final String EXTRA_MESSAGE =
      "code.android.abdulrahman.com.LifeCycleapplication.MESSAGE";
  private static final String MAIN_TAG = "MainActivity";

  /** The list of life cycle methods of this activity that have been called so far. */
  public static String mainActivityCalled = MAIN_TAG;

  /** Counts the life cycle method calls of both activities, so the order can be seen. */
  public static int order = 0;

  public String message = "No data from intent";

  private TextView messageTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    messageTextView = findViewById(R.id.messageTextArea);
    messageTextView.setMovementMethod(new ScrollingMovementMethod());
    mainActivityCalled =
        mainActivityCalled + "\n from " + MAIN_TAG + " onCreate method invoked  \n " + order++;
    displayMessage();
  }

  /**
   * Starts DisplayMessageActivity and sends it the list of methods called in this activity.
   *
   * @param view the button that was clicked
   */
  public void sendMessage(View view) {
    Intent intent = new Intent(this, DisplayMessageActivity.class);
    intent.putExtra(EXTRA_MESSAGE, mainActivityCalled);
    Log.d(MAIN_TAG, "Intent fired ");
    startActivity(intent);
  }

  /**
   * Clears the message on the screen and sets the counter back to zero.
   *
   * @param view the button that was clicked
   */
  public void cleanMainDisplay(View view) {
    order = 0;
    mainActivityCalled = "";
    setContentView(R.layout.activity_main);
  }

  /**
   * Goes back to the menu screen.
   *
   * @param view the button that was clicked
   */
  public void toFirstScreen(View view) {
    startActivity(new Intent(this, MenuActivity.class));
  }

  /**
   * Leaves the app by going to the phone's home screen.
   *
   * @param view the button that was clicked
   */
  public void exitApp(View view) {
    mainActivityCalled = "";
    Intent intent = new Intent(Intent.ACTION_MAIN);
    intent.addCategory(Intent.CATEGORY_HOME);
    startActivity(intent);
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    Log.d("tag", "onSaveInstanceState() called" + order++);
    mainActivityCalled =
        mainActivityCalled
            + "\n from "
            + MAIN_TAG
            + "onSaveInstanceState method invoked  "
            + order++;
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    mainActivityCalled =
        mainActivityCalled
            + "\n from "
            + MAIN_TAG
            + "onRestoreInstanceState method invoked  "
            + order;
  }

  @Override
  protected void onStart() {
    super.onStart();
    mainActivityCalled =
        mainActivityCalled + "\n from " + MAIN_TAG + " onStart method invoked  " + order++;
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    mainActivityCalled =
        mainActivityCalled + "\n from " + MAIN_TAG + " onRestart method invoked   " + order++;
  }

  @Override
  protected void onResume() {
    super.onResume();
    mainActivityCalled =
        mainActivityCalled + "\n from " + MAIN_TAG + " onResume method invoked  " + order++;
  }

  @Override
  protected void onPause() {
    super.onPause();
    mainActivityCalled =
        mainActivityCalled + "\n from " + MAIN_TAG + " onPause method invoked  " + order++;
  }

  @Override
  protected void onStop() {
    super.onStop();
    mainActivityCalled =
        mainActivityCalled + "\n from " + MAIN_TAG + " onStop method invoked  " + order++;
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    mainActivityCalled =
        mainActivityCalled + "\n from " + MAIN_TAG + "onDestroy method invoked  " + order++;
  }

  /**
   * Shows the message that came with the intent that started this activity. The message is the
   * list of life cycle methods called in DisplayMessageActivity.
   */
  public void displayMessage() {
    Intent intent = getIntent();
    if (intent != null) {
      if (intent.hasExtra(getString(R.string.appmessage))) {
        message = intent.getStringExtra(getString(R.string.appmessage));
        Log.d(MAIN_TAG, "Got Intent");
      }
    }
    messageTextView.setText(message);
  }
}
