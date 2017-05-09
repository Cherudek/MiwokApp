package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Setting the view to the Activity Numbers
        setContentView(R.layout.activity_numbers);


        //Creating an ArrayList with 10 items
        ArrayList<String> words = new ArrayList<String>();
        words.add("One");
        words.add("Two");
        words.add("Three");
        words.add("Four");
        words.add("Five");
        words.add("Six");
        words.add("Seven");
        words.add("Eight");
        words.add("Nine");
        words.add("Ten");

        //Find the Linear Layout where I want to add the TextViews
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        //creating an index variable for the While Loop
        int index = 0;

        // Creating a While Loop to create as many TextViews as the items in our ArrayList
        while (index < words.size()) {

            //Create a new TextView in the Linear Layout found by the ID
            TextView wordView = new TextView(this);

            //Pass to the child textView the value of the ArrayList index 0 = One
            wordView.setText(words.get(index));

            //Pass the Child view to the Parent View (Linear Layout id rootView)
            rootView.addView(wordView);

            //Increment the index
            index++;

        }



    }
}
