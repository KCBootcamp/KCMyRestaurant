package es.bhavishchandnani.myrestaurant.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.model.Table;
import es.bhavishchandnani.myrestaurant.views.OnElementClick;
import es.bhavishchandnani.myrestaurant.views.TableRowViewHolder;

import static android.content.ContentValues.TAG;


public class TablesAdapter extends RecyclerView.Adapter<TableRowViewHolder>{

    private final LayoutInflater layoutInflater;
    private final LinkedList<Table> tableList;
    private OnElementClick<Table> listener;

    public TablesAdapter(Context context, LinkedList<Table> tables) {
        this.layoutInflater = LayoutInflater.from(context);
        this.tableList = tables;
    }


    @Override
    public TableRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_table, parent, false);
        return new TableRowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TableRowViewHolder row, final int position) {
        final Table table = tableList.get(position);
        row.setTable(table);

        row.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked item "+ position);
                if (listener != null){
                    listener.clickedOn(table, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tableList.size();
    }

    public void setOnElementClickListener(@NonNull final OnElementClick listener){
        this.listener =  listener;
    }
}
