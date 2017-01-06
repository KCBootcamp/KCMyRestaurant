package es.bhavishchandnani.myrestaurant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.fragments.DishesFragment;
import es.bhavishchandnani.myrestaurant.model.Dish;
import es.bhavishchandnani.myrestaurant.model.Table;
import es.bhavishchandnani.myrestaurant.model.Tables;
import es.bhavishchandnani.myrestaurant.navigation.Navigator;
import es.bhavishchandnani.myrestaurant.utils.Constants;
import es.bhavishchandnani.myrestaurant.views.CustomViews;
import es.bhavishchandnani.myrestaurant.views.DialogListener;
import es.bhavishchandnani.myrestaurant.views.OnElementClick;
import es.bhavishchandnani.myrestaurant.views.OnElementLongClick;
import es.bhavishchandnani.myrestaurant.views.ToolbarInterface;

import static es.bhavishchandnani.myrestaurant.views.CustomViews.setCustomToolbarView;

public class TableOrderActivity extends AppCompatActivity {
    private Table table;
    private DishesFragment dishesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_order);
        getDataFromIntent();
        setCustomToolbarView(this,
                table.getName(this),
                R.drawable.ic_my_restaurant,
                R.drawable.ic_table_order_bill,
                getToolbarClickListener());

        dishesFragment = (DishesFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_dishes);
        dishesFragment.setDishes(table.getDishList());
        dishesFragment.setFABVisibility(View.VISIBLE);
        dishesFragment.setListener(new OnElementClick<Dish>() {
            @Override
            public void clickedOn(Dish dish, int position) {
                if (table.getDishList().size()>0) {
                    Navigator.NavigateToDishPager(TableOrderActivity.this, position, table.getId() - 1);
                }else{
                    Snackbar.make(findViewById(android.R.id.content), getString(R.string.table_has_no_dishes), Snackbar.LENGTH_LONG).show();
                }
            }
        });

        dishesFragment.setLongClickListener(new OnElementLongClick<Dish>() {
            private AlertDialog dialog;
            @Override
            public void longClickedOn(final Dish element, final int position) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(TableOrderActivity.this);
                dialog = CustomViews.buildGenericAlertDailog(builder,
                        R.string.remove_dish,
                        R.string.remove_dish_to_table_question,
                        R.drawable.my_restaurant_logo,
                        android.R.string.yes,
                        android.R.string.no,
                        new DialogListener() {
                            @Override
                            public void OnPositiveClick() {
                                table.removeDishToDishList(element);
                                table = Tables.getInstance().getTable(table.getId()-1);
                                dishesFragment.setDishes(table.getDishList());

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
        });

        dishesFragment.setFABListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigator.NavigateToDishesActivityWithResult(TableOrderActivity.this, true);
            }
        });
    }

    public void getDataFromIntent() {
        Intent i = getIntent();
        table = Tables.getInstance().getTable(i.getIntExtra(Constants.INTENT_KEY_TABLE_ORDER_TABLE,0));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.ADD_DISH_REQUEST_CODE && resultCode == RESULT_OK){
            Dish dish = (Dish) data.getSerializableExtra(Constants.INTENT_TABLE_ADD_DISH);
            table.addDishToDishList(dish);
            Tables.getInstance().setTable(table.getId()-1,table);
            dishesFragment.setDishes(table.getDishList());
        } else if (requestCode == Constants.TABLE_BILL_REQUEST_CODE && resultCode == RESULT_OK){
            finish();
        }
    }

    @NonNull
    private ToolbarInterface getToolbarClickListener() {
        return new ToolbarInterface() {
            @Override
            public void onLeftButtonClicked() {

            }

            @Override
            public void onRightButtonClicked() {
                Navigator.NavigateToTableBillActivityWtihResult(TableOrderActivity.this,table.getId()-1);
            }
        };


    }
}
