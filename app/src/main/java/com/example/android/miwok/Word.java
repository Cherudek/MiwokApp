package com.example.android.miwok;

/**
 * Created by Gregorio on 09/05/2017.
 */

public class Word {


    // String values: States of the Object Word
    private String mMiwokTranslation;
    private String mDefaultTraslation;
    // int value for the resource id of the images
    private int mImageID;


    //Constructor to create a Word Object
    public Word(String defaultTranslation, String miwokTranslation) {

        mMiwokTranslation = miwokTranslation;
        mDefaultTraslation = defaultTranslation;
    }

    //get Methods for MiwokTranslation
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    //get Methods for DefaultTranslation
    public String getDefaultTraslation() {

        return mDefaultTraslation;
    }

    //get method for the imageID
    public int getmImageID() {
        return mImageID;
    }
}
