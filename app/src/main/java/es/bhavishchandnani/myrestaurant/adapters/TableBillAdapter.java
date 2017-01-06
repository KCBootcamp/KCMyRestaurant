package es.bhavishchandnani.myrestaurant.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.model.Allergens;
import es.bhavishchandnani.myrestaurant.model.Dish;
import es.bhavishchandnani.myrestaurant.views.AllergenRowViewHolder;
import es.bhavishchandnani.myrestaurant.views.TableBillRowViewHolder;

public class TableBillAdapter extends RecyclerView.Adapter<TableBillRowViewHolder> {

    private final LayoutInflater layoutInflater;
    private final LinkedList<Dish> dishList;

    public TableBillAdapter(Context context, LinkedList<Dish> dishList) {
        this.layoutInflater = LayoutInflater.from(context);
        this.dishList = dishList;
    }

    @Override
    public TableBillRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_table_bill_dish, parent, false);
        return new TableBillRowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TableBillRowViewHolder row, int position) {

        final Dish dish = dishList.get(position);

        row.setDish(dish);

    }

    @Override
    public int getItemCount() {
        return dishList.size();
    }
}
