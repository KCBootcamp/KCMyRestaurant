package es.bhavishchandnani.myrestaurant.views;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.model.TableState;

public class TableStateViewHolder  extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private ImageView iconImageView;
    private Context context;

    public TableStateViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        nameTextView = (TextView) itemView.findViewById(R.id.item_table_state_name);
        iconImageView = (ImageView) itemView.findViewById(R.id.icon_centered_icon);
    }

    public void setTableState(final TableState tableState, boolean isSelectedState){
        if (tableState == null){
            return;
        }
        if (isSelectedState){
            itemView.setBackgroundColor(context.getResources().getColor(R.color.colorLightGreen));
        }else {
            itemView.setBackgroundColor(context.getResources().getColor(android.R.color.transparent));
        }

        nameTextView.setText(tableState.getStateStringId());
        Picasso.with(context).load(tableState.getIconId()).placeholder(TableState.EMPTY.getIconId()).into(iconImageView);
    }

}
