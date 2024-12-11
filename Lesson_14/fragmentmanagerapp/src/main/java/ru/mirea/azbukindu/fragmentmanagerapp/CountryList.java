package ru.mirea.azbukindu.fragmentmanagerapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountryList extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;

    public CountryList() {

    }

    public static CountryList newInstance(String param1) {
        CountryList fragment = new CountryList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    private ListView listView;
    private Map<String, String> countries;

    private ShareViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_country_list, container, false);
        listView = view.findViewById(R.id.countries);

        countries = new HashMap<>();
        countries.put("South Korea", "A technologically advanced country in East Asia, known for its K-pop music and delicious cuisine.");
        countries.put("Egypt", "An ancient civilization in North Africa, home to the pyramids and the Sphinx.");
        countries.put("Argentina", "A South American country famous for its tango dance, passionate football fans, and stunning landscapes.");
        countries.put("New Zealand", "An island nation in the southwestern Pacific Ocean, known for its breathtaking scenery and adventure tourism.");
        countries.put("Nigeria", "The most populous country in Africa, with a rich cultural heritage and diverse landscapes.");
        countries.put("Greece", "The birthplace of democracy and Western civilization, known for its ancient ruins and beautiful islands.");
        countries.put("Netherlands", "A European country famous for its windmills, canals, and tulip fields.");
        countries.put("Switzerland", "A landlocked country in central Europe, known for its stunning alpine scenery, chocolate, and watches.");
        countries.put("Portugal", "A country in southwestern Europe, known for its beautiful beaches, historic cities, and delicious seafood.");
        countries.put("Sweden", "A Scandinavian country known for its minimalist design, innovative technology, and stunning natural beauty.");

        viewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);

        List<String> names = new ArrayList<>(countries.keySet());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            String selectedCountry = names.get(position);
            viewModel.setSomeValue(countries.get(selectedCountry));
        });

        return view;
    }
}