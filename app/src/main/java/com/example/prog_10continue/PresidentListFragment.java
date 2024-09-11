package com.example.prog_10continue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

public class PresidentListFragment extends Fragment {

    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_president_list, container, false);
        listView = view.findViewById(R.id.list_presidents);

        // Example data
        String[] presidents = {"Dr. Rajendra Prasad", "Dr. Sarvepalli Radhakrishnan", "Dr. Zakir Husain"};

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, presidents);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedPresident = (String) listView.getItemAtPosition(position);
                ((PresidentActivity) getActivity()).updatePresidentDetails(selectedPresident);
            }
        });

        return view;
    }
}
