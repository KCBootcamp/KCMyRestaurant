package es.bhavishchandnani.myrestaurant.views;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.model.Allergens;

public class AllergenRowViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private ImageView iconImageView;
    private Context context;

    public AllergenRowViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        nameTextView = (TextView) itemView.findViewById(R.id.row_allergen_text);
        iconImageView = (ImageView) itemView.findViewById(R.id.icon_centered_icon);

    }

    public void setAllergen(final Allergens allergen){
        if (allergen == null){
            return;
        }

        nameTextView.setText(context.getResources().getString(allergen.stringId));
        Picasso.with(context)
                .load(allergen.iconId)
                .into(iconImageView);
    }
}
