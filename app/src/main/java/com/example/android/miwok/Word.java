package com.example.android.miwok;

/**
 * Created by Gregorio on 09/05/2017.
 */

public class Word {


    //Constant int assigned to set a no image state to use in the hasImage method;
    private static final int NO_IMAGE = -1;

    // String values: 2 x states of the Object Word
    private String mMiwokTranslation;
    private String mDefaultTranslation;

    // int value to set the resource id of the images
    private int mImageID = NO_IMAGE;

    // int value to set a sound input
    private int mPlaySoundID;


    //Constructor to create a Word Object with 2 string inputs
    public Word(String defaultTranslation, String miwokTranslation) {

        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
    }

    //Constructor to create a Word Object with 2 string inputs and 1 image input
    public Word(String mMiwokTranslation, String mDefaultTranslation, int mPlaySoundID) {
        this.mMiwokTranslation = mMiwokTranslation;
        this.mDefaultTranslation = mDefaultTranslation;
        this.mPlaySoundID = mPlaySoundID;
    }

    //Constructor to create a Word Object with 4 inputs, 2 strings, 1 image, 1 sound
    public Word(String mMiwokTranslation, String mDefaultTranslation, int mImageID, int mPlaySoundID) {
        this.mMiwokTranslation = mMiwokTranslation;
        this.mDefaultTranslation = mDefaultTranslation;
        this.mImageID = mImageID;
        this.mPlaySoundID = mPlaySoundID;
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

    //get method for the soundID
    public int getmPlaySoundID() {
        return mPlaySoundID;
    }

    //this method returns a boolean value to check whether or not the Word object has  an image state associate with it;
    public boolean hasImage() {
        return mImageID != NO_IMAGE;
    }
}
