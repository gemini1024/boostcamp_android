package com.miniproject.a2nd.a2ndminiproject;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageButton;

import com.miniproject.a2nd.a2ndminiproject.data.Restaurant;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // For savedInstanceState
    private static final String RESTAURANTS_KEY = "RESTAURANTS_KEY";
    private static final String SORT_TYPE_KEY = "SORT_TYPE_KEY";


    @BindView(R.id.sort_tab)
    TabLayout mSortTabs;
    @BindView(R.id.restaurant_list)
    RecyclerView mRestaurantViews;

    private RestaurantAdapter mRestaurantAdapter;
    private ArrayList<Restaurant> mRestaurants;
    private int mSortType;


    // TabLayout Listener ( 정렬 )
    private TabLayout.OnTabSelectedListener mTabSelectedListener = new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            if(mRestaurantAdapter != null) {
                mSortType = tab.getPosition();
                Collections.sort(mRestaurants, SortComparators.getSortComparator(mSortType));
                mRestaurantAdapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // TabLayout Listener 적용
        mSortTabs.addOnTabSelectedListener(mTabSelectedListener);

        if(savedInstanceState == null || !savedInstanceState.containsKey(RESTAURANTS_KEY)) {
            // mRestaurants, mSortType 데이터 생성
            mRestaurants = makeDummyDate();
            mSortType = SortComparators.SORT_DISTANCE;
            Collections.sort(mRestaurants, SortComparators.getSortComparator(mSortType));
        } else {
            // mRestaurants, mSortType 상태 불러오기
            mRestaurants = savedInstanceState.getParcelableArrayList(RESTAURANTS_KEY);
            mSortType = savedInstanceState.getInt(SORT_TYPE_KEY);
            mSortTabs.getTabAt(mSortType).select();
        }

        // RecyclerView 설정
        mRestaurantAdapter = new RestaurantAdapter(this, mRestaurants);
        mRestaurantViews.setHasFixedSize(true);
        mRestaurantViews.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRestaurantViews.setAdapter(mRestaurantAdapter);
    }


    // 임시 데이터 생성
    private ArrayList<Restaurant> makeDummyDate() {
        // new Restaurant(이름, 내용, 이미지Id, 체크여부, 거리, 인기, 작성시간)
        ArrayList<Restaurant> dummyDatas = new ArrayList<>();
        Calendar calendar= Calendar.getInstance();
        dummyDatas.add(new Restaurant(getString(R.string.dummy_item1_name), getString(R.string.dummy_item1_content),
                R.drawable.img_boost, false, 10, 8, calendar.getTime()));
        calendar.add(Calendar.DATE, -1);
        dummyDatas.add(new Restaurant(getString(R.string.dummy_item2_name), getString(R.string.dummy_item2_content),
                R.drawable.img_noodle, false, 3, 2, calendar.getTime()));
        calendar.add(Calendar.DATE, -1);
        dummyDatas.add(new Restaurant(getString(R.string.dummy_item3_name), getString(R.string.dummy_item3_content),
                R.drawable.img_square_sun, false, 30, 10, calendar.getTime()));
        calendar.add(Calendar.DATE, -1);
        dummyDatas.add(new Restaurant(getString(R.string.dummy_item4_name), getString(R.string.dummy_item4_content),
                R.drawable.img_square_cloud, false, 25, 5, calendar.getTime()));
        calendar.add(Calendar.DATE, -1);
        return dummyDatas;
    }

    // mRestaurants, mSortType 상태 저장
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(RESTAURANTS_KEY, mRestaurants);
        outState.putInt(SORT_TYPE_KEY, mSortType);
        super.onSaveInstanceState(outState);
    }

    // RecyclerView 레이아웃 형태 변경
    @OnClick(R.id.bt_view_change)
    void OnToggleLayoutManager(ImageButton imageButton) {
        if(mRestaurantViews.getLayoutManager() instanceof LinearLayoutManager) {
            mRestaurantViews.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
            imageButton.setImageResource(R.drawable.img_linear);
        } else {
            mRestaurantViews.setLayoutManager(new LinearLayoutManager(this));
            imageButton.setImageResource(R.drawable.img_grid);
        }
    }
}
