package es.bhavishchandnani.myrestaurant.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.model.Table;

public class TableRowViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private ImageView iconImageView;
    private Context context;

    public TableRowViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        nameTextView = (TextView) itemView.findViewById(R.id.row_table_text);
    }


    public void setTable(final Table table){
        if (table == null){
            return;
        }

        nameTextView.setText(table.getName(context));

    }
}
