package es.bhavishchandnani.myrestaurant.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.model.Dish;

public class TableBillRowViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private TextView priceTextView;
    private ImageView iconImageView;
    private Context context;

    public TableBillRowViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        nameTextView = (TextView) itemView.findViewById(R.id.row_table_bill_dish_text);
        priceTextView = (TextView) itemView.findViewById(R.id.row_table_bill_dish_price);
        iconImageView = (ImageView) itemView.findViewById(R.id.row_table_bill_dish_img);

    }

    public void setDish(final Dish dish){
        if (dish == null){
            return;
        }

        nameTextView.setText(dish.getName());
        priceTextView.setText(dish.getPrice() + " " + dish.getCurrency().getSymbol());
        Picasso.with(context)
                .load(dish.getPhotoUrl())
                .into(iconImageView);
    }
}
