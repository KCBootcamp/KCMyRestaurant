package es.bhavishchandnani.myrestaurant.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewSwitcher;

import java.util.LinkedList;
import java.util.List;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.communications.CommunicationsInterface;
import es.bhavishchandnani.myrestaurant.communications.DownloadAllDishes;
import es.bhavishchandnani.myrestaurant.mappers.DishMapper;
import es.bhavishchandnani.myrestaurant.model.Dish;
import es.bhavishchandnani.myrestaurant.model.Dishes;
import es.bhavishchandnani.myrestaurant.model.Table;
import es.bhavishchandnani.myrestaurant.model.TableState;
import es.bhavishchandnani.myrestaurant.model.Tables;
import es.bhavishchandnani.myrestaurant.navigation.Navigator;
import es.bhavishchandnani.myrestaurant.utils.Constants;

public class MyRestaurantActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewSwitcher viewSwitcher;
    private Button dishesBtn;
    private Button allergensBtn;
    private Button tablesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_restaurant);
        setViews();
        getAllDishes();
    }

    private void getAllDishes() {
        new DownloadAllDishes(this).execute(new CommunicationsInterface() {

            @Override
            public void getDataSuccess(String response) {
                new CacheData().execute(response);
            }

            @Override
            public void getDataFailed() {
                Snackbar.make(findViewById(android.R.id.content), getString(R.string.data_download_error), Snackbar.LENGTH_LONG).show();
                Animation fadeIn = AnimationUtils.loadAnimation(MyRestaurantActivity.this, android.R.anim.fade_in);
                viewSwitcher.setAnimation(fadeIn);
                viewSwitcher.showNext();
                dishesBtn.setEnabled(false);
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.activity_my_restaurant_allergens_btn:
                Navigator.NavigateToAllegensActivity(this);
                break;
            case R.id.activity_my_restaurant_dishes_btn:
                Navigator.NavigateToDishesActivity(this, false);
                break;
            case R.id.activity_my_restaurant_tables_btn:
                Navigator.NavigateToTablesActivity(this);
                break;
            default:
                break;
        }
    }

    private void setViews(){
        viewSwitcher = (ViewSwitcher) findViewById(R.id.activity_my_restaurant_loading_view_switcher);
        dishesBtn = (Button) findViewById(R.id.activity_my_restaurant_dishes_btn);
        allergensBtn = (Button) findViewById(R.id.activity_my_restaurant_allergens_btn);
        tablesBtn = (Button) findViewById(R.id.activity_my_restaurant_tables_btn);

        dishesBtn.setOnClickListener(this);
        allergensBtn.setOnClickListener(this);
        tablesBtn.setOnClickListener(this);
    }

    private class CacheData extends AsyncTask<String, Void, Dishes>{

        @Override
        protected Dishes doInBackground(String... strings) {
            List<Dish> dishList = DishMapper.mapDishList(strings[0]);
            Dishes.getInstance().setDishes(dishList);
            Tables.getInstance().setTables(getExampleTableListModel());
            return null;
        }

        private List<Table> getExampleTableListModel() {
            List<Table> tablesList = new LinkedList<>();
            for (int i = 0; i < Constants.NUMBER_OF_TABLES; i++){
                tablesList.add(new Table(i+1, 0, TableState.EMPTY, new LinkedList<Dish>()));
            }
            return tablesList;
        }

        @Override
        protected void onPostExecute(Dishes dishes) {
            super.onPostExecute(dishes);
            Animation fadeIn = AnimationUtils.loadAnimation(MyRestaurantActivity.this, android.R.anim.fade_in);
            viewSwitcher.setAnimation(fadeIn);
            viewSwitcher.showNext();
        }
    }
}
