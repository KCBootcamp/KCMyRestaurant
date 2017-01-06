package es.bhavishchandnani.myrestaurant.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.model.Allergens;
import es.bhavishchandnani.myrestaurant.views.AllergenRowViewHolder;

public class AllergensAdapter extends RecyclerView.Adapter<AllergenRowViewHolder> {

    private final LayoutInflater layoutInflater;
    private final LinkedList<Allergens> allergens;

    public AllergensAdapter(Context context, LinkedList<Allergens> allergens) {
        this.layoutInflater = LayoutInflater.from(context);
        this.allergens = allergens;
    }

    @Override
    public AllergenRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_allergen, parent, false);
        return new AllergenRowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AllergenRowViewHolder row, int position) {

        final Allergens allergen = allergens.get(position);

        row.setAllergen(allergen);

    }

    @Override
    public int getItemCount() {
        return allergens.size();
    }
}
