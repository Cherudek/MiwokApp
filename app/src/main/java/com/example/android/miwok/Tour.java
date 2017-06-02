package com.example.android.miwok;

/**
 * Created by Gregorio on 09/05/2017.
 */

public class Tour {


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

    //Constant for no audio
    private int NO_AUDIO_RESOURCE = -1;

    //The ID of the audio resourse of the place
    private int mPlaceAudioResourceID = NO_AUDIO_RESOURCE;

    //The site URL of the place
    private String mPlaceSiteURL;

    //The location coordinates of the place
    private String mPlaceLocation;

    // int value to set a play icon
    private int mPlayIcon;

    // int value to set a sound input
    private int mPlaySoundID;


    //Public constructor of the Place object with no audio resource
    public Tour(String name, String address, String description, int imageResourceID, String siteUrl, String location) {
        mPlace = name;
        mAddress = address;
        mPlaceImageResourceID = imageResourceID;
        mPlaceDescription = description;
        mPlaceSiteURL = siteUrl;
        mPlaceLocation = location;
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
    public int getImageResourceID() {
        return mPlaceImageResourceID;
    }

    public int getmPlaceAudioResourceID() {
        return mPlaceAudioResourceID;
    }

    public void setmPlaceAudioResourceID(int mPlaceAudioResourceID) {
        this.mPlaceAudioResourceID = mPlaceAudioResourceID;
    }

    //this method returns a boolean value to check whether or not the Tour object has  an image state associate with it;
    public boolean hasImage() {
        return getImageResourceID() != NO_IMAGE;
    }

    //get the address of our object
    public String getmAddress() {
        return mAddress;
    }

    //set method for the address state
    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    //get method for the icon ID
    public int getmPlayIcon() {
        return mPlayIcon;
    }

    //get method for the soundID
    public int getmPlaySoundID() {
        return mPlaySoundID;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "mPlace='" + mPlace + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mPlaceDescription='" + mPlaceDescription + '\'' +
                ", mPlaceImageResourceID=" + mPlaceImageResourceID +
                ", NO_AUDIO_RESOURCE=" + NO_AUDIO_RESOURCE +
                ", mPlaceAudioResourceID=" + mPlaceAudioResourceID +
                ", mPlaceSiteURL='" + mPlaceSiteURL + '\'' +
                ", mPlaceLocation='" + mPlaceLocation + '\'' +
                ", mPlayIcon=" + mPlayIcon +
                ", mPlaySoundID=" + mPlaySoundID +
                '}';
    }
}
