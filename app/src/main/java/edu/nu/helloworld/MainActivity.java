/*
 * MainActivity.java
 *
 * Assignment 1b: SendToScreen Android application.
 * Shows a text box and a Send button. When the button is clicked, the typed
 * message is passed to MessageActivity, which displays it in a TextView.
 *
 * Author: John Hashim
 */

package edu.nu.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

/** The main screen, where the user enters a message and sends it. */
public class MainActivity extends AppCompatActivity {

  /** Intent extra key used to pass the message to {@link MessageActivity}. */
  public static final String EXTRA_MESSAGE = "edu.nu.helloworld.MESSAGE";

  private EditText messageInput;

  /**
   * Called when the activity is first created. Inflates the layout and wires
   * up the Send button.
   *
   * @param savedInstanceState the previously saved state, or {@code null}
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    messageInput = findViewById(R.id.edit_message);
    Button sendButton = findViewById(R.id.button_send);
    sendButton.setOnClickListener(view -> sendMessage());
  }

  /**
   * Reads the message from the text box and starts {@link MessageActivity} to
   * display it. If the box is empty, shows an error instead.
   */
  private void sendMessage() {
    String message = messageInput.getText().toString().trim();
    if (TextUtils.isEmpty(message)) {
      messageInput.setError(getString(R.string.error_empty_message));
      return;
    }

    Intent intent = new Intent(this, MessageActivity.class);
    intent.putExtra(EXTRA_MESSAGE, message);
    startActivity(intent);
  }
}
