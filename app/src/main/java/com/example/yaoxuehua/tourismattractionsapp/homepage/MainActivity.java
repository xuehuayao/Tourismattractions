package com.example.yaoxuehua.tourismattractionsapp.homepage;


import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.example.yaoxuehua.tourismattractionsapp.R;
import com.example.yaoxuehua.tourismattractionsapp.parent.activity.BaseTopBarActivity;
import com.example.yaoxuehua.tourismattractionsapp.view.CalenderView;
import com.example.yaoxuehua.tourismattractionsapp.view.MyTextView;

public class MainActivity extends BaseTopBarActivity {

    private ViewPager viewPager;
    private LinearLayout viewGroup;
    private MapView myMapView;

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
        myMapView = (MapView) findViewById(R.id.myMap);
        BaiduMap mBaiduMap = myMapView.getMap();
      //普通地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);


        CalenderView calenderView = new CalenderView(this,null);
//        viewGroup.addView(calenderView);
        MyTextView myTextView = new MyTextView(this,null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(100,100);
        myTextView.setBackgroundColor(0xFFFF0000);

        myTextView.setBitmapAndSize(R.drawable.three,"首页");
        myTextView.setLayoutParams(layoutParams);
        viewGroup.addView(myTextView);

    }
}
