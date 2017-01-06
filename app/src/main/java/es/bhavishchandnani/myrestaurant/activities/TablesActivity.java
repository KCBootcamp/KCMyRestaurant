package es.bhavishchandnani.myrestaurant.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.adapters.TableStateAdapter;
import es.bhavishchandnani.myrestaurant.fragments.TablesFragment;
import es.bhavishchandnani.myrestaurant.model.Table;
import es.bhavishchandnani.myrestaurant.model.TableState;
import es.bhavishchandnani.myrestaurant.navigation.Navigator;
import es.bhavishchandnani.myrestaurant.views.GridAutofitLayoutManager;
import es.bhavishchandnani.myrestaurant.views.OnElementClick;
import es.bhavishchandnani.myrestaurant.views.OnElementLongClick;
import es.bhavishchandnani.myrestaurant.views.ToolbarInterface;

import static es.bhavishchandnani.myrestaurant.views.CustomViews.setCustomToolbarView;

public class TablesActivity extends AppCompatActivity {

    private TablesFragment tablesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        setCustomToolbarView(this,
                getResources().getString(R.string.tables),
                R.drawable.ic_my_restaurant,
                0,
                getToolbarClickListener());
        tablesFragment = (TablesFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_tables);
        tablesFragment.updateUI();
        tablesFragment.setListener(new OnElementClick<Table>() {
            @Override
            public void clickedOn(Table table, int position) {
                Navigator.NavigateToTableOrderActivity(TablesActivity.this, position);
            }
        });
        tablesFragment.setLongClickListener(new OnElementLongClick<Table>() {
            @Override
            public void longClickedOn(Table element, int position) {
                displayTableEditDialog(element);
            }
        });

    }

    private void displayTableEditDialog(final Table table) {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(TablesActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.custom_table_dialog, null);
        dialogBuilder.setView(dialogView);

        final EditText peopleEditText = (EditText) dialogView.findViewById(R.id.edit_dialog_people);
        peopleEditText.setText(String.valueOf(table.getPeople()));
        final RecyclerView recyclerView = (RecyclerView) dialogView.findViewById(R.id.table_dialog_recycler_view);
        recyclerView.setLayoutManager(new GridAutofitLayoutManager(this,Math.round(getResources().getDimension(R.dimen.item_table_state_dim))));

        final TableStateAdapter adapter = new TableStateAdapter(this, TableState.getTableStates(),table.getState());
        recyclerView.setAdapter(adapter);
        adapter.setOnElementClickListener(new OnElementClick<TableState>() {
            @Override
            public void clickedOn(TableState element, int position) {
                adapter.setSelectedState(element);
                adapter.notifyDataSetChanged();
            }
        });
        dialogBuilder.setIcon(R.drawable.ic_my_restaurant);
        dialogBuilder.setTitle(R.string.edit_table_parameters);
        dialogBuilder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                table.setPeople(Integer.parseInt(peopleEditText.getText().toString()));
                table.setState(adapter.getSelectedState());
                tablesFragment.updateUI();
            }
        });
        dialogBuilder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
               dialog.dismiss();
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }

    @NonNull
    private ToolbarInterface getToolbarClickListener() {
        return new ToolbarInterface() {
            @Override
            public void onLeftButtonClicked() {
            }

            @Override
            public void onRightButtonClicked() {

            }
        };
    }
}
