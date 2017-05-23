package com.example.android.miwok;

import android.app.Activity;
import android.provider.UserDictionary;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gregorio on 10/05/2017.
 */


public class WordAdapter extends ArrayAdapter<Word> {
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    //Color Background Variable to assign to each activity
    private int mColorBackgroundActivityID;

    //Sound Variable to play to each object
    private int mSoundActivityID;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout word_list.xml, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param words   A List of word objects to display in a list
     */


    public WordAdapter(Activity context, ArrayList<Word> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
    }


    //Second constructor to include a color variable for each activity
    public WordAdapter(Activity context, ArrayList<Word> words, int ColorBackgroundActivityID) {
        super(context, 0, words);
        mColorBackgroundActivityID = ColorBackgroundActivityID;

    }

    //Third constructor to include a sound variable to each activity
    public WordAdapter(Activity context, ArrayList<Word> words, int ColorBackgroundActivityID, int SoundActivityID) {
        super(context, 0, words);
        mColorBackgroundActivityID = ColorBackgroundActivityID;
        mSoundActivityID = SoundActivityID;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID list item 1
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.list_item1);

        // Get the version name from the current Word object and
        // set this text on the miwok TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID list item 2
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.list_item2);

        // Get the version number from the current Word object and
        // set this text on the default translation TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID version_number
        ImageView imageID = (ImageView) listItemView.findViewById(R.id.image);


        // if else statement whether we want to show the imageView in the lis_item
        // if an image is available or to remove the image View if no image is available
        if (currentWord.hasImage()) {
            // Get the image ID number from the current Word object and
            // set this image on the  ImageView
            imageID.setImageResource(currentWord.getmImageID());
            // Make sure the image is VISIBLE
            imageID.setVisibility(View.VISIBLE);
        } else {
            //if there is no image hide the image view
            imageID.setVisibility(View.GONE);
        }

        //Set the background color for the list view
        View textContainer = listItemView.findViewById(R.id.text_container);

        //Find the colors the resource ID maps to.
        int color = ContextCompat.getColor(getContext(), mColorBackgroundActivityID);

        //Set the background color of the text Container View
        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews and an ImageView if present)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
