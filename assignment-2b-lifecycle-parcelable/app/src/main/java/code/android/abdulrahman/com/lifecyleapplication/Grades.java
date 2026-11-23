package code.android.abdulrahman.com.lifecyleapplication;

/** A small example class that holds a number and a text value. */
public class Grades {
  int x;
  String y;

  protected Grades() {}

  @Override
  public String toString() {
    return (x + " " + y);
  }
}
