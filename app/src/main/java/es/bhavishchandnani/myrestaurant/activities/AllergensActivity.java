package es.bhavishchandnani.myrestaurant.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.views.ToolbarClickInterface;

import static es.bhavishchandnani.myrestaurant.views.CustomViews.setCustomToolbarView;

public class AllergensActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergens);

        setCustomToolbarView(this,
                getResources().getString(R.string.allergens),
                R.drawable.ic_arrow_left,
                R.drawable.ic_my_restaurant,
                getToolbarClickListener());
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
