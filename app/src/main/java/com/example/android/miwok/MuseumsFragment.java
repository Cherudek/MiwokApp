package com.example.android.miwok;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MuseumsFragment extends Fragment {

    /**
     * Handles playback of all the sound files
     */
    private MediaPlayer mMediaPlayer;

    /**
     * Handles audio focus when playing a sound file
     */
    private AudioManager mAudioManager;

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };


    public MuseumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        //Creating an ArrayList with 10 items
        final ArrayList<Tour> tours = new ArrayList<Tour>();

        tours.add(new Tour(getString(R.string.cinema), getString(R.string.mole_address), getString(R.string.cinema_description), R.drawable.cinemamuseum, getString(R.string.mole_map), getString(R.string.mole_web_link)));
        tours.add(new Tour(getString(R.string.egizio), getString(R.string.egizio_address), getString(R.string.egizio_description), R.drawable.egizio, getString(R.string.egizio_map), getString(R.string.egizio_web)));
        tours.add(new Tour(getString(R.string.gam), getString(R.string.gam_address), getString(R.string.gam_description), R.drawable.gam, getString(R.string.gam_map), getString(R.string.gam_web)));
        tours.add(new Tour(getString(R.string.rivoli), getString(R.string.rivoli_address), getString(R.string.rivoli_description), R.drawable.rivoli, getString(R.string.rivoli_map), getString(R.string.rivoli_web)));
        tours.add(new Tour(getString(R.string.duomo), getString(R.string.duomo_address), getString(R.string.duomo_description), R.drawable.duomo, getString(R.string.duomo_map), getString(R.string.duomo_web_link)));
        tours.add(new Tour(getString(R.string.consolata), getString(R.string.consolata_address), getString(R.string.superga_description), R.drawable.consolata01, getString(R.string.superga_description), getString(R.string.superga_description)));
        tours.add(new Tour(getString(R.string.carignano), getString(R.string.carignano_address), getString(R.string.carignano_description), R.drawable.palazzo_carignano, getString(R.string.carignano_map), getString(R.string.carignano_web_link)));
        tours.add(new Tour(getString(R.string.regina), getString(R.string.regina_address), getString(R.string.regina_description), R.drawable.regina3, getString(R.string.regina_map), getString(R.string.regina_web_link)));
        tours.add(new Tour(getString(R.string.valentino), getString(R.string.valentino_address), getString(R.string.valentino_description), R.drawable.parco_del_valentino, getString(R.string.valentino_map), getString(R.string.valentino_web_link)));
        tours.add(new Tour(getString(R.string.reale), getString(R.string.reale_address), getString(R.string.reale_description), R.drawable.piazza_castello, getString(R.string.reale_map), getString(R.string.reale_web_link)));


        // Create an {@link TourAdapter}, whose data source is a list of {@link Tour}s. The
        // adapter knows how to create list items for each item in the list.
        TourAdapter adapter = new TourAdapter(getActivity(), tours, R.color.category_family);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // tour_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        // Make the {@link ListView} use the {@link TourAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Tour} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Get the {@link Tour} object at the given position the user clicked on
                Tour tourPosition = tours.get(position);

            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }


}
