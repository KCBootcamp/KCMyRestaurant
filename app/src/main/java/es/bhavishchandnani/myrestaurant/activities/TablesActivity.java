package es.bhavishchandnani.myrestaurant.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.fragments.TablesFragment;
import es.bhavishchandnani.myrestaurant.model.Table;
import es.bhavishchandnani.myrestaurant.views.OnElementClick;
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
                Log.d("jsald", "clickedOn: Table: "+position);
            }
        });
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
