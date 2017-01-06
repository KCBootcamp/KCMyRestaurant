package es.bhavishchandnani.myrestaurant.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.fragments.DishesFragment;
import es.bhavishchandnani.myrestaurant.model.Dish;
import es.bhavishchandnani.myrestaurant.model.Dishes;
import es.bhavishchandnani.myrestaurant.navigation.Navigator;
import es.bhavishchandnani.myrestaurant.utils.Constants;
import es.bhavishchandnani.myrestaurant.views.OnElementClick;
import es.bhavishchandnani.myrestaurant.views.ToolbarInterface;

import static es.bhavishchandnani.myrestaurant.views.CustomViews.setCustomToolbarView;

public class DishesActivity extends AppCompatActivity {

    private DishesFragment dishesFragment;
    private boolean isFromOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishes);

        isFromOrder = getIntent().getBooleanExtra(Constants.INTENT_KEY_DISHES_IS_FROM_ORDER,false);

        setCustomToolbarView(this,
                getResources().getString(R.string.dishes),
                R.drawable.ic_my_restaurant,
                0,
                getToolbarClickListener());

        dishesFragment = (DishesFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_dishes);
        dishesFragment.setDishes(Dishes.getInstance());
        dishesFragment.setListener(new OnElementClick<Dish>() {
            @Override
            public void clickedOn(Dish dish, int position) {
                if (isFromOrder){
                    //TODO return dish like result
                }else{
                    Navigator.NavigateToDishPager(DishesActivity.this, position, 0);
                }
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
