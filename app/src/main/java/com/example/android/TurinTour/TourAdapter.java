package com.example.android.TurinTour;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gregorio on 10/05/2017.
 */


public class TourAdapter extends ArrayAdapter<Tour> {
    private static final String LOG_TAG = TourAdapter.class.getSimpleName();

    //Color Background Variable to assign to each activity
    private int mColorBackgroundActivityID;

    private Context context = getContext();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout tour_list.xml, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param tours   A List of word objects to display in a list
     */

    //constructor to include a color variable for each activity
    public TourAdapter(Activity context, ArrayList<Tour> tours, int ColorBackgroundActivityID) {
        super(context, 0, tours);
        mColorBackgroundActivityID = ColorBackgroundActivityID;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        // Get the {@link Place} object located at this position in the list
        Tour currentTour = getItem(position);

        //Get the object's properties
        String name = currentTour.getPlaceName();
        String address = currentTour.getAddress();
        String description = currentTour.getmPlaceDescription();
        int image = currentTour.getImageResourceID();
        String siteURL = currentTour.getmPlaceSiteURL();
        String location = currentTour.getmPlaceLocation();


        // Get the {@link Tour} object located at this position in the list
        currentTour = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID list item 1
        TextView placeTextView = (TextView) listItemView.findViewById(R.id.list_item1);

        // Get the version name from the current Tour object and
        // set this text on the TextView
        placeTextView.setText(currentTour.getPlaceName());

        // Find the TextView in the list_item.xml layout with the ID list item 2
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.list_item2);

        // Get the version number from the current Tour object and
        // set this text on the TextView
        addressTextView.setText(currentTour.getAddress());

        // Find the ImageView in the list_item.xml layout with the ID version_number
        ImageView imageID = (ImageView) listItemView.findViewById(R.id.image);


        // if else statement whether we want to show the imageView in the list_item
        // if an image is available or to remove the image View if no image is available
        if (currentTour.hasImage()) {
            // Get the image ID number from the current Tour object and
            // set this image on the  ImageView
            imageID.setImageResource(currentTour.getImageResourceID());
            // Make sure the image is VISIBLE
            imageID.setVisibility(View.VISIBLE);
        } else {
            //if there is no image hide the image view
            imageID.setVisibility(View.GONE);
        }

        //Set the background color for the list view with play button
        View textContainer = listItemView.findViewById(R.id.text_container);

        //Set the color for the sub text view
        View textContainer2 = listItemView.findViewById(R.id.text_play_container);

        //Find the colors the resource ID maps to.
        int color = ContextCompat.getColor(getContext(), mColorBackgroundActivityID);

        //Set the background color of the text Container View
        textContainer.setBackgroundColor(color);

        //Set the background color of the text Container View
        textContainer2.setBackgroundColor(color);

        //Create an implicit intent to display the detailed place information if the user taps on the list item
        final Intent itemIntent = new Intent(context, TourDeatailActivity.class);

        //Put the properties of the Object to the intent
        itemIntent.putExtra(context.getString(R.string.name_var), name);
        itemIntent.putExtra(context.getString(R.string.address_var), address);
        itemIntent.putExtra(context.getString(R.string.desc_var), description);
        itemIntent.putExtra(context.getString(R.string.img_var), image);
        itemIntent.putExtra(context.getString(R.string.site_var), siteURL);
        itemIntent.putExtra(context.getString(R.string.loc_var), location);


        //Start the intent if the user taps on the list item
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(itemIntent);
            }
        });
        // Return the whole list item layout (containing 2 TextViews and an ImageView if present)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
