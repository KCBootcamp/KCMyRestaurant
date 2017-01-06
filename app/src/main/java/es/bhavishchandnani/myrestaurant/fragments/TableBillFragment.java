package es.bhavishchandnani.myrestaurant.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.adapters.TableBillAdapter;
import es.bhavishchandnani.myrestaurant.model.Dish;

public class TableBillFragment extends Fragment {


    private RecyclerView tableBillRecyclerView;
    private TableBillAdapter adapter;
    private LinkedList<Dish> dishes;

    public TableBillFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        tableBillRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        tableBillRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        FloatingActionButton addBtn = (FloatingActionButton) view.findViewById(R.id.add_button);
        addBtn.setVisibility(View.GONE);

        return view;
    }

    private void updateUI() {

        adapter = new TableBillAdapter(getActivity(),dishes);
        tableBillRecyclerView.setAdapter(adapter);

    }

    public void setDishes(LinkedList<Dish> dishes) {
        this.dishes = dishes;
        updateUI();
    }
}
