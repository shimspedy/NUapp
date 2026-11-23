package code.android.abdulrahman.com.lifecyleapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * The "Understanding onCreate()" example. The user fills in a small form, and the Submit button
 * shows the typed values in one line.
 */
public class UnderstandOnCreateActivity extends AppCompatActivity {
  EditText nameView;
  EditText age;
  EditText address;
  EditText course;
  TextView textView;
  Button submit;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_understand_on_create);

    if (savedInstanceState != null) {
      nameView.setText(savedInstanceState.getString("name"));
      age.setText(savedInstanceState.getString("age"));
      address.setText(savedInstanceState.getString("address"));
      course.setText(savedInstanceState.getString("course"));
      textView.setText(savedInstanceState.getString("textView"));
    } else {
      nameView = findViewById(R.id.editText1);
      age = findViewById(R.id.editText2);
      address = findViewById(R.id.editText3);
      course = findViewById(R.id.editText4);
      textView = findViewById(R.id.textView);
      submit = findViewById(R.id.submit_button);
    }

    submit = findViewById(R.id.submit_button);
    submit.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            try {
              String name = nameView.getText().toString();
              int anAge = Integer.parseInt(age.getText().toString());
              String anAddress = address.getText().toString();
              String courseDescription = course.getText().toString();

              textView.setText(
                  name + ",  " + anAge + ", " + courseDescription + ",  " + anAddress);
            } catch (NumberFormatException e) {
              textView.setText(R.string.error_message);
            }
          }
        });
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putString("name", String.valueOf(nameView));
    outState.putString("age", String.valueOf(age));
    outState.putString("address", String.valueOf(address));
    outState.putString("course", String.valueOf(course));
    outState.putString("textView", String.valueOf(textView));
  }

  @Override
  public void onRestoreInstanceState(Bundle mySavedState) {
    super.onRestoreInstanceState(mySavedState);
  }
}
