package code.android.abdulrahman.com.lifecyleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * The second screen of the Parcelable example. It shows the order of the life cycle methods that
 * were called in ParcelableActivity.
 */
public class ParcelableDisplayMessageActivity extends AppCompatActivity {

  public static final String BACK_MESSAGE =
      "code.android.abdulrahman.com.paracelableLifeCycle.MESSAGE";
  private static final String MESSAGE_TAG = "ParcelableDisplayMessageActivity";

  /** The list of life cycle methods of this activity that have been called so far. */
  public static String isCalled = MESSAGE_TAG;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle("Parcelable Display Message");
    setContentView(R.layout.activity_parcelable_display_message);
    isCalled = isCalled + "\n from " + MESSAGE_TAG + " onCreate method invoked  ";

    Intent intent = getIntent();
    if (intent != null) {
      if (intent.hasExtra("invokedMethods")) {
        ParcelableActivity.myDataObject = getIntent().getParcelableExtra("invokedMethods");

        MyDataObject received = getIntent().getParcelableExtra("invokedMethods");

        Log.d(MESSAGE_TAG, "Got Intent");

        Log.d("A----", received.getInOnCreate());
        Log.d("B----", received.getInOnStart());
        Log.d("C---", received.getInOnResume());
        Log.d("D----", received.getInOnRestart());
        Log.d("F----", received.getInOnStop());
        Log.d("G----", received.getInOnPause());
        Log.i("intValue", received.intValue + "");
        Log.i("double", received.doubleValue + "");
      }
    }

    TextView messageTextView = findViewById(R.id.TextMessage);
    messageTextView.setText(ParcelableActivity.myDataObject.toString());
  }

  /**
   * Starts ParcelableActivity and sends it the list of methods called in this activity.
   *
   * @param view the button that was clicked
   */
  public void goToMain(View view) {
    Intent intent = new Intent(this, ParcelableActivity.class);
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
    Log.d("tag", "onSaveInstanceState() called");
  }

  @Override
  protected void onStart() {
    super.onStart();
    isCalled = isCalled + "\n from " + MESSAGE_TAG + " onStart method invoked  ";
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    isCalled = isCalled + "\n from " + MESSAGE_TAG + " onRestart method invoked  ";
  }

  @Override
  protected void onResume() {
    super.onResume();
    isCalled = isCalled + "\n from " + MESSAGE_TAG + " onResume method invoked  ";
  }

  @Override
  protected void onPause() {
    super.onPause();
    isCalled = isCalled + "\n from " + MESSAGE_TAG + " onPause method invoked  ";
  }

  @Override
  protected void onStop() {
    super.onStop();
    isCalled = isCalled + "\n from " + MESSAGE_TAG + " onStop method invoked  ";
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    isCalled = isCalled + MESSAGE_TAG + "\n onDestroy method invoked  ";
  }

  /**
   * Returns the name of this activity.
   *
   * @return the name of this activity
   */
  public static String getMessageTag() {
    return MESSAGE_TAG;
  }
}
