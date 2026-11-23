package code.android.abdulrahman.com.lifecyleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * The second screen of the life cycle example. It shows the list of methods called in
 * MainActivity and keeps its own list of the life cycle methods called here.
 */
public class DisplayMessageActivity extends AppCompatActivity {

  public static final String BACK_MESSAGE =
      "code.android.abdulrahman.com.LifeCycleapplication.MESSAGE";
  private static final String MESSAGE_TAG = "DisplayMessageActivity";

  /** The list of life cycle methods of this activity that have been called so far. */
  public static String isCalled = MESSAGE_TAG;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle("Message Activity");
    setContentView(R.layout.activity_display_message);
    String message = "";
    isCalled =
        isCalled + "\n from " + MESSAGE_TAG + " onCreate method invoked  " + MainActivity.order++;

    Intent intent = getIntent();
    if (intent != null) {
      if (intent.hasExtra(getString(R.string.appmessage))) {
        message =
            intent.getStringExtra("code.android.abdulrahman.com.LifeCycleapplication.MESSAGE");
        Log.d(MESSAGE_TAG, "Got Intent");
      }
    }
    TextView messageTextView = findViewById(R.id.TextMessage);
    messageTextView.setMovementMethod(new ScrollingMovementMethod());
    messageTextView.setText(message);
  }

  /**
   * Starts MainActivity and sends it the list of methods called in this activity.
   *
   * @param view the button that was clicked
   */
  public void goToMain(View view) {
    Intent intent = new Intent(this, MainActivity.class);
    intent.putExtra(BACK_MESSAGE, isCalled);
    Log.d(MESSAGE_TAG, "Intent fired ");
    startActivity(intent);
  }

  /**
   * Clears the message on the screen and sets the counter back to zero.
   *
   * @param view the button that was clicked
   */
  public void cleanDisplay(View view) {
    isCalled = "";
    MainActivity.order = 0;
    setContentView(R.layout.activity_display_message);
  }

  /**
   * Leaves the app by going to the phone's home screen.
   *
   * @param view the button that was clicked
   */
  public void closeApp(View view) {
    isCalled = "";
    Intent intent = new Intent(Intent.ACTION_MAIN);
    intent.addCategory(Intent.CATEGORY_HOME);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    Log.d("tag", "onSaveInstanceState() called" + MainActivity.order++);
  }

  @Override
  protected void onStart() {
    super.onStart();
    isCalled =
        isCalled + "\n from " + MESSAGE_TAG + " onStart method invoked  " + MainActivity.order++;
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    isCalled =
        isCalled + "\n from " + MESSAGE_TAG + " onRestart method invoked  " + MainActivity.order++;
  }

  @Override
  protected void onResume() {
    super.onResume();
    isCalled =
        isCalled + "\n from " + MESSAGE_TAG + " onResume method invoked  " + MainActivity.order++;
  }

  @Override
  protected void onPause() {
    super.onPause();
    isCalled =
        isCalled + "\n from " + MESSAGE_TAG + " onPause method invoked  " + MainActivity.order++;
  }

  @Override
  protected void onStop() {
    super.onStop();
    isCalled =
        isCalled + "\n from " + MESSAGE_TAG + " onStop method invoked  " + MainActivity.order++;
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    Log.i("onDestroy------------------------------------", MainActivity.order + "");
    isCalled = isCalled + MESSAGE_TAG + "\n onDestroy method invoked  " + MainActivity.order++;
  }
}
