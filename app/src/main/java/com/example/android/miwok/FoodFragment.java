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


public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tour_list, container, false);

        //Creating an ArrayList with 10 items
        final ArrayList<Tour> tours = new ArrayList<Tour>();

        tours.add(new Tour(getString(R.string.ranzini), getString(R.string.ranzini_address), getString(R.string.ranzini_description), R.drawable.ranzini, getString(R.string.ranzini_map), getString(R.string.ranzini_web_link)));
        tours.add(new Tour(getString(R.string.platti), getString(R.string.platti_address), getString(R.string.platti_description), R.drawable.platti, getString(R.string.platti_map), getString(R.string.platti_web_link)));
        tours.add(new Tour(getString(R.string.gelateria), getString(R.string.gelateria_address), getString(R.string.gelateria_description), R.drawable.gelateria2, getString(R.string.gelateria_map), getString(R.string.gelateria_web_link)));
        tours.add(new Tour(getString(R.string.soul), getString(R.string.soul_address), getString(R.string.soul_description), R.drawable.soul, getString(R.string.soul_map), getString(R.string.soul_web_link)));
        tours.add(new Tour(getString(R.string.cianci), getString(R.string.cianci_address), getString(R.string.cianci_description), R.drawable.cianci, getString(R.string.cianci_map), getString(R.string.cianci_web_link)));
        tours.add(new Tour(getString(R.string.porto), getString(R.string.porto_address), getString(R.string.porto_description), R.drawable.porto, getString(R.string.porto_map), getString(R.string.porto_web_link)));
        tours.add(new Tour(getString(R.string.eataly), getString(R.string.eataly_address), getString(R.string.eataly_description), R.drawable.eataly, getString(R.string.eataly_map), getString(R.string.eataly_web_link)));
        tours.add(new Tour(getString(R.string.primavera), getString(R.string.primavera_address), getString(R.string.primavera_description), R.drawable.primavera, getString(R.string.primavera_map), getString(R.string.primavera_web_link)));
        tours.add(new Tour(getString(R.string.ala), getString(R.string.ala_address), getString(R.string.ala_description), R.drawable.ala, getString(R.string.ala_map), getString(R.string.ala_web)));
        tours.add(new Tour(getString(R.string.barricata), getString(R.string.barricata_address), getString(R.string.barricata_description), R.drawable.barricata, getString(R.string.barricata_map), getString(R.string.barricata_web)));
        tours.add(new Tour(getString(R.string.pastis), getString(R.string.pastis_address), getString(R.string.pastis_description), R.drawable.pastis, getString(R.string.pastis_map), getString(R.string.pastis_web)));


        // Create an {@link TourAdapter}, whose data source is a list of {@link Tour}s. The
        // adapter knows how to create list items for each item in the list.
        TourAdapter adapter = new TourAdapter(getActivity(), tours, R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // tour_list.xml file.
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);

        // Make the {@link ListView} use the {@link TourAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Tour} in the list.
        listView.setAdapter(adapter);

        //setOnItemClickListener on the listVIew object
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long ID) {

                //method get to find the position clicked in our list view
                Tour tourPosition = tours.get(position);

            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();

    }
}
