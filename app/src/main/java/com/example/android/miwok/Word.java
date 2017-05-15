package com.example.android.miwok;

/**
 * Created by Gregorio on 09/05/2017.
 */

public class Word {


    //Constant int assigned to state no image;
    private static final int NO_IMAGE = -1;
    // String values: States of the Object Word
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    // int value for the resource id of the images
    private int mImageID = NO_IMAGE;


    //Constructor to create a Word Object with 2 string inputs
    public Word(String defaultTranslation, String miwokTranslation) {

        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    //Constructor to create a Word Object with 2 string inputs and 1 image input
    public Word(String mMiwokTranslation, String mDefaultTranslation, int mImageID) {
        this.mMiwokTranslation = mMiwokTranslation;
        this.mDefaultTranslation = mDefaultTranslation;
        this.mImageID = mImageID;
    }

    //get Methods for MiwokTranslation
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    //get Methods for DefaultTranslation
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    //get method for the imageID
    public int getmImageID() {
        return mImageID;
    }

    //this method returns a boolean value wheter the Word object has or not an immage
    public boolean hasImage() {
        return mImageID != NO_IMAGE;
    }
}
