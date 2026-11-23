/*
 * MainActivity.java
 *
 * Assignment 2a: tiny calculator Android application.
 * Shows two number boxes and four buttons. When a button is clicked, the two
 * numbers are added, subtracted, multiplied, or divided and the answer is
 * shown below the buttons.
 *
 * Author: John Hashim
 */

package edu.nu.helloworld;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

/** The calculator screen, where the user enters two numbers and picks an operation. */
public class MainActivity extends AppCompatActivity {

  private EditText firstNumberInput;
  private EditText secondNumberInput;
  private TextView operatorView;
  private TextView resultView;

  /**
   * Called when the activity is first created. Sets up the screen and tells
   * each button which operation to run when it is clicked.
   *
   * @param savedInstanceState the previously saved state, or {@code null}
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Show the app name in the middle of the action bar.
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
      actionBar.setCustomView(R.layout.action_bar_title);
    }

    // Find the views from the layout so the code can use them.
    firstNumberInput = findViewById(R.id.edit_first_number);
    secondNumberInput = findViewById(R.id.edit_second_number);
    operatorView = findViewById(R.id.text_operator);
    resultView = findViewById(R.id.text_result);

    Button addButton = findViewById(R.id.button_add);
    Button subtractButton = findViewById(R.id.button_subtract);
    Button multiplyButton = findViewById(R.id.button_multiply);
    Button divideButton = findViewById(R.id.button_divide);

    // Each button calls calculate() with its own operator.
    addButton.setOnClickListener(view -> calculate('+'));
    subtractButton.setOnClickListener(view -> calculate('-'));
    multiplyButton.setOnClickListener(view -> calculate('x'));
    divideButton.setOnClickListener(view -> calculate('/'));
  }

  /**
   * Reads the two numbers, does the math for the given operator, and shows
   * the answer. Shows a message instead if a number is missing or the user
   * tries to divide by zero.
   *
   * @param operator the operation to do: '+', '-', 'x', or '/'
   */
  private void calculate(char operator) {
    // Show the operator between the two numbers.
    operatorView.setText(String.valueOf(operator));

    String firstText = firstNumberInput.getText().toString();
    String secondText = secondNumberInput.getText().toString();

    // Turn the typed text into numbers. This fails if a box is empty.
    double firstNumber;
    double secondNumber;
    try {
      firstNumber = Double.parseDouble(firstText);
      secondNumber = Double.parseDouble(secondText);
    } catch (NumberFormatException e) {
      resultView.setText(R.string.error_invalid_number);
      return;
    }

    double result;
    switch (operator) {
      case '+':
        result = firstNumber + secondNumber;
        break;
      case '-':
        result = firstNumber - secondNumber;
        break;
      case 'x':
        result = firstNumber * secondNumber;
        break;
      case '/':
        // Dividing by zero has no answer, so show a message instead.
        if (secondNumber == 0) {
          resultView.setText(R.string.error_divide_by_zero);
          return;
        }
        result = firstNumber / secondNumber;
        break;
      default:
        return;
    }

    resultView.setText(String.valueOf(result));
  }
}
