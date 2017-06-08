package com.example.android.TurinTour;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TourDeatailActivity extends AppCompatActivity {

    public static final String Z_16 = "?z=16";
    public static final String GEO = "geo:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour_detail);

        //Get the properties of the Place Object from the intent
        Bundle b = getIntent().getExtras();
        String placeName = b.getString(getString(R.string.name_var));
        String placeAddress = b.getString(getString(R.string.address_var));
        String placeDescription = b.getString(getString(R.string.desc_var));
        int placeImage = b.getInt(getString(R.string.img_var));
        final int placeAudio = b.getInt(getString(R.string.audio_var));
        final String placeSite = b.getString(getString(R.string.site_var));
        final String placeLocation = b.getString(getString(R.string.loc_var));

        //Set the name of the place as the title of the screen
        this.setTitle(placeName);

        //Activate Up Button to enable the navigation back to the MainActivity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Set the image to the ImageView in the activity_place_details.xml
        ImageView imageView = (ImageView) findViewById(R.id.place_image);
        imageView.setImageResource(placeImage);

        //Set the name to the TextView in the activity_place_details.xml
        TextView nameTextView = (TextView) findViewById(R.id.place);
        nameTextView.setText(placeName);

        //Set the address to the TextView in the activity_place_details.xml
        TextView addressTextView = (TextView) findViewById(R.id.address);
        addressTextView.setText(placeAddress);

        //Set the description to the TextView in the activity_place_details.xml
        TextView descriptionTextView = (TextView) findViewById(R.id.description);
        descriptionTextView.setText(placeDescription);

        //Create an intent for the web page of the Place Object
        LinearLayout linkView = (LinearLayout) findViewById(R.id.web_link);
        linkView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //If clicking on the icon, goes to the site of the place
                Uri webpage = Uri.parse(placeSite);
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                if (webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });

        //Create an intent for the web page of the Place Object
        LinearLayout mapView = (LinearLayout) findViewById(R.id.map);
        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //If clicking on the icon, goes to the site of the place
                Uri geoLocation = Uri.parse(GEO + placeLocation + Z_16);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, geoLocation);
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });
    }
}

