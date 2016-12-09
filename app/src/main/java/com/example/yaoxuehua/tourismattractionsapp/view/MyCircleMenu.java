package com.example.yaoxuehua.tourismattractionsapp.view;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.provider.OpenableColumns;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.yaoxuehua.tourismattractionsapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.Math.sin;

/**
 * Created by yaoxuehua on 16-12-9.
 */

public class MyCircleMenu extends View {

    private int viewWidth = 0;//该控件宽
    private int viewHeight = 0;//该控件高
    private int child_radius = 0;
    private int circleMenu_big_radius = 0;//模拟大圆
    private String open = "open";
    private String[] stringArr = new String[]{"出行", "门票", "农家院", "酒店", "路程规划"};
    private int[] circleColor = new int[]{Color.rgb(70, 0, 130), Color.GRAY, Color.rgb(30, 144, 255), Color.RED, Color.rgb(255, 182, 193)};
    private List<StatusSave> statusSaveList = new ArrayList<>();
    private int CIRCLEMENU_OPEN_STATUS = 0;
    private int CIRCLEMENU_CLOSE_STATUS = 1;
    private int CIRCLEmENU_CURRENT_STATUS = 2;
    private Timer timer;
    private int countChange = 8;
    private int distanceTime = 900;
    private int distanceEveryTime = 100;
    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {

                case 0:
                    int child_radius_x = getResources().getDimensionPixelSize(R.dimen.circleMenu_child_radius);
                    int circleMenu_big_radius_x = getResources().getDimensionPixelSize(R.dimen.circleMenu_big_radius);


                    child_radius = child_radius + child_radius_x;

                    circleMenu_big_radius = circleMenu_big_radius + circleMenu_big_radius_x;
                    invalidate();
                    break;
                case 1:

                    int child_radius_y = getResources().getDimensionPixelSize(R.dimen.circleMenu_child_radius);
                    int circleMenu_big_radius_y = getResources().getDimensionPixelSize(R.dimen.circleMenu_big_radius);
                    child_radius = child_radius - child_radius_y;

                    circleMenu_big_radius = circleMenu_big_radius + circleMenu_big_radius_y;
                    invalidate();
                    break;
            }
        }
    };

    public MyCircleMenu(Context context) {
        super(context);
        child_radius = getResources().getDimensionPixelSize(R.dimen.circleMenu_child_radius);
    }

    public MyCircleMenu(Context context, AttributeSet attrs) {
        super(context, attrs);


        controlAnimation();

    }
    //点击事件监听
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){


            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:



                break;
        }



        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCircleButton(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewHeight = h;
        viewWidth = w;
    }

    /**
     * 中心按钮
     */
    public void drawCircleButton(Canvas canvas) {

        Paint circleCenterPaint = new Paint();

        Paint circleCenterPaintText = new Paint();

        Paint bigCircleCenterPaint = new Paint();

        circleCenterPaintText.setColor(Color.WHITE);
        bigCircleCenterPaint.setStyle(Paint.Style.STROKE);
        circleCenterPaintText.setTextSize(25);
        circleCenterPaint.setColor(Color.BLUE);
        //大型圆圈
        canvas.drawCircle(viewWidth / 2, viewHeight / 2, circleMenu_big_radius, bigCircleCenterPaint);
        double offsetDegree = 72;//72;144;216;288;360;

        double aa = Math.sin(30 * Math.PI / 180);

        statusSaveList.clear();
        StatusSave statusSave = new StatusSave();
        statusSave.setWidthX((float) (viewWidth / 2));
        statusSave.setHeightY((float) (viewHeight / 2));
        statusSaveList.add(statusSave);
        for (int i = 1; i < 6; i++) {
            double offestWidth = Math.sin(offsetDegree * i * Math.PI / 180) * circleMenu_big_radius;
            double offsetHeith = Math.cos(offsetDegree * i * Math.PI / 180) * circleMenu_big_radius;

            circleCenterPaint.setColor(circleColor[i - 1]);
            circleCenterPaint.setAntiAlias(true);
            canvas.drawCircle((float) (viewWidth / 2 + offestWidth), (float) (viewHeight / 2 - offsetHeith), child_radius, circleCenterPaint);
            //保存位置坐标
            StatusSave statusSaveChild = new StatusSave();
            statusSaveChild.setWidthX((float) (viewWidth / 2 + offestWidth));
            statusSaveChild.setHeightY((float) (viewHeight / 2 - offsetHeith));
            statusSaveList.add(statusSaveChild);


            //文字宽度
            int textWidthChild = getTextWidth(circleCenterPaintText, stringArr[i - 1]);
            circleCenterPaintText.setColor(Color.WHITE);
            canvas.drawText(stringArr[i - 1], (float) (viewWidth / 2 + offestWidth) - textWidthChild / 2, (float) (viewHeight / 2 - offsetHeith), circleCenterPaintText);

        }


        canvas.drawCircle(viewWidth / 2, viewHeight / 2, child_radius, circleCenterPaint);
        //文字宽度
        int textWidth = getTextWidth(circleCenterPaintText, open);
        canvas.drawText(open, viewWidth / 2 - textWidth / 2, viewHeight / 2, circleCenterPaintText);

    }



    /**
     * 精确测量文字的宽度
     */
    public int getTextWidth(Paint paint, String str) {
        int iRet = 0;
        if (str != null && str.length() > 0) {
            int len = str.length();
            float[] widths = new float[len];
            paint.getTextWidths(str, widths);
            for (int j = 0; j < len; j++) {
                iRet += (int) Math.ceil(widths[j]);
            }
        }
        return iRet;
    }

    /**
     * 渐变的时间效果
     */
    public void controlAnimation() {

        final TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                Message message = handler.obtainMessage();
                if (distanceEveryTime < distanceTime) {
                    distanceEveryTime = distanceEveryTime + 100;
                    message.what = 0;
                } else {
                    timer.cancel();
                    message.what = 1;
                }
                handler.sendMessage(message);
            }
        };
        if (timer == null) {
            timer = new Timer();
        }

        timer.schedule(timerTask, 100, distanceEveryTime);
    }

    public class StatusSave{

        float widthX;
        float heightY;

        public float getWidthX() {
            return widthX;
        }

        public void setWidthX(float widthX) {
            this.widthX = widthX;
        }

        public float getHeightY() {
            return heightY;
        }

        public void setHeightY(float heightY) {
            this.heightY = heightY;
        }
    }
}
