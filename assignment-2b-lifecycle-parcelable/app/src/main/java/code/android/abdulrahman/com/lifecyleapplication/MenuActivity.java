package code.android.abdulrahman.com.lifecyleapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

/** The first screen of the app. It shows a menu of four buttons, one for each example. */
public class MenuActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setTitle("Chapter 5: Android Life Cycle Example");
    setContentView(R.layout.activity_menu);
  }

  /**
   * Opens the "Understanding onCreate()" example. Called when button 1 is clicked.
   *
   * @param view the button that was clicked
   */
  public void toUnderstandOnCreate(View view) {
    Intent toUnderstandOnCreate = new Intent(this, UnderstandOnCreateActivity.class);
    startActivity(toUnderstandOnCreate);
  }

  /**
   * Opens the life cycle example. Called when button 2 is clicked.
   *
   * @param view the button that was clicked
   */
  public void toLifeCycle(View view) {
    Intent toLifeCycle = new Intent(this, MainActivity.class);
    startActivity(toLifeCycle);
  }

  /**
   * Opens the Parcelable example. Called when button 3 is clicked.
   *
   * @param view the button that was clicked
   */
  public void toParcellable(View view) {
    Intent toParcellable = new Intent(this, ParcelableActivity.class);
    startActivity(toParcellable);
  }

  /**
   * Opens the restoring activity example. Called when button 4 is clicked.
   *
   * @param view the button that was clicked
   */
  public void toRestorActivity(View view) {
    Intent restoringActivity = new Intent(this, RestoringActivity.class);
    startActivity(restoringActivity);
  }
}
