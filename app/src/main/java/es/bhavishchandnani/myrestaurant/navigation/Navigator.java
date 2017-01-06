package es.bhavishchandnani.myrestaurant.navigation;


import android.app.Activity;
import android.content.Intent;

import es.bhavishchandnani.myrestaurant.activities.AllergensActivity;
import es.bhavishchandnani.myrestaurant.activities.DishPagerActivity;
import es.bhavishchandnani.myrestaurant.activities.DishesActivity;
import es.bhavishchandnani.myrestaurant.activities.TableOrderActivity;
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

    public static Intent NavigateToTableOrderActivity(Activity activity, int table) {
        final Intent i = new Intent(activity, TableOrderActivity.class);
        i.putExtra(Constants.INTENT_KEY_TABLE_ORDER_TABLE, table);
        activity.startActivity(i);
        return i;
    }

    public static Intent NavigateToDishesActivityWithResult(Activity activity, boolean isFromOrder) {
        final Intent i = new Intent(activity, DishesActivity.class);
        i.putExtra(Constants.INTENT_KEY_DISHES_IS_FROM_ORDER, isFromOrder);
        activity.startActivityForResult(i, Constants.ADD_DISH_REQUEST_CODE);
        return i;
    }

    public static Intent NavigateToTableBillActivity(Activity activity, int table) {
        final Intent i = new Intent(activity, TableBillActivity.class);
        i.putExtra(Constants.INTENT_KEY_TABLE_ORDER_TABLE, table);
        activity.startActivity(i);
        return i;
    }
}
