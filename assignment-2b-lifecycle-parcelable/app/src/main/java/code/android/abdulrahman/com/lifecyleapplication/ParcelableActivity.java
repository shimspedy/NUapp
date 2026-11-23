package code.android.abdulrahman.com.lifecyleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * The main screen of the Parcelable example. Every life cycle method records its name in a
 * MyDataObject, and that object is sent to ParcelableDisplayMessageActivity inside an intent.
 */
public class ParcelableActivity extends AppCompatActivity {

  private static final String MAIN_TAG = "ParcelableActivity";

  public static String mainActivityCalled = MAIN_TAG;

  private static double pyValue = 3.14;
  private static int someIntValue = 100;

  /** Holds the names of the life cycle methods that have been called in this activity. */
  public static MyDataObject myDataObject = new MyDataObject(someIntValue, pyValue);

  public String message = "";

  /**
   * Returns the name of this activity, used when building the list of called methods.
   *
   * @return the name of this activity
   */
  public static String getMainTag() {
    return MAIN_TAG;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_parcelable);
    myDataObject.setInOnCreate("onCreate");
    receivedFromMessageDisplayActivity();
  }

  /**
   * Leaves the app by going to the phone's home screen.
   *
   * @param view the button that was clicked
   */
  public void exitAppParcelable(View view) {
    mainActivityCalled = "";
    Intent intent = new Intent(Intent.ACTION_MAIN);
    intent.addCategory(Intent.CATEGORY_HOME);
    startActivity(intent);
  }

  /**
   * Clears the message on the screen.
   *
   * @param view the button that was clicked
   */
  public void cleanMainDisplay(View view) {
    mainActivityCalled = "";
    setContentView(R.layout.activity_parcelable);
  }

  /**
   * Starts this activity again.
   *
   * @param view the button that was clicked
   */
  public void toFirstScreen(View view) {
    startActivity(new Intent(this, ParcelableActivity.class));
  }

  /**
   * Starts ParcelableDisplayMessageActivity and sends it the MyDataObject.
   *
   * @param view the button that was clicked
   */
  public void invokeDisplayMessageActivity(View view) {
    Intent intent = new Intent(this, ParcelableDisplayMessageActivity.class);
    intent.putExtra("MyDataObject", myDataObject);
    Log.d(MAIN_TAG, "Intent fired ");
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
    myDataObject.setInOnStart("onStart");
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    myDataObject.setInOnRestart("onRestart");
  }

  @Override
  protected void onResume() {
    super.onResume();
    myDataObject.setInOnResume("onResume");
  }

  @Override
  protected void onPause() {
    super.onPause();
    myDataObject.setInOnPause("onPause");
  }

  @Override
  protected void onStop() {
    super.onStop();
    myDataObject.setInOnStop("onStop");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    myDataObject.setInOnDestroy("onDestroy");
  }

  /** Shows the message sent back from ParcelableDisplayMessageActivity, if there is one. */
  public void receivedFromMessageDisplayActivity() {
    Intent intent = getIntent();
    if (intent != null) {
      if (intent.hasExtra("code.android.abdulrahman.com.paracelableLifeCycle.MESSAGE")) {
        message =
            intent.getStringExtra("code.android.abdulrahman.com.paracelableLifeCycle.MESSAGE");
        Log.d(MAIN_TAG, "Got Intent");
      }
    }
    TextView messageTextView = (TextView) findViewById(R.id.messageTextArea);
    messageTextView.setText(message);
  }
}
