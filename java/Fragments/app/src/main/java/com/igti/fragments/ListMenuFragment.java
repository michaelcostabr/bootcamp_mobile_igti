package com.igti.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListMenuFragment extends ListFragment {
    String[] modelo = new String[] { "Gol","Onix","HB20","A3","Palio","Logan" };
    String[] marca = new String[]{"Volksvagem","Chevrolet","Hyunday","Audi","Fiat","Renault"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.listitens_info, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, modelo);
        setListAdapter(adapter);
        return view;
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        DetailsFragment txt = (DetailsFragment)getFragmentManager().findFragmentById(R.id.fragment2);
        txt.change("Name: "+ modelo[position],"Location : "+ marca[position]);
        getListView().setSelector(android.R.color.holo_blue_dark);
    }
}