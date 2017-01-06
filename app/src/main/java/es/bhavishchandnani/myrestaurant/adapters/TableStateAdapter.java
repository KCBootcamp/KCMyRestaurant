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
import es.bhavishchandnani.myrestaurant.model.TableState;
import es.bhavishchandnani.myrestaurant.views.OnElementClick;
import es.bhavishchandnani.myrestaurant.views.TableStateViewHolder;

import static android.content.ContentValues.TAG;

public class TableStateAdapter extends RecyclerView.Adapter<TableStateViewHolder>{

    private final LayoutInflater layoutInflater;
    private final LinkedList<TableState> tableStateList;
    private OnElementClick<TableState> listener;
    private TableStateViewHolder viewHolder;
    private TableState selectedState;

    public TableStateAdapter(Context context, LinkedList<TableState> tableStateList, TableState state) {
        this.layoutInflater = LayoutInflater.from(context);
        this.tableStateList = tableStateList;
        this.selectedState = state;
    }

    public TableState getSelectedState() {
        return selectedState;
    }

    public void setSelectedState(TableState state) {
        selectedState = state;
    }

    @Override
    public TableStateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_table_state, parent, false);
        viewHolder = new TableStateViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TableStateViewHolder item, final int position) {
        final TableState tableState = tableStateList.get(position);
        item.setTableState(tableState, tableState.equals(selectedState));

        item.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked item "+ position);
                if (listener != null){
                    listener.clickedOn(tableState, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tableStateList.size();
    }

    public void setOnElementClickListener(@NonNull final OnElementClick listener){
        this.listener =  listener;
    }
}
