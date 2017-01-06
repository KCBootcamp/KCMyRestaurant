package es.bhavishchandnani.myrestaurant.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import es.bhavishchandnani.myrestaurant.R;
import es.bhavishchandnani.myrestaurant.model.Allergens;
import es.bhavishchandnani.myrestaurant.model.Dish;
import es.bhavishchandnani.myrestaurant.utils.Constants;

public class DishDetailFragment extends Fragment {
    private Dish dish;
    public static DishDetailFragment newInstance(Dish dish) {
        Bundle arguments = new Bundle();
        arguments.putSerializable(Constants.DISH_ARGUMENT_KEY, dish);

        DishDetailFragment dishDetailFragment = new DishDetailFragment();
        dishDetailFragment.setArguments(arguments);

        return dishDetailFragment;
    }

    public DishDetailFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dish = (Dish) getArguments().getSerializable(Constants.DISH_ARGUMENT_KEY);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dish_detail, container, false);

        ImageView imageView = (ImageView) root.findViewById(R.id.detail_img);
        TextView dishTypeText = (TextView) root.findViewById(R.id.detail_dish_type);
        TextView dishPriceText = (TextView) root.findViewById(R.id.detail_dish_price);
        TextView descriptionText = (TextView) root.findViewById(R.id.detail_description);
        LinearLayout allergensLayout = (LinearLayout) root.findViewById(R.id.detail_allergens_layout);

        setAllergensView(allergensLayout);

        dishPriceText.setText(dish.getPrice() + " " + dish.getCurrency().getSymbol());
        dishTypeText.setText(getString(R.string.detail_dish_type_header) + getString(dish.getType().getDishTypeNameId()));
        descriptionText.setText(dish.getDescription());
        Picasso.with(root.getContext()).load(dish.getPhotoUrl()).placeholder(android.R.drawable.ic_menu_camera).into(imageView);
        return root;
    }

    private void setAllergensView(LinearLayout allergensLayout) {
        for (Allergens allergen : dish.getAllergens()) {
            LinearLayout layout = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.row_allergen, allergensLayout, false);

            ImageView allergenImage = (ImageView) layout.findViewById(R.id.icon_centered_icon);
            allergenImage.setImageResource(allergen.iconId);
            TextView allergenText = (TextView) layout.findViewById(R.id.row_allergen_text);
            allergenText.setText(getResources().getString(allergen.stringId));
            allergensLayout.addView(layout);
        }
    }
}
