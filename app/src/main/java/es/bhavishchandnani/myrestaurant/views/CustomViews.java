package es.bhavishchandnani.myrestaurant.views;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import es.bhavishchandnani.myrestaurant.R;

public class CustomViews {
    public static void setCustomToolbarView(AppCompatActivity activity, String title, int leftBtnImageId, int rightBtnImageId, final ToolbarInterface toolbarInterface) {
        View view = activity.findViewById(android.R.id.content);

        if (view.findViewById(R.id.toolbar) != null) {
            Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
            toolbar.setPadding(0, 0, 0, 0);

            TextView textView = (TextView) view.findViewById(R.id.toolbar_title);
            textView.setText(title);

            ImageView leftImageButton = (ImageView) view.findViewById(R.id.toolbar_left_btn);
            leftImageButton.setImageResource(leftBtnImageId);
            leftImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    toolbarInterface.onLeftButtonClicked();
                }
            });

            ImageView rightImageButton = (ImageView) view.findViewById(R.id.toolbar_right_btn);
            rightImageButton.setImageResource(rightBtnImageId);
            rightImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    toolbarInterface.onRightButtonClicked();
                }
            });

            activity.setSupportActionBar(toolbar);
            activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }
}
