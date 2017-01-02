package es.bhavishchandnani.myrestaurant.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.fragments.AllergensListFragment;
import es.bhavishchandnani.myrestaurant.model.Allergens;
import es.bhavishchandnani.myrestaurant.views.ToolbarClickInterface;

import static es.bhavishchandnani.myrestaurant.views.CustomViews.setCustomToolbarView;

public class AllergensActivity extends AppCompatActivity {

    private AllergensListFragment allergensFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergens);

        setCustomToolbarView(this,
                getResources().getString(R.string.allergens),
                R.drawable.ic_arrow_left,
                R.drawable.ic_my_restaurant,
                getToolbarClickListener());

        allergensFragment = (AllergensListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_allergens_list);
        allergensFragment.setAllergens(Allergens.getAllergens());
    }

    @NonNull
    private ToolbarClickInterface getToolbarClickListener() {
        return new ToolbarClickInterface() {
            @Override
            public void onLeftButtonClicked() {
                finish();
            }

            @Override
            public void onRightButtonClicked() {

            }
        };
    }


}
