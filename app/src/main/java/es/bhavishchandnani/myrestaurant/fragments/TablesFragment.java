package es.bhavishchandnani.myrestaurant.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.adapters.TablesAdapter;
import es.bhavishchandnani.myrestaurant.model.Table;
import es.bhavishchandnani.myrestaurant.model.Tables;
import es.bhavishchandnani.myrestaurant.views.OnElementClick;

public class TablesFragment extends Fragment {

    private RecyclerView tablesRecyclerView;
    private TablesAdapter adapter;
    private OnElementClick<Table> listener;

    public TablesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        tablesRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        tablesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        FloatingActionButton addBtn = (FloatingActionButton) view.findViewById(R.id.add_button);
        addBtn.setVisibility(View.GONE);

        return view;
    }


    public void updateUI() {
        adapter = new TablesAdapter(getActivity(), getTables());
        tablesRecyclerView.setAdapter(adapter);
        adapter.setOnElementClickListener(new OnElementClick<Table>() {
            @Override
            public void clickedOn(Table table, int position) {
                if (listener != null){
                    listener.clickedOn(table,position);
                }
            }
        });
    }

    public LinkedList<Table> getTables() {
        return (LinkedList<Table>) Tables.getInstance().getTables();
    }

    public OnElementClick<Table> getListener() {
        return listener;
    }

    public void setListener(OnElementClick<Table> listener) {
        this.listener = listener;
    }
}
