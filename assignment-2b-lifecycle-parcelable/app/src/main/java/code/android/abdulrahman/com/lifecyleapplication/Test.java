package code.android.abdulrahman.com.lifecyleapplication;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatActivity;

/** An example of a class that implements Parcelable with an anonymous Creator. */
public class Test extends AppCompatActivity implements Parcelable {

  public static final Creator<Test> CREATOR =
      new Creator<Test>() {
        @Override
        public Test createFromParcel(Parcel in) {
          return new Test(in);
        }

        @Override
        public Test[] newArray(int size) {
          return new Test[size];
        }
      };

  protected Test(Parcel in) {}

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {}
}
