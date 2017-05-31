package com.example.android.miwok;

/**
 * Created by Gregorio on 09/05/2017.
 */

public class Tour {


    //Constant int assigned to set a no image state to use in the hasImage method;
    private static final int NO_IMAGE = -1;

    // String values: 2 x states of the Object Tour
    private String mPlace;
    private String mAddress;

    // int value to set the resource id of the images
    private int mImageID = NO_IMAGE;


    // int value to set a play icon
    private int mPlayIcon;

    // int value to set a sound input
    private int mPlaySoundID;


    //Constructor to create a Tour Object with 2 string inputs and 1 sound input
    public Tour(String mPlace, String mAddress, int mPlaySoundID) {
        this.mPlace = mPlace;
        this.mAddress = mAddress;
        this.mPlaySoundID = mPlaySoundID;
    }

    //Constructor to create a Tour Object with 4 inputs, 2 strings, 2 image, 1 sound
    public Tour(String mPlace, String mAddress, int mImageID, int mPlaySoundID) {
        this.mPlace = mPlace;
        this.mAddress = mAddress;
        this.mImageID = mImageID;
        this.mPlayIcon = mPlayIcon;
        this.mPlaySoundID = mPlaySoundID;
    }

    //get Methods for MiwokTranslation
    public String getPlace() {
        return mPlace;
    }

    //get Methods for DefaultTranslation
    public String getAddress() {
        return mAddress;
    }

    //get method for the imageID
    public int getmImageID() {
        return mImageID;
    }

    //get method for the icon ID
    public int getmPlayIcon() {
        return mPlayIcon;
    }

    //get method for the soundID
    public int getmPlaySoundID() {
        return mPlaySoundID;
    }

    //this method returns a boolean value to check whether or not the Tour object has  an image state associate with it;
    public boolean hasImage() {
        return mImageID != NO_IMAGE;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "mPlace='" + mPlace + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mImageID=" + mImageID +
                ", mPlaySoundID=" + mPlaySoundID +
                '}';
    }
}
