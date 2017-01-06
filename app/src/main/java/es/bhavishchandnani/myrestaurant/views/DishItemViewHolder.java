package es.bhavishchandnani.myrestaurant.views;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.model.Allergens;
import es.bhavishchandnani.myrestaurant.model.Dish;

public class DishItemViewHolder extends RecyclerView.ViewHolder {
    private final TextView priceTextView;
    private TextView nameTextView;
    private ImageView dishImageView;
    private LinearLayout allergensLayout;
    private Context context;

    public DishItemViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        nameTextView = (TextView) itemView.findViewById(R.id.item_text);
        priceTextView = (TextView) itemView.findViewById(R.id.item_price_text);
        dishImageView = (ImageView) itemView.findViewById(R.id.item_img);
        allergensLayout = (LinearLayout) itemView.findViewById(R.id.allergens_layout);

    }

    public void setDish(final Dish dish){
        if (dish == null){
            return;
        }

        nameTextView.setText(dish.getName());
        priceTextView.setText(dish.getPrice() +" "+ dish.getCurrency().getSymbol());
        Picasso.with(context)
                .load(dish.getPhotoUrl())
                .placeholder(android.R.drawable.ic_menu_camera)
                .into(dishImageView);

        allergensLayout.removeAllViews();

        for (Allergens allergen : dish.getAllergens()) {
            LinearLayout layout = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.icon_centered, allergensLayout, false);

            ImageView allergenImage = (ImageView) layout.findViewById(R.id.icon_centered_icon);
            ViewGroup.LayoutParams params = allergenImage.getLayoutParams();
            params.height = (int) context.getResources().getDimension(R.dimen.squared_small_icon_dim);
            params.width = (int) context.getResources().getDimension(R.dimen.squared_small_icon_dim);
            allergenImage.setImageResource(allergen.iconId);
            allergensLayout.addView(layout);
        }
    }

}
