package ua.cm.cmproj;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONException;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DailyListFragment extends Fragment {

    public DailyListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.activity_main, container,
                false);

        ArrayAdapter<String> mealsListAdapter = new ArrayAdapter<String>(
                getActivity(), // The current context (this activity)
                R.layout.list_item_meal_days, // The name of the layout ID.
                R.id.textDayMeals, // The ID of the textview to populate.
                new ArrayList<String>());
        // Get a reference to the ListView, and attach this adapter to it.
        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        listView.setAdapter(mealsListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDetailsForEntry( parent.getAdapter().getItem(position).toString(), position);
            }
        });

        String jsonResults = MealsParser.callOpenMeals();

        try {
            MealsParser.getMealDataFromJson(jsonResults);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        String[] entries = MealsParser.getTitles();

        mealsListAdapter.clear();
        for(String dayEntry : entries ) {
            mealsListAdapter.add(dayEntry);
        }

        return rootView;
    }

    private void showDetailsForEntry(String message, int position) {
        // Create fragment and give it an argument specifying the article it should show
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle args = new Bundle();

        UAMenu meal = MealsParser.getMeal(position);

        args.putString(DetailsFragment.ARG_DATA, meal.getDate());
        args.putString(DetailsFragment.ARG_CANTINA, meal.getCanteen());
        args.putString(DetailsFragment.ARG_TIPO, meal.getMealType());
        args.putString(DetailsFragment.ARG_SOPA, meal.getSoup());
        args.putString(DetailsFragment.ARG_CARNE, meal.getMeat());
        args.putString(DetailsFragment.ARG_PEIXE, meal.getFish());
        args.putBoolean(DetailsFragment.ARG_OPEN, meal.isOpen());

        detailsFragment.setArguments(args);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.layout_container_for_fragment, detailsFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
}
