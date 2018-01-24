package com.example.android.TurinTour;


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


  public MuseumsFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.tour_list, container, false);

    //Creating an ArrayList with 10 items
    final ArrayList<Tour> tours = new ArrayList<Tour>();

    tours.add(new Tour(getString(R.string.cinema), getString(R.string.mole_address),
        getString(R.string.cinema_description), R.drawable.cinemamuseum,
        getString(R.string.mole_map), getString(R.string.mole_web_link)));
    tours.add(new Tour(getString(R.string.egizio), getString(R.string.egizio_address),
        getString(R.string.egizio_description), R.drawable.egizio, getString(R.string.egizio_map),
        getString(R.string.egizio_web)));
    tours.add(new Tour(getString(R.string.gam), getString(R.string.gam_address),
        getString(R.string.gam_description), R.drawable.gam, getString(R.string.gam_map),
        getString(R.string.gam_web)));
    tours.add(new Tour(getString(R.string.rivoli), getString(R.string.rivoli_address),
        getString(R.string.rivoli_description), R.drawable.rivoli, getString(R.string.rivoli_map),
        getString(R.string.rivoli_web)));
    tours.add(new Tour(getString(R.string.GalleriaSabauda), getString(R.string.sabauda_address),
        getString(R.string.sabauda_description), R.drawable.sabauda,
        getString(R.string.sabauda_map), getString(R.string.sabauda_link)));
    tours.add(new Tour(getString(R.string.venaria), getString(R.string.venaria_address),
        getString(R.string.venaria_description), R.drawable.venaria,
        getString(R.string.venaria_map), getString(R.string.venaria_web)));
    tours.add(new Tour(getString(R.string.mao), getString(R.string.mao_address),
        getString(R.string.mao_description), R.drawable.mao, getString(R.string.mao_map),
        getString(R.string.mao_web)));
    tours.add(new Tour(getString(R.string.lombroso), getString(R.string.lombroso_address),
        getString(R.string.lombroso_description), R.drawable.lombroso,
        getString(R.string.lombroso_map), getString(R.string.lombroso_web)));
    tours.add(new Tour(getString(R.string.stupinigi), getString(R.string.stupinigi_address),
        getString(R.string.stupinigi_description), R.drawable.stupinigi,
        getString(R.string.stupinigi_map), getString(R.string.stupinigi_link)));
    tours.add(new Tour(getString(R.string.madama), getString(R.string.madama_address),
        getString(R.string.madama_descfiption), R.drawable.madama2, getString(R.string.madama_map),
        getString(R.string.madama_web)));

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

    //setOnItemClickListener on the listVIew object
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long ID) {

        //method get to find the position clicked in our list view
        Tour tourPosition = tours.get(position);
      }
    });

    // Inflate the layout for this fragment
    return rootView;
  }

  @Override
  public void onStop() {
    super.onStop();

  }
}
