package es.bhavishchandnani.myrestaurant.activities;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.fragments.DishPagerFragment;
import es.bhavishchandnani.myrestaurant.fragments.DishesFragment;
import es.bhavishchandnani.myrestaurant.model.Dish;
import es.bhavishchandnani.myrestaurant.model.Dishes;
import es.bhavishchandnani.myrestaurant.navigation.Navigator;
import es.bhavishchandnani.myrestaurant.utils.Constants;
import es.bhavishchandnani.myrestaurant.views.CustomViews;
import es.bhavishchandnani.myrestaurant.views.DialogListener;
import es.bhavishchandnani.myrestaurant.views.OnElementClick;
import es.bhavishchandnani.myrestaurant.views.ToolbarInterface;

import static es.bhavishchandnani.myrestaurant.R.string.dishes;
import static es.bhavishchandnani.myrestaurant.views.CustomViews.setCustomToolbarView;

public class DishesActivity extends AppCompatActivity {

    private DishesFragment dishesFragment;
    private DishPagerFragment dishPagerFragment;
    private FrameLayout dishesPagerFragmentView;
    private boolean isFromOrder;
    private boolean isCombinedFragment;
    private AlertDialog dialog;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dishes);

        isFromOrder = getIntent().getBooleanExtra(Constants.INTENT_KEY_DISHES_IS_FROM_ORDER,false);
        dishesPagerFragmentView = (FrameLayout) findViewById(R.id.fragment_dish_pager);
        isCombinedFragment= (dishesPagerFragmentView != null);

        if (isCombinedFragment && isFromOrder){
            setCustomToolbarView(this,
                    getResources().getString(dishes),
                    R.drawable.ic_my_restaurant,
                    R.drawable.ic_plus,
                    getToolbarClickListener());
        }else {
            setCustomToolbarView(this,
                    getResources().getString(dishes),
                    R.drawable.ic_my_restaurant,
                    0,
                    getToolbarClickListener());
        }

        if (isCombinedFragment){
            position = 0;
            FragmentManager fm = getFragmentManager();
            dishPagerFragment = DishPagerFragment.newInstance(0, 0, isCombinedFragment);

            fm.beginTransaction()
                    .add(R.id.fragment_dish_pager, dishPagerFragment)
                    .commit();
        }

        dishesFragment = (DishesFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_dishes);
        dishesFragment.setDishes(Dishes.getInstance().getDishes());
        dishesFragment.setListener(new OnElementClick<Dish>() {
            @Override
            public void clickedOn(final Dish dish, int position) {
                    if (isCombinedFragment) {
                        DishesActivity.this.position =position;
                        dishPagerFragment.showDish(position);
                    } else {
                        if (isFromOrder){
                            addDishToOrder(dish);
                        }else {
                            Navigator.NavigateToDishPager(DishesActivity.this, position, 0);
                        }
                    }

            }

        });


    }
    private void addDishToOrder(final Dish dish) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(DishesActivity.this);
        dialog = CustomViews.buildGenericAlertDailog(builder,
                R.string.add_dish,
                R.string.add_dish_to_table_question,
                R.drawable.my_restaurant_logo,
                android.R.string.yes,
                android.R.string.no,
                new DialogListener() {
                    @Override
                    public void OnPositiveClick() {
                        Intent i = new Intent();
                        i.putExtra(Constants.INTENT_TABLE_ADD_DISH,dish);
                        DishesActivity.this.setResult(RESULT_OK,i);
                        DishesActivity.this.finish();
                    }

                    @Override
                    public void OnNegativeClick() {
                        if (dialog != null) {
                            dialog.dismiss();
                        }
                    }
                });
        dialog.show();
    }

    @NonNull
    private ToolbarInterface getToolbarClickListener() {
        return new ToolbarInterface() {
            @Override
            public void onLeftButtonClicked() {

            }

            @Override
            public void onRightButtonClicked() {
                if (isCombinedFragment && isFromOrder){
                    addDishToOrder(dishPagerFragment.dishList.get(position));
                }
            }
        };
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if(isCombinedFragment) {
            outState.putInt(Constants.DISH_SELECTED, position);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt(Constants.DISH_SELECTED);
        isCombinedFragment = (dishesPagerFragmentView != null);
        if (isCombinedFragment) {
            dishPagerFragment.showDish(position);
        }
    }
}
