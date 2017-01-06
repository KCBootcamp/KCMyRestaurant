package es.bhavishchandnani.myrestaurant.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.adapters.DishesAdapter;
import es.bhavishchandnani.myrestaurant.model.Dish;
import es.bhavishchandnani.myrestaurant.model.Dishes;
import es.bhavishchandnani.myrestaurant.views.GridAutofitLayoutManager;
import es.bhavishchandnani.myrestaurant.views.OnElementClick;

public class DishesFragment extends Fragment {

    private RecyclerView dishesRecyclerView;
    private DishesAdapter adapter;
    private List<Dish> dishes;
    private OnElementClick<Dish> listener;

    public DishesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        dishesRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        dishesRecyclerView.setLayoutManager(new GridAutofitLayoutManager(getActivity(),Math.round(getResources().getDimension(R.dimen.card_width))));
        FloatingActionButton addBtn = (FloatingActionButton) view.findViewById(R.id.add_button);
        addBtn.setVisibility(View.GONE);

        return view;
    }

    private void updateUI() {
        adapter = new DishesAdapter(getActivity(), dishes);
        dishesRecyclerView.setAdapter(adapter);
        adapter.setOnElementClickListener(new OnElementClick<Dish>() {
            @Override
            public void clickedOn(Dish dish, int position) {
                if (listener != null){
                    listener.clickedOn(dish,position);
                }
            }
        });

    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes.getDishes();
        updateUI();
    }

    public OnElementClick<Dish> getListener() {
        return listener;
    }

    public void setListener(OnElementClick<Dish> listener) {
        this.listener = listener;
    }


}
