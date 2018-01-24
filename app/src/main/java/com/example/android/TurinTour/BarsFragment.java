package com.example.android.TurinTour;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BarsFragment extends Fragment {


  public BarsFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.tour_list, container, false);

    //Creating an ArrayList with 10 items
    final ArrayList<Tour> tours = new ArrayList<Tour>();

    tours.add(new Tour(getString(R.string.bicerin), getString(R.string.bicerin_address),
        getString(R.string.bicerin_description), R.drawable.bicerin,
        getString(R.string.bicerin_map), getString(R.string.bicerin_web_link)));
    tours.add(new Tour(getString(R.string.fiorio), getString(R.string.fiorio_address),
        getString(R.string.fiorio_description), R.drawable.caffe_fiorio,
        getString(R.string.fiorio_map), getString(R.string.fiorio_web_link)));
    tours.add(new Tour(getString(R.string.mulassano), getString(R.string.mulassano_address),
        getString(R.string.mulassano_description), R.drawable.mulassano,
        getString(R.string.mulassano_map), getString(R.string.mulassano_web_link)));
    tours.add(new Tour(getString(R.string.maddog), getString(R.string.maddog_address),
        getString(R.string.maddog_description), R.drawable.maddog, getString(R.string.maddog_map),
        getString(R.string.maddog_web_link)));
    tours.add(new Tour(getString(R.string.dunque), getString(R.string.dunque_address),
        getString(R.string.dunque_description), R.drawable.dunque, getString(R.string.dunque_map),
        getString(R.string.dunque_web_link)));
    tours.add(new Tour(getString(R.string.torre), getString(R.string.torre_address),
        getString(R.string.torre_description), R.drawable.torre, getString(R.string.torre_map),
        getString(R.string.torre_web_link)));
    tours.add(new Tour(getString(R.string.piolino), getString(R.string.piolino_address),
        getString(R.string.piolino_description), R.drawable.piolino,
        getString(R.string.piolino_map), getString(R.string.piolino_web_link)));
    tours.add(new Tour(getString(R.string.baladin), getString(R.string.baladin_address),
        getString(R.string.baladin_description), R.drawable.baladin,
        getString(R.string.baladin_map), getString(R.string.baladin_web_link)));
    tours.add(new Tour(getString(R.string.amantes), getString(R.string.amantes_address),
        getString(R.string.amantes_description), R.drawable.amantes,
        getString(R.string.amantes_map), getString(R.string.amantes_web_link)));
    tours.add(new Tour(getString(R.string.baratti), getString(R.string.baratti_address),
        getString(R.string.baratti_description), R.drawable.baratti,
        getString(R.string.baratti_map), getString(R.string.baratti_web_link)));

    // Create an {@link TourAdapter}, whose data source is a list of {@link Tour}s. The
    // adapter knows how to create list items for each item in the list.
    TourAdapter adapter = new TourAdapter(getActivity(), tours, R.color.category_phrases);

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
    // Inflate the layout for this fragment
    return rootView;
  }
}
