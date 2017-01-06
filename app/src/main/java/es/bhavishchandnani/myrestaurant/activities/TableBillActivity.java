package es.bhavishchandnani.myrestaurant.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.LinkedList;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.fragments.TableBillFragment;
import es.bhavishchandnani.myrestaurant.model.Dish;
import es.bhavishchandnani.myrestaurant.model.Table;
import es.bhavishchandnani.myrestaurant.model.Tables;
import es.bhavishchandnani.myrestaurant.utils.Constants;
import es.bhavishchandnani.myrestaurant.views.CustomViews;
import es.bhavishchandnani.myrestaurant.views.DialogListener;
import es.bhavishchandnani.myrestaurant.views.ToolbarInterface;

import static es.bhavishchandnani.myrestaurant.views.CustomViews.setCustomToolbarView;

public class TableBillActivity extends AppCompatActivity {

    private Table table;
    private TableBillFragment tableBillFragment;
    private TextView totalPriceText;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_bill);

        getDataFromIntent();
        setCustomToolbarView(this,
                table.getName(this),
                R.drawable.ic_my_restaurant,
                R.drawable.ic_table_bill_paid,
                getToolbarClickListener());

        totalPriceText = (TextView) findViewById(R.id.table_bill_total_price);
        displayTotalPrice();
        tableBillFragment = (TableBillFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_table_bill_list);
        tableBillFragment.setDishes((LinkedList<Dish>) table.getDishList());
    }

    private void displayTotalPrice() {
        double totalPrice = 0.0;
        for (Dish dish : table.getDishList()) {
            totalPrice = totalPrice + dish.getPrice();
        }
        totalPriceText.setText(getString(R.string.total_price)+totalPrice+" "+table.getDishList().get(0).getCurrency().getSymbol());
    }

    public void getDataFromIntent() {
        Intent i = getIntent();
        table = Tables.getInstance().getTable(i.getIntExtra(Constants.INTENT_KEY_TABLE_ORDER_BILL_TABLE,0));
    }


    @NonNull
    private ToolbarInterface getToolbarClickListener() {
        return new ToolbarInterface() {
            @Override
            public void onLeftButtonClicked() {

            }

            @Override
            public void onRightButtonClicked() {
                final AlertDialog.Builder builder = new AlertDialog.Builder(TableBillActivity.this);
                dialog = CustomViews.buildGenericAlertDailog(builder,
                        R.string.close_bill,
                        R.string.close_bill_question,
                        R.drawable.my_restaurant_logo,
                        android.R.string.yes,
                        android.R.string.no,
                        new DialogListener() {
                            @Override
                            public void OnPositiveClick() {
                                dialog.show();
                                table.clearTable();
                                Tables.getInstance().setTable(table.getId()-1, table);
                                setResult(RESULT_OK);
                                finish();
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
        };


    }
}
