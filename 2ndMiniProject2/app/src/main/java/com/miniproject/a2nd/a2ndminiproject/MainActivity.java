package com.miniproject.a2nd.a2ndminiproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.miniproject.a2nd.a2ndminiproject.data.Restaurant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.restaurant_list)
    RecyclerView mRestaurantViews;

    private RestaurantAdapter mRestaurantAdapter;
    private ArrayList<Restaurant> mRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // new Restaurant(이름, 내용, 이미지 id, 체크여부, 거리, 인기, 작성시간)
        mRestaurants = new ArrayList<>();
        mRestaurants.add(new Restaurant("해우소", "꿀막거리가 인기메뉴고 맛있는 음식을 저렴하게 즐길 수 있는 해우소입니다.",
                R.drawable.img_boost, false, 10, 10, new Date()));
        mRestaurants.add(new Restaurant("삼교리동치미막국수", "막국수를 비빔으로 먹을지 물로 먹을지 고객이 만들어 먹는 삼교리동치미막국수입니다.",
                R.drawable.img_noodle, false, 3, 2, new Date()));
        mRestaurants.add(new Restaurant("H스퀘어 맑은날", "햇살이 좋은 날의 H스퀘어 광장 모습입니다",
                R.drawable.img_square_sun, false, 30, 8, new Date()));
        mRestaurants.add(new Restaurant("H스퀘어 흐린날", "구름이 많은 날의 H스퀘어 광장 모습입니다",
                R.drawable.img_square_cloud, false, 25, 5, new Date()));

        mRestaurantAdapter = new RestaurantAdapter(this, mRestaurants);

        // RecyclerView 설정
        mRestaurantViews.setHasFixedSize(true);
        mRestaurantViews.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRestaurantViews.setAdapter(mRestaurantAdapter);

    }

    @OnClick({R.id.bt_sort_distance, R.id.bt_sort_rank, R.id.bt_sort_time})
    void OnChangeSort(View view) {
        Comparator<Restaurant> comparator = null;
        switch (view.getId()) {
            case R.id.bt_sort_distance :    // 오름차순
                comparator = new Comparator<Restaurant>() {
                    @Override
                    public int compare(Restaurant o1, Restaurant o2) {
                        return (int)(o1.getDistance() - o2.getDistance());
                    }
                };
                break;
            case R.id.bt_sort_rank :        // 내림차순
                comparator = new Comparator<Restaurant>() {
                    @Override
                    public int compare(Restaurant o1, Restaurant o2) {
                        return o2.getRank() - o1.getRank();
                    }
                };
                break;
            case R.id.bt_sort_time :        // 내림차순
                comparator = new Comparator<Restaurant>() {
                    @Override
                    public int compare(Restaurant o1, Restaurant o2) {
                        return o1.getTime().compareTo(o2.getTime());
                    }
                };
                break;
        }
        Collections.sort(mRestaurants, comparator);
        mRestaurantAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.bt_view_change)
    void OnToggleLayoutManager(View view) {
        if(mRestaurantViews.getLayoutManager() instanceof LinearLayoutManager) {
            mRestaurantViews.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        } else {
            mRestaurantViews.setLayoutManager(new LinearLayoutManager(this));
        }
    }
}
