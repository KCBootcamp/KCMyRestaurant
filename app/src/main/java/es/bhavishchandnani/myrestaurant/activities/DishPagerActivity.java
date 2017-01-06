package es.bhavishchandnani.myrestaurant.activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.fragments.DishPagerFragment;
import es.bhavishchandnani.myrestaurant.utils.Constants;
import es.bhavishchandnani.myrestaurant.views.ToolbarInterface;

import static es.bhavishchandnani.myrestaurant.views.CustomViews.setCustomToolbarView;

public class DishPagerActivity extends AppCompatActivity {
    private int positionDish;
    private int positionTable;
    private DishPagerFragment dishPagerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_pager);

        getDataFromIntent();
        setCustomToolbarView(this,
                getResources().getString(R.string.dishes),
                R.drawable.ic_arrow_left,
                R.drawable.ic_arrow_right,
                getToolbarInterface());

        FragmentManager fm = getFragmentManager();
        dishPagerFragment = DishPagerFragment.newInstance(positionDish, positionTable, false);

        fm.beginTransaction()
                .add(R.id.fragment_dish_pager, dishPagerFragment)
                .commit();

    }

    private void getDataFromIntent() {
        Intent i = getIntent();
        positionDish = i.getIntExtra(Constants.INTENT_KEY_DISH_POSITION, 0);
        positionTable = i.getIntExtra(Constants.INTENT_KEY_TABLE_POSITION, 0);
    }

    @NonNull
    private ToolbarInterface getToolbarInterface() {
        return new ToolbarInterface() {
            @Override
            public void onLeftButtonClicked() {

                dishPagerFragment.showPrevious();

            }

            @Override
            public void onRightButtonClicked() {

                dishPagerFragment.showNext();

            }
        };
    }


}
