/*
 * MainActivity.java
 *
 * Assignment 1: Hello World Android app.
 * Displays the string "Hello World!" in the center of the screen.
 *
 * Author: John Hashim
 */
package edu.nu.helloworld;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The app's only screen. It inflates {@code activity_main.xml}, whose
 * centered TextView shows the "Hello World!" string resource.
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     *
     * @param savedInstanceState the previously saved state, or {@code null}
     *                           when the activity starts fresh
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Always call the superclass so Android can finish its own setup.
        super.onCreate(savedInstanceState);

        // Set the user interface from res/layout/activity_main.xml.
        setContentView(R.layout.activity_main);
    }
}
