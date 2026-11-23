package code.android.abdulrahman.com.lifecyleapplication;

import android.os.Parcel;
import android.os.Parcelable;

/** Creates MyDataObject objects from a Parcel. Android needs this for every Parcelable class. */
public class MyCreator implements Parcelable.Creator<MyDataObject> {

  @Override
  public MyDataObject createFromParcel(Parcel source) {
    return new MyDataObject(source);
  }

  @Override
  public MyDataObject[] newArray(int size) {
    return new MyDataObject[size];
  }
}
