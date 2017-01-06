package es.bhavishchandnani.myrestaurant.navigation;


import android.app.Activity;
import android.content.Intent;

import es.bhavishchandnani.myrestaurant.activities.AllergensActivity;
import es.bhavishchandnani.myrestaurant.activities.DishPagerActivity;
import es.bhavishchandnani.myrestaurant.activities.DishesActivity;
import es.bhavishchandnani.myrestaurant.activities.TablesActivity;
import es.bhavishchandnani.myrestaurant.utils.Constants;

public class Navigator {
    public static Intent NavigateToDishPager(Activity activity, int positionDish, int positionTable){
        final Intent i = new Intent(activity, DishPagerActivity.class);
        i.putExtra(Constants.INTENT_KEY_DISH_POSITION, positionDish);
        i.putExtra(Constants.INTENT_KEY_TABLE_POSITION, positionTable);
        activity.startActivity(i);
        return i;
    }

    public static Intent NavigateToAllegensActivity(Activity activity){
        final Intent i = new Intent(activity, AllergensActivity.class);
        activity.startActivity(i);
        return i;
    }
    public static Intent NavigateToTablesActivity(Activity activity){
        final Intent i = new Intent(activity, TablesActivity.class);
        activity.startActivity(i);
        return i;
    }public static Intent NavigateToDishesActivity(Activity activity, boolean isFromOrder){
        final Intent i = new Intent(activity, DishesActivity.class);
        i.putExtra(Constants.INTENT_KEY_DISHES_IS_FROM_ORDER, isFromOrder);
        activity.startActivity(i);
        return i;
    }
}
