package es.bhavishchandnani.myrestaurant.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.adapters.AllergensAdapter;
import es.bhavishchandnani.myrestaurant.model.Allergens;
import es.bhavishchandnani.myrestaurant.views.GridAutofitLayoutManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class AllergensListFragment extends Fragment {

    private RecyclerView allergensRecyclerView;
    private AllergensAdapter adapter;
    private LinkedList<Allergens> allergens;

    public AllergensListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        allergensRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        allergensRecyclerView.setLayoutManager(new GridAutofitLayoutManager(getActivity(), Math.round(getResources().getDimension(R.dimen.row_width))));

        FloatingActionButton addBtn = (FloatingActionButton) view.findViewById(R.id.add_button);
        addBtn.setVisibility(View.GONE);

        return view;
    }

    private void updateUI() {

        adapter = new AllergensAdapter(getActivity(),allergens);
        allergensRecyclerView.setAdapter(adapter);

    }

    public LinkedList<Allergens> getAllergens() {
        return allergens;
    }

    public void setAllergens(LinkedList<Allergens> allergens) {
        this.allergens = allergens;
        updateUI();
    }


}
