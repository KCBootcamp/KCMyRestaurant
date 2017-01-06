package es.bhavishchandnani.myrestaurant.adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.model.Dish;
import es.bhavishchandnani.myrestaurant.views.DishItemViewHolder;
import es.bhavishchandnani.myrestaurant.views.OnElementClick;
import es.bhavishchandnani.myrestaurant.views.OnElementLongClick;

import static android.content.ContentValues.TAG;

public class DishesAdapter extends RecyclerView.Adapter<DishItemViewHolder> {

    private final LayoutInflater layoutInflater;
    private final List<Dish> dishes;

    private OnElementClick<Dish> listener;
    private OnElementLongClick<Dish> onElementLongClickListener;

    public DishesAdapter(Context context, List<Dish> dishes) {
        this.layoutInflater = LayoutInflater.from(context);
        this.dishes = dishes;
    }

    @Override
    public DishItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_dish, parent, false);
        return new DishItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DishItemViewHolder item, final int position) {
        final Dish dish = dishes.get(position);

        item.setDish(dish);

        item.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked item "+position);
                if (listener != null){
                    listener.clickedOn(dish, position);
                }
            }
        });

        item.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                onElementLongClickListener.longClickedOn(dish, position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return dishes.size();
    }

    public void setOnElementClickListener(@NonNull final OnElementClick listener){
        this.listener =  listener;
    }

    public void setOnElementLongClickListener(OnElementLongClick<Dish> onElementLongClickListener) {
        this.onElementLongClickListener = onElementLongClickListener;
    }
}
