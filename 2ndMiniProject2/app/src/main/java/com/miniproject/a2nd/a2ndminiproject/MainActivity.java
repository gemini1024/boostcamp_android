package com.miniproject.a2nd.a2ndminiproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.restaurant_list)
    RecyclerView mRestaurantViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);



    }

    @OnClick({R.id.bt_sort_distance, R.id.bt_sort_rank, R.id.bt_sort_time})
    void OnChangeSort(View view) {
        switch (view.getId()) {
            case R.id.bt_sort_distance :
                break;
            case R.id.bt_sort_rank :
                break;
            case R.id.bt_sort_time :
                break;
        }
    }

    @OnClick(R.id.bt_view_change)
    void OnToggleLayoutManager(View view) {

    }
}
