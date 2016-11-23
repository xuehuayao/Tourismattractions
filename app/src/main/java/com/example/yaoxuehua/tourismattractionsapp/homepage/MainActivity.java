package com.example.yaoxuehua.tourismattractionsapp.homepage;


import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.example.yaoxuehua.tourismattractionsapp.R;
import com.example.yaoxuehua.tourismattractionsapp.parent.activity.BaseTopBarActivity;
import com.example.yaoxuehua.tourismattractionsapp.view.CalenderView;
import com.example.yaoxuehua.tourismattractionsapp.view.MyTextView;

public class MainActivity extends BaseTopBarActivity {

    private ViewPager viewPager;
    private LinearLayout viewGroup;

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
