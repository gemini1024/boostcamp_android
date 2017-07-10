package com.miniproject.a2nd.a2ndminiproject;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jh on 17. 7. 10.
 */

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {

    @Override
    public RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class RestaurantViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.restaurant_item_image) ImageView imageView;
        @BindView(R.id.restaurant_item_name) TextView nameView;
        @BindView(R.id.restaurant_item_checkbox) CheckBox checkBox;
        @BindView(R.id.restaurant_item_content) TextView contentView;

        public RestaurantViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
