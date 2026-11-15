/*
 * MessageActivity.java
 *
 * Assignment 1b: SendToScreen Android application.
 * Displays the message sent from MainActivity in a TextView and offers a
 * button to return to the main screen.
 *
 * Author: John Hashim
 */

package edu.nu.helloworld;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/** The second screen, which shows the user's message. */
public class MessageActivity extends AppCompatActivity {

  /**
   * Called when the activity is first created. Reads the message from the
   * starting intent and shows it in the TextView.
   *
   * @param savedInstanceState the previously saved state, or {@code null}
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_message);

    // Get the message passed in by MainActivity and display it.
    String message = getIntent().getStringExtra(MainActivity.EXTRA_MESSAGE);
    TextView messageView = findViewById(R.id.text_message);
    messageView.setText(message);

    // Closing this activity returns the user to MainActivity.
    Button backButton = findViewById(R.id.button_back);
    backButton.setOnClickListener(view -> finish());
  }
}
