package es.bhavishchandnani.myrestaurant.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.model.Table;
import es.bhavishchandnani.myrestaurant.model.TableState;

public class TableRowViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private TextView peopleTextView;
    private TextView stateTextView;
    private ImageView iconImageView;
    private Context context;

    public TableRowViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        nameTextView = (TextView) itemView.findViewById(R.id.row_table_name);
        peopleTextView = (TextView) itemView.findViewById(R.id.row_table_people);
        stateTextView = (TextView) itemView.findViewById(R.id.row_table_state);
        iconImageView = (ImageView) itemView.findViewById(R.id.icon_centered_icon);
    }


    public void setTable(final Table table){
        if (table == null){
            return;
        }

        nameTextView.setText(table.getName(context));
        String peopleText = context.getString(R.string.table_people_header) + table.getPeople();
        peopleTextView.setText(peopleText);
        stateTextView.setText(table.getState().getStateStringId());
        Picasso.with(context).load(table.getIconId()).placeholder(TableState.EMPTY.getIconId()).into(iconImageView);
    }
}
