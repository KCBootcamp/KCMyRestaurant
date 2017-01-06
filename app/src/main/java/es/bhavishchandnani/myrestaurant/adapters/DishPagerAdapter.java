package es.bhavishchandnani.myrestaurant.adapters;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.List;

import es.bhavishchandnani.myrestaurant.fragments.DishDetailFragment;
import es.bhavishchandnani.myrestaurant.model.Dish;

public class DishPagerAdapter extends FragmentPagerAdapter {
    private List<Dish> dishList;

    public DishPagerAdapter(FragmentManager fm, List<Dish> dishList) {
        super(fm);
        this.dishList = dishList;
    }

    @Override
    public Fragment getItem(int position) {
        Dish dish = dishList.get(position);
        DishDetailFragment fragment = DishDetailFragment.newInstance(dish);

        return fragment;
    }

    @Override
    public int getCount() {
        return dishList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);

        Dish dish = dishList.get(position);
        return dish.getName();
    }


}
