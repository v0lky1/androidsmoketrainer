package com.v0lky1.smoketrainer.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.v0lky1.smoketrainer.models.Smoke;

public class CheckMarkViews extends View {
    private Paint greenPaint;
    private Paint blackPaint;
    private Paint redPaint;
    private Smoke smoke;

    public CheckMarkViews(Context context) {
        super(context);
        init();
    }

    public CheckMarkViews(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CheckMarkViews(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public CheckMarkViews(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void currentSmoke(Smoke smoke) {
        this.smoke = smoke;
    }

    public void init() {
        greenPaint = new Paint();
        blackPaint = new Paint();
        redPaint = new Paint();
        greenPaint.setColor(Color.GREEN);
        blackPaint.setColor(Color.BLACK);
        redPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        float height = getHeight();
        float width = getWidth();

        greenPaint.setStrokeWidth(7f);
        blackPaint.setStrokeWidth(10f);
        redPaint.setStrokeWidth(7f);

        if (smoke.isSeen()) {
            //tekend een vinkje
            canvas.drawLine(0.25f * width, 0.4f * height, 0.5f * width, 0.7f * height, blackPaint);
            canvas.drawLine(0.5f * width, 0.7f * height, width, 0.15f *height , blackPaint);
            canvas.drawLine(0.25f * width, 0.4f * height, 0.5f * width, 0.7f * height, greenPaint);
            canvas.drawLine(0.5f * width, 0.7f * height, width, 0.15f *height, greenPaint);
        } else if (!smoke.isSeen()) {
            //tekend een rood kruis
            canvas.drawLine(0.25f * width, 0.25f * height, 0.75f * width, 0.75f * height, blackPaint);
            canvas.drawLine(0.25f * width, 0.75f * height, 0.75f * width, 0.25f * height, blackPaint);
            canvas.drawLine(0.25f * width, 0.25f * height, 0.75f * width, 0.75f * height, redPaint);
            canvas.drawLine(0.25f * width, 0.75f * height, 0.75f * width, 0.25f * height, redPaint);
        }
    }
}
