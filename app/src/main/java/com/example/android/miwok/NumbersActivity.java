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


        setContentView(R.layout.activity_numbers);

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

        //Find the Linear Layout where I want to add the TextView

        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        //Create a new TextView in the Linear Layout found by the ID
        TextView wordView = new TextView(this);
        //Pass to the child textView the value of the ArrayList index 0 = One
        wordView.setText(words.get(0));
        //Pass the Child view to the Parent View (Linear Layout id rootView)
        rootView.addView(wordView);

        //Create a new TextView in the Linear Layout found by the ID
        TextView wordView1 = new TextView(this);
        //Pass to the child textView the value of the ArrayList index 1 = Two
        wordView1.setText(words.get(1));
        //Pass the Child view to the Parent View (Linear Layout id rootView)
        rootView.addView(wordView1);

        //Create a new TextView in the Linear Layout found by the ID
        TextView wordView2 = new TextView(this);
        //Pass to the child textView the value of the ArrayList index 2 = three
        wordView2.setText(words.get(2));
        //Pass the Child view to the Parent View (Linear Layout id rootView)
        rootView.addView(wordView2);

        //Create a new TextView in the Linear Layout found by the ID
        TextView wordView3 = new TextView(this);
        //Pass to the child textView the value of the ArrayList index 3 = Four
        wordView3.setText(words.get(3));
        //Pass the Child view to the Parent View (Linear Layout id rootView)
        rootView.addView(wordView3);

        //Create a new TextView in the Linear Layout found by the ID
        TextView wordView4 = new TextView(this);
        //Pass to the child textView the value of the ArrayList index 4 = Five
        wordView4.setText(words.get(4));
        //Pass the Child view to the Parent View (Linear Layout id rootView)
        rootView.addView(wordView4);



    }
}
