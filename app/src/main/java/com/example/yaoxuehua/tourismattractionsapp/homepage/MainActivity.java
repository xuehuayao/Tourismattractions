package com.example.yaoxuehua.tourismattractionsapp.homepage;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.TextureMapView;
import com.example.yaoxuehua.tourismattractionsapp.R;
import com.example.yaoxuehua.tourismattractionsapp.homepage.FragmentAdapter.ViewPagerFragmentAdapter;
import com.example.yaoxuehua.tourismattractionsapp.homepage.fragment.MapNavigationFragment;
import com.example.yaoxuehua.tourismattractionsapp.homepage.fragment.PersonalCenterFragment;
import com.example.yaoxuehua.tourismattractionsapp.homepage.fragment.TourismRecommendFragment;
import com.example.yaoxuehua.tourismattractionsapp.parent.activity.BaseTopBarActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseTopBarActivity {

    private ViewPager viewPager;
    private LinearLayout viewGroup;
    private TextureMapView myMapView;
    private List<Fragment> fragmentList;

    @Override
    public void getSetContentViewBefore() {
        super.getSetContentViewBefore();

        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        setTitle("首页");
        viewPager = (ViewPager) findViewById(R.id.Main_viewPager);
        viewGroup = (LinearLayout) findViewById(R.id.viewGroup);


        setFragmentList();
    }

    public void setFragmentList(){
        fragmentList = new ArrayList<>();
        TourismRecommendFragment tourismRecommendFragment = new TourismRecommendFragment();
        PersonalCenterFragment personalCenterFragment = new PersonalCenterFragment();
        MapNavigationFragment mapNavigationFragment = new MapNavigationFragment();
        fragmentList.add(tourismRecommendFragment);
        fragmentList.add(personalCenterFragment);
        fragmentList.add(mapNavigationFragment);
        ViewPagerFragmentAdapter viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(viewPagerFragmentAdapter);
    }
}
