package es.bhavishchandnani.myrestaurant.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.adapters.DishPagerAdapter;
import es.bhavishchandnani.myrestaurant.model.Dish;
import es.bhavishchandnani.myrestaurant.model.Dishes;
import es.bhavishchandnani.myrestaurant.model.Tables;
import es.bhavishchandnani.myrestaurant.utils.Constants;

public class DishPagerFragment extends Fragment {


    public List<Dish> dishList;
    private ViewPager mPager;
    private int pos;
    private int initialDishIndex;
    private int tableIndex;
    private View toolbar;

    public static DishPagerFragment newInstance(int dishIndex, int tableIndex) {
        Bundle arguments = new Bundle();
        arguments.putInt(Constants.INTENT_KEY_DISH_POSITION, dishIndex);
        arguments.putInt(Constants.INTENT_KEY_TABLE_POSITION, tableIndex);

        DishPagerFragment dishPagerFragment = new DishPagerFragment();
        dishPagerFragment.setArguments(arguments);

        return dishPagerFragment;
    }


    public DishPagerFragment() {
        // Required empty public constructor
        if (tableIndex == 0) {
            dishList = Dishes.getInstance().getDishes();
        } else {
            dishList = Tables.getInstance().getTable(tableIndex).getDishList();
        }

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            initialDishIndex = getArguments().getInt(Constants.INTENT_KEY_DISH_POSITION, 0);
            tableIndex = getArguments().getInt(Constants.INTENT_KEY_TABLE_POSITION, 0);
            pos = initialDishIndex;
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dish_pager, container, false);

        mPager = (ViewPager) root.findViewById(R.id.view_pager);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pos = position;
                showDish(pos);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mPager.setAdapter(new DishPagerAdapter(getFragmentManager(), dishList));

       showDish(initialDishIndex);

        return root;
    }

    public void showDish(int position) {
        mPager.setCurrentItem(position);
        if (getActivity().findViewById(R.id.toolbar) != null) {
            updateInfo(position);
        }
    }

    private void updateInfo(int position) {
        TextView title = (TextView) getActivity().findViewById(R.id.toolbar_title);
        ImageView leftImage = (ImageView) getActivity().findViewById(R.id.toolbar_left_btn);
        ImageView rightImage = (ImageView) getActivity().findViewById(R.id.toolbar_right_btn);
        title.setText(dishList.get(position).getName());
        if (pos == 0) {
            leftImage.setVisibility(View.INVISIBLE);
            rightImage.setVisibility(View.VISIBLE);
        } else if (pos == dishList.size()-1) {
            leftImage.setVisibility(View.VISIBLE);
            rightImage.setVisibility(View.INVISIBLE);
        } else {
            leftImage.setVisibility(View.VISIBLE);
            rightImage.setVisibility(View.VISIBLE);
        }
    }

    public void showPrevious() {
        if (pos > 0) {
            pos = pos - 1;
            showDish(pos);
        }
    }

    public void showNext() {
        if (pos < dishList.size()) {
            pos = pos + 1;
            showDish(pos);
        }
    }
}

