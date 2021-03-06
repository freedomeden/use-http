package com.din.testhttp.express;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class TimeView extends View {

    private Random random;
    private int rgb;
    private String time;
    private Rect mBounds = new Rect();

    public TimeView(Context context) {
        super(context);
        initView();
    }

    public TimeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public TimeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        random = new Random();
        rgb = Color.rgb(100 + random.nextInt(155), 100 + random.nextInt(155), 100 + random.nextInt(155));
    }

    public void setTime(String time) {
        this.time = time;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(rgb);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, paint);

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);
        paint.getTextBounds(time, 0, time.length(), mBounds);
        float textWidth = mBounds.width();
        float textHeight = mBounds.height();
        canvas.drawText(time, getWidth() / 2 - textWidth / 2, getHeight() / 2 + textHeight / 2, paint);

        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 4, paint);

    }
}
