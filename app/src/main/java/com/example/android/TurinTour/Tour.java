package com.example.android.TurinTour;

/**
 * Created by Gregorio on 09/05/2017.
 */

public class Tour {


    public static final String M_PLACE_LOCATION = ", mPlaceLocation='";
    public static final String M_PLACE_SITE_URL = ", mPlaceSiteURL='";
    public static final String M_PLACE_IMAGE_RESOURCE_ID = ", mPlaceImageResourceID=";
    public static final String M_PLACE_DESCRIPTION = ", mPlaceDescription='";
    public static final String M_ADDRESS = ", mAddress='";
    public static final String M_PLACE = "mPlace='";
    public static final String TOUR = "Tour{";
    //Constant int assigned to set a no image state to use in the hasImage method;
    private static final int NO_IMAGE = -1;
    // String values: for the place name of the Object Tour
    private String mPlace;

    //String value for the address of the object tour
    private String mAddress;

    //The description of the place
    private String mPlaceDescription;

    //The ID of the image resource of the place
    private int mPlaceImageResourceID;

    //The site URL of the place
    private String mPlaceSiteURL;

    //The location coordinates of the place
    private String mPlaceLocation;


    //Public constructor of the Place object with no audio resource
    public Tour(String name, String address, String description, int imageResourceID, String location, String siteUrl) {
        mPlace = name;
        mAddress = address;
        mPlaceImageResourceID = imageResourceID;
        mPlaceDescription = description;
        mPlaceSiteURL = siteUrl;
        mPlaceLocation = location;
    }

    //get Methods for place name
    public String getPlaceName() {
        return mPlace;
    }

    //get Methods for address
    public String getAddress() {
        return mAddress;
    }

    //get method for the imageID
    public int getImageResourceID() {
        return mPlaceImageResourceID;
    }

    //get method for placxe description
    public String getmPlaceDescription() {
        return mPlaceDescription;
    }

    //get method for site web address
    public String getmPlaceSiteURL() {
        return mPlaceSiteURL;
    }

    //method to get location coordinates
    public String getmPlaceLocation() {
        return mPlaceLocation;
    }



    //this method returns a boolean value to check whether or not the Tour object has  an image state associate with it;
    public boolean hasImage() {
        return getImageResourceID() != NO_IMAGE;
    }

    @Override
    public String toString() {
        return TOUR +
                M_PLACE + mPlace + '\'' +
                M_ADDRESS + mAddress + '\'' +
                M_PLACE_DESCRIPTION + mPlaceDescription + '\'' +
                M_PLACE_IMAGE_RESOURCE_ID + mPlaceImageResourceID +
                M_PLACE_SITE_URL + mPlaceSiteURL + '\'' +
                M_PLACE_LOCATION + mPlaceLocation + '\'' +
                '}';
    }
}
