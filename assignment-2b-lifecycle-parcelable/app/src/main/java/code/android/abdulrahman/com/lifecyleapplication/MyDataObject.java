package code.android.abdulrahman.com.lifecyleapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A data object that can be passed between activities inside an intent. It remembers which life
 * cycle methods of ParcelableActivity have been called.
 */
public class MyDataObject implements Parcelable {

  public static final MyCreator CREATOR = new MyCreator();

  String inOnCreate = "";
  String inOnStart = "";
  String inOnRestart = "";
  String inOnResume = "";
  String inOnPause = "";
  String inOnStop = "";
  String inOnDestroy = "";
  int intValue;
  double doubleValue;

  /**
   * Creates a data object with two example values.
   *
   * @param intValue an example whole number
   * @param doubleValue an example decimal number
   */
  public MyDataObject(int intValue, double doubleValue) {
    this.intValue = intValue;
    this.doubleValue = doubleValue;
  }

  /**
   * Creates a data object from a Parcel. The fields are read in the same order that
   * {@link #writeToParcel} wrote them.
   *
   * @param source the Parcel to read the field values from
   */
  public MyDataObject(Parcel source) {
    this.inOnCreate = source.readString();
    this.inOnStart = source.readString();
    this.inOnRestart = source.readString();
    this.inOnResume = source.readString();
    this.inOnPause = source.readString();
    this.inOnStop = source.readString();
    this.inOnDestroy = source.readString();
    this.intValue = source.readInt();
    this.doubleValue = source.readDouble();
  }

  @Override
  public int describeContents() {
    return 0;
  }

  /**
   * Writes this object's data to a Parcel. All the field values that need to be passed between
   * activities are put inside the Parcel object.
   */
  @Override
  public void writeToParcel(Parcel destination, int flags) {
    destination.writeString(inOnCreate);
    destination.writeString(inOnStart);
    destination.writeString(inOnRestart);
    destination.writeString(inOnResume);
    destination.writeString(inOnPause);
    destination.writeString(inOnStop);
    destination.writeString(inOnDestroy);
    destination.writeInt(intValue);
    destination.writeDouble(doubleValue);
  }

  public void setIntValue(int intValue) {
    this.intValue = intValue;
  }

  public void setDoubleValue(double doubleValue) {
    this.doubleValue = doubleValue;
  }

  public String getInOnCreate() {
    return inOnCreate;
  }

  public void setInOnCreate(String inOnCreate) {
    this.inOnCreate = inOnCreate;
  }

  public String getInOnStart() {
    return inOnStart;
  }

  public void setInOnStart(String inOnStart) {
    this.inOnStart = inOnStart;
  }

  public String getInOnRestart() {
    return inOnRestart;
  }

  public void setInOnRestart(String inOnRestart) {
    this.inOnRestart = inOnRestart;
  }

  public String getInOnResume() {
    return inOnResume;
  }

  public void setInOnResume(String inOnResume) {
    this.inOnResume = inOnResume;
  }

  public String getInOnPause() {
    return inOnPause;
  }

  public void setInOnPause(String inOnPause) {
    this.inOnPause = inOnPause;
  }

  public String getInOnStop() {
    return inOnStop;
  }

  public void setInOnStop(String inOnStop) {
    this.inOnStop = inOnStop;
  }

  public String getInOnDestroy() {
    return inOnDestroy;
  }

  public void setInOnDestroy(String inOnDestroy) {
    this.inOnDestroy = inOnDestroy;
  }

  /** Returns one line for each life cycle method that has been called, in life cycle order. */
  @Override
  public String toString() {
    String pre = "\n from " + ParcelableActivity.getMainTag() + " ";
    String post = " method invoked ";

    String lifeCycleMethodInvoked = "";

    if (inOnCreate != null && inOnCreate.compareTo("") != 0) {
      lifeCycleMethodInvoked = lifeCycleMethodInvoked + pre + inOnCreate + post;
    }
    if (inOnStart != null && inOnStart.compareTo("") != 0) {
      lifeCycleMethodInvoked = lifeCycleMethodInvoked + pre + inOnStart + post;
    }
    if (inOnRestart != null && inOnRestart.compareTo("") != 0) {
      lifeCycleMethodInvoked = lifeCycleMethodInvoked + pre + inOnRestart + post;
    }
    if (inOnResume != null && inOnResume.compareTo("") != 0) {
      lifeCycleMethodInvoked = lifeCycleMethodInvoked + pre + inOnResume + post;
    }
    if (inOnPause != null && inOnPause.compareTo("") != 0) {
      lifeCycleMethodInvoked = lifeCycleMethodInvoked + pre + inOnPause + post;
    }
    if (inOnStop != null && inOnStop.compareTo("") != 0) {
      lifeCycleMethodInvoked = lifeCycleMethodInvoked + pre + inOnStop + post;
    }
    if (inOnDestroy != null && inOnDestroy.compareTo("") != 0) {
      lifeCycleMethodInvoked = lifeCycleMethodInvoked + pre + inOnDestroy + post;
    }
    return lifeCycleMethodInvoked;
  }
}
