package code.android.abdulrahman.com.lifecyleapplication;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

/**
 * The "Restoring Activity" example. It saves two values when the activity is stopped and shows
 * them again when the activity is restored.
 */
public class RestoringActivity extends AppCompatActivity {

  TextView textView;
  Calendar currentDateAndTime = Calendar.getInstance();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_restoring);
    textView = findViewById(R.id.r_textView);
    final Button button = findViewById(R.id.restoreButton);
    final Button dateButton = findViewById(R.id.fragmentBtn);

    button.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            // create alert dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(RestoringActivity.this);
            builder.setTitle("Alert Dialog title with Icon");
            builder.setIcon(R.drawable.ic_baseline_airport_shuttle_24);
            builder.show();
            builder.setCancelable(true);
          }
        });

    dateButton.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            DatePickerDialog.OnDateSetListener dateListener =
                new DatePickerDialog.OnDateSetListener() {
                  @Override
                  public void onDateSet(DatePicker view, int year, int month, int day) {
                    currentDateAndTime.set(Calendar.YEAR, year);
                    currentDateAndTime.set(Calendar.MONTH, month);
                    currentDateAndTime.set(Calendar.DAY_OF_MONTH, day);
                  }
                };
            new DatePickerDialog(
                    RestoringActivity.this,
                    dateListener,
                    currentDateAndTime.get(Calendar.YEAR),
                    currentDateAndTime.get(Calendar.MONTH),
                    currentDateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
          }
        });
  }

  @Override
  protected void onPause() {
    super.onPause();
    Log.i("pause", "onpause");
  }

  @Override
  protected void onStop() {
    super.onStop();
    Log.i("onstop", "onstop");
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  protected void onRestart() {
    super.onRestart();
  }

  @Override
  protected void onStart() {
    super.onStart();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    String nameValue = "Abdul-Rahman";
    int accountNumber = 12345;
    outState.putString("name", nameValue);
    outState.putInt("accountNumber", accountNumber);
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    String restoredName = savedInstanceState.getString("name");
    int restoredAccountNumber = savedInstanceState.getInt("accountNumber");
    textView.setText("\n" + "Restoring state \n" + restoredName + " " + restoredAccountNumber);
  }
}
